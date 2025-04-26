package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryCodes {
    public static void main(String[] args) {
        int N=5;
        Queue<String> q=new LinkedList<>();
        q=Binary(N);
        System.out.println(q);
    }

    public static Queue<String> Binary(int N){
        Queue<String> q=new LinkedList<>();
        for(int i=1;i<=N;i++){
            q.offer(Integer.toBinaryString(i));
        }
        return q;
    }
}
