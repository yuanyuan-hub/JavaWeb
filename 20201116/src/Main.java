import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/16
 * @Time 0:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String number[] = string.split(" ");
        double a = Double.parseDouble(number[0]);
        double b = Double.parseDouble(number[1]);
        double c = Double.parseDouble(number[2]);
        double p = (a+b+c)/2;
        System.out.printf("circumference=%.2f area=%.2f",a+b+c,Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String number[] = string.split(" ");
        double weight = Double.parseDouble(number[0]);
        double height = Double.parseDouble(number[1]);
        double bmi = weight / ((height / 100)*(height / 100));
        System.out.printf("%.2f",bmi);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String number[] = string.split(" ");
        double a = Double.parseDouble(number[0]);
        double b = Double.parseDouble(number[1]);
        double c = Double.parseDouble(number[2]);
        System.out.printf("%.2f %.2f",a+b+c,(a+b+c)/3);
    }
}
