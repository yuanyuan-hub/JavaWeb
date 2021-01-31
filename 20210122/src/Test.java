import java.util.*;

public class Test{

}

class Solution {

    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if((A[i] % 2 == 1) && (A[j] % 2 == 0)){
                int temp = 0;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else if(A[i] % 2 == 0){
                i++;
            } else {
                j++;
            }
        }
        return A;
    }
}