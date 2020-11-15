import java.io.IOException;
import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/13
 * @Time 0:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String number[] = string.split(" ");
        int a = Integer.parseInt(number[0]);
        int b = Integer.parseInt(number[1]);
        System.out.println((a+b)%100);
    }


    public static void main2(String[] args) {
        int a = 40;
        int c = 212;
        int x = (-8+22)*a-10+c/2;
        System.out.println(x);
    }

    public static void main1(String[] args) throws IOException {
        char c = (char)System.in.read();
        System.out.println((int)c);
    }
}
