package Map;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1=new HashMap<>();
        Map<String, Integer> map2=new HashMap<>();

        map1.put("A",1);
        map1.put("B",2);

        map2.put("B",3);
        map2.put("C",4);

        Map<String, Integer> map = Merge(map1, map2);
        System.out.println("Merged Maps: "+map);
    }

    public static Map<String, Integer> Merge(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> result=new HashMap<>(map1);

        for(Map.Entry<String, Integer> entry:map2.entrySet()){
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return result;
    }
}
