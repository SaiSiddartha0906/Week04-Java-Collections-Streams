package List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NthElementFromEnd {
    public static void main(String[] args) {
        LinkedList<Character> input=new LinkedList<>(Arrays.asList('A','B','C','D','E'));
        int size=input.size();
        int n=2;
        Character output=todo(input,n);
        System.out.println("Initial List: "+input);
        System.out.println("The last 2nd element is: "+output);
    }

    public static Character todo(List<Character> input,int n){
        ListIterator<Character> first=input.listIterator();
        ListIterator<Character> second=input.listIterator();

        for(int i=0;i<n;i++){
            if(!first.hasNext()){
                return null;
            }
            first.next();
        }
        while(first.hasNext()){
            first.next();
            second.next();
        }
        return second.next();

    }
}
