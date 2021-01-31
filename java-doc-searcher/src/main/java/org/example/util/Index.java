package org.example.util;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.example.model.DocInfo;
import org.example.model.Weight;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 构建索引：
 * 正排索引：从本地文件数据中读取到java内存
 * 倒排索引：构建Map<String,List<信息>>(类似数据库hash索引)
 * Map键：关键词（分词来做）
 * Map值：信息：
 * ① docInfo对象引用或是docInfo的id，
 * ② 权重（标题对应关键词数量 *10 +正文对应关键词数量*1（可以自己调整）
 * ③ 关键词（待定）
 */
public class Index {
    //正排索引
    private static final List<DocInfo> FORWARD_INDEX = new ArrayList<>();
    //倒排索引
    private static final Map<String,List<Weight>> INVERTED_INDEX = new HashMap<>();

    /**
     * 构建正排索引的内容，从本地raw_data.txt读取并保存
     */
    public static void buildForwardIndex() throws FileNotFoundException {
        try {
        FileReader fr = new FileReader(Parser.RAW_DATA);
        BufferedReader br = new BufferedReader(fr);
        int id = 0;//行号设置为docInfo的id
        String line;
            while ((line = br.readLine() )!= null){
                if(line.trim().equals(""))continue;
                //一行是对应一个docInfo对象，类似数据库一行数据对应java对象
                DocInfo doc = new DocInfo();
                doc.setId(++id);
                String[] parts = line.split("\3");//按\3间隔符来切分
                doc.setTitle(parts[0]);
                doc.setUrl(parts[1]);
                doc.setContent(parts[2]);
                //添加到正排索引
                FORWARD_INDEX.add(doc);
            }
        } catch (IOException e) {
            //不要吃异常，初始化操作有异常让线程不捕获异常，从而结束程序
            //初始化（启动Tomcat）,有问题，尽早暴露问题
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建倒排索引：从java内存中正排索引获取文档信息来构建
     */
    public static void buileInvertedIndex(){
        for(DocInfo doc : FORWARD_INDEX){
            /**
             * doc+分词，对应 weight 对象
             * 一个doc，分别对标题和正文分词，每一个分词生成一个weight，需要就算权重
             * 如标题为：清华大学 计算机 专业 使用 计算机 炒菜
             * 第一次出现的关键词，要new Weight对象，之后出现要获取的关键词时，就更新权重
             * 实现逻辑：先构造一个HashMap，保存分词（键）和weight对象（value）
             */
            Map<String,Weight> cache = new HashMap<>();
            List<Term> titleFencis = ToAnalysis.parse(doc.getTitle()).getTerms();
            for(Term titleFenci : titleFencis) {//标题分词遍历处理
                //获取标题分词键对应的weight对象
                Weight w = cache.get(titleFenci.getName());
                if(w == null){//如果没有就创建一个并放到Map中
                    w = new Weight();
                    w.setDoc(doc);
                    w.setKeyword(titleFenci.getName());
                    cache.put(titleFenci.getName(),w);
                }
                //标题分词权重加10
                w.setWeight(w.getWeight() + 10);
            }
            List<Term> contentFencis = ToAnalysis.parse(doc.getContent()).getTerms();
            for(Term contentFenci : contentFencis) {
                Weight w = cache.get(contentFenci.getName());
                if(w == null){
                    w = new Weight();
                    w.setDoc(doc);
                    w.setKeyword(contentFenci.getName());
                    cache.put(contentFenci.getName(),w);
                }
                //正文分词，权重加1；
                w.setWeight(w.getWeight() + 1);
            }
            //把临时保存的Map数据（keyword-weight）全部保存到倒排索引
            for(Map.Entry<String,Weight> e : cache.entrySet()) {
                String keyword = e.getKey();
                Weight w = e.getValue();
                //更新保存到倒排索引Map<String,List<Weight>> --> 多个文档同一个关键词保存在一个List里面
                //现在倒排索引中，通过keyword获取已有的值
                List<Weight> weights = INVERTED_INDEX.get(keyword);
                if(weights == null){//如果拿不到就创建一个，并存放进倒排索引
                    weights = new ArrayList<>();
                    INVERTED_INDEX.put(keyword,weights);
                }
 //               System.out.println(keyword + ": (" + w.getDoc().getId() + ","+ w.getWeight()+")");
                weights.add(w);//倒排中，添加当前文档每个分词对应的weight对象
            }
        }
    }

    //通过滚见此分词在倒排
    public static List<Weight> get(String keyword){
        return INVERTED_INDEX.get(keyword);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Index.buildForwardIndex();
//        //测试正排索引
//        FORWARD_INDEX
//                .stream()
//                .forEach(System.out::println);
        //根据正排索引构建倒排
        Index.buileInvertedIndex();
        //测试倒排索引
        for(Map.Entry<String,List<Weight>> e : INVERTED_INDEX.entrySet()) {
            String keyword = e.getKey();
            System.out.print(keyword+": ");
            //不校验weight中的doc对象，正排索引已经测试过
            List<Weight> weights = e.getValue();
            weights.stream()
                    .map(w->{//map操作：把List中每一个对象转换为其他对象
                        return "（"+w.getDoc().getId()+","+w.getWeight() +"）";
                    })//转换完，会变为List<String>
//                   .collect(Collectors.toList());//返回List<String>
                    .forEach(System.out::print);
            System.out.println();
        }
    }
}
