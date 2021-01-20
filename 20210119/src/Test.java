public class Test {
    public static void main(String[] args) {
        System.out.println(switchit(4));
    }

    public static int switchit(int x){
        int j = 1;
        switch (x){
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return j+x;
    }
}
