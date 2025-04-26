package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueue() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(int x){
        q1.add(x);
    }

    public int pop(){
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int top=q1.poll();

        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;

        return top;
    }

    public int top(){
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int top=q1.peek();

        q2.add(q1.poll());

        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;

        return top;

    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue s=new StackUsingQueue();
        s.push(5);
        s.push(2);
        s.push(4);

        System.out.println("Top: "+s.top());
        System.out.println("Pop: "+s.pop());
        System.out.println("Top: "+s.top());
    }
}
