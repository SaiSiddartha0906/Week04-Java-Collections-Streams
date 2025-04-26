package IOStreams;

import java.io.*;
import java.util.*;

class Student {
    private int rollNumber;
    private String name;
    private double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Roll: %d | Name: %-15s | GPA: %.2f", 
                           rollNumber, name, gpa);
    }


    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
}

public class StudentDataStorage {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice Johnson", 3.8));
        students.add(new Student(102, "Bob Smith", 3.5));
        students.add(new Student(103, "Carol Williams", 3.9));

        try {

            writeStudents(students);

            List<Student> retrieved = readStudents();
            System.out.println("Retrieved Students:");
            retrieved.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void writeStudents(List<Student> students) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(FILE_NAME))) {
            
            for (Student student : students) {
                dos.writeInt(student.getRollNumber());
                dos.writeUTF(student.getName());
                dos.writeDouble(student.getGpa());
            }
        }
    }

    private static List<Student> readStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(FILE_NAME))) {
            
            while (true) {
                try {
                    int roll = dis.readInt();
                    String name = dis.readUTF();
                    double gpa = dis.readDouble();
                    students.add(new Student(roll, name, gpa));
                } catch (EOFException e) {
                    break; 
                }
            }
        }
        return students;
    }
}
