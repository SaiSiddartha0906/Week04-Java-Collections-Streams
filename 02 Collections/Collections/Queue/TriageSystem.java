package Queue;

import java.util.PriorityQueue;
class Patient{
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String toString() {
        return name + " (Severity: " + severity + ")";
    }



}
public class TriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> q=new PriorityQueue<>((a, b)-> b.severity- a.severity);

        q.add(new Patient("Jhon", 3));
        q.add(new Patient("Alice", 5));
        q.add(new Patient("Bob",2));

        System.out.println("Treatment Order");
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

    }
}
