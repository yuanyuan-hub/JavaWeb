import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            for(int i = 0; i < str.length();i++) {
                char[] chars = str.toCharArray();
                if(chars[i] >= 'F' && str.charAt(i) <= 'Z') {
                    chars[i] -= 5;
                }
                else if(chars[i] == 'A'){
                    chars[i] = 'V';
                }
                else if(chars[i] == 'B'){
                    chars[i] = 'W';
                }
                else if(chars[i] == 'C'){
                    chars[i] = 'X';
                }
                else if(chars[i] == 'D'){
                    chars[i] = 'Y';
                }
                else if(chars[i] == 'E'){
                    chars[i] = 'Z';
                } else {
                    chars[i] = ' ';
                }
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        System.out.println(getTotalCount(month));
    }

    public static int getTotalCount(int monthCount){
        if(monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount-2);
    }
}