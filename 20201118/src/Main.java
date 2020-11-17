import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/18
 * @Time 0:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String number[] = str.split(" ");
        double price = Double.parseDouble(number[0]);
        int month = Integer.parseInt(number[1]);
        int day = Integer.parseInt(number[2]);
        int y = Integer.parseInt(number[3]);
        if ((month == 11 && day == 11) || (month == 12 && day == 12)) {
            price *= (month - 4) / 10.0;
        }
        if (y == 1) {
            price = (price - 50) >= 0 ? price - 50 : 0;
        }
        System.out.println(String.format("%.2f", price));
    }
}
