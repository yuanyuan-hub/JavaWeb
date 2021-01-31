import java.util.*;

public class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            int count = 0;
            LinkedList<Character> list = new LinkedList<Character>();
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                list.add(ch);
            }
            for (int i = 0; i < s2.length(); i++) {
                char ch = s2.charAt(i);
                for (int j = 0; j < list.size(); j++) {
                    if(ch == list.get(j)){
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if(count == s2.length()) {
                System.out.println("Yes" + " " + (s1.length() - count));
            } else {
                System.out.println("No" + " " + (s2.length() - count));
            }
        }
    }
}