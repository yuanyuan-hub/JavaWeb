import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n+1][m+1];
        int a = 0,b = 0,max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = scanner.nextInt();
                if(arr[i][j] > max) {
                    max = arr[i][j];
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(a+" "+b);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[2];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int n = a[0];
        int m = a[1];

        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main1(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        int[] score = new int[5];
        while((str=br.readLine())!=null)
        {
            int sum = 0;
            String[] a = str.split(" ");
            for (int i=0;i<5;i++) {
                score[i] = (int) (Float.parseFloat(a[i])*10);
                sum+=score[i];
            }
            for(int temp : score) {
                System.out.print(temp/10+"."+temp%10+" ");
            }
            System.out.println(sum/10+"."+sum%10);
        }
    }
}

