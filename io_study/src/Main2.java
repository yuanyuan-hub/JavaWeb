//import java.util.*;
//
//public class Main2{
//    public static void main(String[] args{
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            for(int i = 0; i < n;i++) {
//                for(int j = 0; j < n; j++) {
//                    if(i == 0 && j == 0) {
//                        System.out.printf("*");
//                    } else if(i == n && j == n) {
//                        System.out.printf("*");
//                    } else {
//
//                    }
//                }
//            }
//        }
//    }
//}

import java.util.*;

public class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            switch (n){
                case 200:
                    System.out.println("OK");
                    break;
                case 202:
                    System.out.println("Accepted");
                    break;
                case 400:
                    System.out.println("Bad Request");
                    break;
                case 403:
                    System.out.println("Forbidden");
                    break;
                case 404:
                    System.out.println("Not Found");
                    break;
                case 500:
                    System.out.println("Internal Server Error");
                    break;
                case 502:
                    System.out.println("Bad Gateway");
                    break;
                //default:
            }
        }
    }
}