import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {
    public static void main(String[] args) {
        File dir = new File("D:\\Users\\袁媛\\Desktop\\bit\\JAVA\\MySQL＋JavaEE");
        List<File> files = listDir2(dir);
        files.stream()
                .forEach(System.out::println);
    }

    /*public static List<File> listDir(File dir) {
        List<File> list = new ArrayList<>();
        if(dir.isFile()){
            list.add(dir);
        } else if(dir.isDirectory()) {
            File[] children = dir.listFiles();
            if(children != null) {
                for(File child : children) {
                   List<File> files = listDir(child);
                   list.addAll(files);
                }
            }
        }
        return list;
    }

     */

    public static List<File> listDir2(File dir) {
        List<File> list = new ArrayList<>();
        if(dir.isDirectory()){
            //获取目录下一级的子文件、子文件夹
            File[] children = dir.listFiles();
            if(children != null) {
                for(File child : children) {
                    //如果是子文件夹，就再次递归，获取子文件夹下一级
                    if(child.isDirectory()) {
                        list.addAll(listDir2(child));
                    } else {
                        list.add(child);
                    }
                }
            }
        }
        return list;
    }
}
