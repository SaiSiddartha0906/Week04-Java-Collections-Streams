package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseAList {
    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> list){
        ArrayList<Integer> reversed=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list){
        LinkedList<Integer> reversed=new LinkedList<>();
        for(int i=list.size()-1;i>= 0;i--){
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        System.out.println("Original ArrayList: "+arrayList);
        ArrayList<Integer> reverseddArrayList= reverseArrayList(arrayList);
        System.out.println("reversed arraylist: "+reverseddArrayList);

        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        System.out.println("original Linked list"+linkedList);
        LinkedList<Integer> reversedLinkedList= reverseLinkedList(linkedList);
        System.out.println("reversed linked list: "+reversedLinkedList);


    }
}
