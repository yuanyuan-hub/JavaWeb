import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A1 = 0,A2 = 0,A3 = 0,A5=0;
        float A4 = 0;
        int a = 1;
        int count = 0;
        int x = 0;
        int max = 0;
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n;i++) {
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n ; i ++) {
                if((arr[i] % 5 == 0) && arr[i] % 2 == 0){
                    A1 += arr[i];
                }
                if(arr[i] % 5 == 1) {
                    A2 += a*arr[i];
                    a *= -1;
                }
                if(arr[i] %5 == 2){
                    A3++;
                }
                if(arr[i] %5 == 3){
                    count++;
                    x += arr[i];
                }
                if (arr[i] %5 == 4) {
                    if(arr[i] > max){
                        max = arr[i];
                    }
                }
            }
            if(count != 0) {
                A4 =(float) x/count;
            }
            A5 = max;
            System.out.print(A1 +" "+ A2+" "+ A3+" ");
            System.out.printf("%.1f",A4);
            System.out.println(" "+A5);

        }
    }
}