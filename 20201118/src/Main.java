import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/18
 * @Time 0:33
 */
public class Main {
    public static void main(String[] args) {
        int i = 10000;
        for ( i = 10000; i < 100000; i++) {
            if(sum(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean sum(int i) {
        int a1 = (i/10000)*(i%10000);
        int a2 = (i/1000)*(i%1000);
        int a3 = (i/100)*(i%100);
        int a4 = (i/10)*(i%10);
        if(a1+a2+a3+a4 == i) {
            return true;
        } else {
            return false;
        }
    }

    public static void main1(String[] args) {
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
