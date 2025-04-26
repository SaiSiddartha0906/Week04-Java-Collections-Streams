package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeDuplicates {

    public static void main(String[] args) {
        List<Integer> input= Arrays.asList(3,1,2,2,3,4);

        List<Integer> output=remDup(input);
        System.out.println("List after removing Duplicates: "+output );
    }

    public static List<Integer> remDup(List<Integer> input){
        List<Integer> result=new ArrayList<>();

        for(Integer element:input){
            if(!result.contains(element)){
                result.add(element);
            }
        }
        return result;
    }
}
