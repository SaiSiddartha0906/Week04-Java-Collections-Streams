package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println("original Queue: "+q);
        q=reverse(q);
        System.out.println("Reversed Queue: "+q);

    }
    public static Queue<Integer> reverse(Queue<Integer> q){
        if(q.isEmpty()){
            return null;
        }

        int front=q.poll();
        reverse(q);
        q.offer(front);

        return q;

    }
}
