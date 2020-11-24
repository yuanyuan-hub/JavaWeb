import java.util.Scanner;

public class Main {
    public int count(int[] A, int n) {
        // write code here
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1+i; j < n ; j++) {
                if(A[i] > A[j]) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b = 0;
        while (sc.hasNext()) {
            a = sc.nextInt();
            if(a != 0) {
                System.out.println(a / 2);
            }
            b++;
            if(b > 10) {
                break;
            }
        }
        sc.close();
    }
}
