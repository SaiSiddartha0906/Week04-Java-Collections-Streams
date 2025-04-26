package set;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

    public static HashSet<Integer> union(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> hash=new HashSet<>();
        for(Integer num:set1){
            hash.add(num);
        }
        for(Integer num:set2){
            if(!hash.contains(num)){
                hash.add(num);
            }
        }
        return hash;
    }

    public static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2){
        HashSet<Integer> hash=new HashSet<>();
        for(Integer num:set1){
            if(set2.contains(num)){
                hash.add(num);
            }
        }
        return hash;
    }
    public static void main(String[] args) {
        HashSet<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> set2=new HashSet<>(Arrays.asList(3,4,5));

        HashSet<Integer> union=union(set1,set2);
        HashSet<Integer> intersection=intersection(set1,set2);

        System.out.println("Set after union: "+union);
        System.out.println("Set after Intersection: "+intersection);

    }
}
