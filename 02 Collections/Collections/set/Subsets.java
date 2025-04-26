package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subsets {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(2,3));
        Set<Integer> set2=new HashSet<>(Arrays.asList(1,2,3,4));

        boolean result=subset(set1,set2);
        System.out.println(result);
    }

    public static boolean subset(Set<Integer> set1, Set<Integer> set2){
        if(set2.containsAll(set1)){
            return true;
        }
        return false;
    }
}
