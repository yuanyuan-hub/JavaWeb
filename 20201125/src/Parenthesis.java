import java.util.*;

//括号匹配问题
public class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        int count = 0;
        if(n %2 == 1) {
            return false;
        }
        char[] arr = A.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != '(' && arr[i] != ')') {
                return false;
            }
            if(arr[i] == '(') {
                count ++;
            }
        }
        if(count == n/2); {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = str.length();
        System.out.println(chkParenthesis(str, n));
    }
}