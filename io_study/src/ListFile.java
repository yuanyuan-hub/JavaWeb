import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {
    public static void main(String[] args) {
        File dir = new File("D:\\Users\\袁媛\\Desktop\\bit");
        List<File> files = listDir(dir);
        //jdk1.8集合框架使用stream操作，可以使用lambda表达式
        files.stream()
                .forEach(System.out::println);
    }
    public static List<File> listDir(File dir) {
        List<File> list = new ArrayList<>();
        if(dir.isFile()){
            list.add(dir);
        } else if (dir.isDirectory()){
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

    public static List<File> listDir2(File dir) {
        List<File> list = new ArrayList<>();
        File[] children = dir.listFiles();
            if(children != null) {
                for(File child : children) {
                    //返回的文件列表不包含文件夹
//                    if(child.isDirectory()){
//                        list.addAll(listDir2(child));
//                    } else  {
//                        list.add(child);
//                    }
                    list.add(child);
                    if(child.isDirectory()){
                        list.addAll(listDir2(child));
                    }
                }
            }
            return list;

        //return null;
    }
}
