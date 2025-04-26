package set;

import java.util.Arrays;
import java.util.HashSet;

public class checkEqual {
    public static void main(String[] args) {
        HashSet<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> set2=new HashSet<>(Arrays.asList(2,4,1));

        if(set1.containsAll(set2)){
            System.out.println("True");
        }
        return;
    }
}
