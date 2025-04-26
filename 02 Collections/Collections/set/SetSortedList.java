package set;

import java.util.*;

public class SetSortedList {
    public static void main(String[] args) {
        Set<Integer> input=new HashSet<>(Arrays.asList(5,3,9,1));
        List<Integer> result=sort(input);
        System.out.println("Sorted List is: "+result);
    }
    public static List<Integer> sort(Set<Integer> input){
        List<Integer> list=new ArrayList<>(input);
        Collections.sort(list);

        return list;
    }
}
