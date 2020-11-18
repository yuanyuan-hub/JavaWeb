import java.util.Scanner;

/**
 * @Author 袁媛
 * @Date 2020/11/19
 * @Time 0:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        int x = 0;
        while ((str = sc.next()) != null)
            x = Integer.parseInt(str);
           if(x >= 60) {
               System.out.println("Pass");
           } else {
               System.out.println("Fail");
           }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x >= 90 && x <= 100) {
            System.out.println("Perfect");
        }
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        //char[] c = str.toCharArray();
        int a = 0;
        for(char c: str.toCharArray()) {
            if (c == 'A') {
                a++;
            }
        }
            if(a > str.length()-a) {
                System.out.println("A");
            } else if(a < str.length()-a) {
                System.out.println("B");
            } else {
                System.out.println("E");
            }
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("\\.");
        int value = Integer.parseInt(arr[0]);
        int num = value%10;
        System.out.println(num);
    }
}
