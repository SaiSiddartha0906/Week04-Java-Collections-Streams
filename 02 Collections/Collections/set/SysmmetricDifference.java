package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SysmmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3,4));
        Set<Integer> set2=new HashSet<>(Arrays.asList(3,4,5,6,7));

        Set<Integer> symDiff=new HashSet<>();
        symDiff= symDiff(set1,set2);
        System.out.println("Final Set: "+symDiff);
    }

    public static Set<Integer> symDiff(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> union=new HashSet<>(set1);
        Set<Integer> intersection=new HashSet<>(set1);


        union.addAll(set2);
        intersection.retainAll(set2);
        union.removeAll(intersection);

        return union;
    }
}
