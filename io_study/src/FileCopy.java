import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //文件复制
        File input = new File("D:\\Users\\袁媛\\Desktop\\旧词。\\2019职规袁媛.doc");
        File output = new File("D:\\Users\\袁媛\\Desktop\\2019职规袁媛.doc");
        if(!output.exists()){
            output.createNewFile();
        }

        //定义输入输出流
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);
        long start = System.currentTimeMillis();
        byte[] bytes = new byte[1024*8];
        int len;
        //每次从输入流读取到byte【】的内容，直到输出到某个文件，就是剩余
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        fos.close();
        fis.close();

        //可以使用缓冲的字节输入流，缓冲字节输出流来复制
     //   new BufferedInputStream(new FileInputStream());
        //   new BufferedOutputStream(new FileOutputStream());
    }
}
