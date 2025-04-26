package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateElements {

    public static List<Integer> rotate(List<Integer> input,int roatateBy){
        int size=input.size();
        roatateBy=roatateBy%size;

        List<Integer> list=new ArrayList<>();
        list.addAll(input.subList(roatateBy,size));
        list.addAll(input.subList(0,roatateBy));

        return list;
    }
    public static void main(String[] args) {
        List<Integer> input= Arrays.asList(10,20,30,40,50);

        List<Integer> output=rotate(input,2);
        System.out.println("Rotated List: "+output);
    }
}
