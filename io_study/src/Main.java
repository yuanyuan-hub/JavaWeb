import java.util.*;

public class Main{
    public static void main(String[] args) {
        /*
        int i = 7;
        do{
            System.out.println(--i);
            --i;
        } while (i != 0);
        System.out.println(i);

         */
        int i = 2;
        System.out.println(getValue(i));
    }

    private static int getValue(int i) {
        int result = 0;
        switch (i){
            case 1:
                result = result + i;
            case 2:
                result = result + 2 * i;
            case 3:
                result = result + 3 * i;
        }
        return result;
    }
}