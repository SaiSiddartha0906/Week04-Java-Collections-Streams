package Map;

import java.util.HashMap;
import java.util.Map;

public class HighKey {
    public static void main(String[] args) {
        Map<String, Integer> input=new HashMap<>();
        input.put("A",10);
        input.put("B",15);
        input.put("C",5);

        String result=findMax(input);
        System.out.println("Key with max value: "+result);
    }

    public static String findMax(Map<String, Integer> input){
        String maxKey=null;
        int maxValue=Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry:input.entrySet()){
            if(entry.getValue()>maxValue){
                maxValue=entry.getValue();
                maxKey=entry.getKey();
            }
        }
        return maxKey;
    }
}
