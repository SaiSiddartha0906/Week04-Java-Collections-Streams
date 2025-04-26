package List;

import java.util.*;

public class FreqOfElements {

    public static Map<String, Integer> result(List<String> list){
        Map<String,Integer> freqMap=new HashMap<>();

        for(String item:list){
            if(freqMap.containsKey(item)){
                freqMap.put(item,freqMap.get(item)+1);
            }else{
                freqMap.put(item,1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> input= Arrays.asList("apple","banana","apple","orange");
        Map<String,Integer> freq=result(input);
        System.out.println("Frequrncy Map: "+freq);
    }
}
