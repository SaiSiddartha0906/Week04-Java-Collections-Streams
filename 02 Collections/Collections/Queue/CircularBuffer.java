package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class CircularBuffer {
    public static Queue<Integer> todo(Queue<Integer> q,int bufferSize, int insert){
        if(q.size()<bufferSize){
            q.offer(insert);

        }else{
            q.poll();
            q.offer(insert);
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        int bufferSize=3;
        q.offer(1);
        q.offer(2);
        q.offer(3);

        int insert=4;
        q=todo(q,bufferSize,insert);
        System.out.println("Buffer: "+q);
    }
}
