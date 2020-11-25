import java.util.Scanner;


//读入一个字符串，输出字符串str中的连续字符数字串
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <='9' && arr[i] >= '0') {
                int count  = 1;
                int index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] <= '9' && arr[j] >= '0') {
                        count ++;
                        index = j;
                    } else {
                        break;
                    }
                    if(count > res.length()) {
                        res = str.substring(i,index + 1);
                    }
                }
            } else {
                continue;
            }
        }
        System.out.println(res);
    }
}
