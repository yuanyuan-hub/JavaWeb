import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] gifts = {1,2,3,2,2};
        int n = 5;
        System.out.println(getValue(gifts,n));
    }

    public static int getValue(int[] gifts, int n) {
        // write code here
        int m = n/2;
        int count = 0;
        for(int i = 0; i < n;i++) {
            for(int j = 0; j < n;j++) {
                if(gifts[i] == gifts[j]){
                    count++;
                }
            }
            if(count > m) {
                return gifts[i];
                //break;
            }
            count = 0;
        }
        return 0;
    }
}