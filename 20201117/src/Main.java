import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/16
 * @Time 23:11
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null){
            System.out.println(str.toLowerCase());
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str.toLowerCase());
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double v = (4*3.1415926*r*r*r)/3;
        System.out.printf("%.3f",v);
    }
}
