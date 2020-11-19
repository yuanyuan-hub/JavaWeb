import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/20
 * @Time 0:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        while ((string = scanner.nextLine()) != null) {
            int x = Integer.parseInt(string);
            System.out.println(x % 2 == 0 ? "Even":"Odd");
        }
    }
}
