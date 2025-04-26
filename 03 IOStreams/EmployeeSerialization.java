package IOStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }
}

public class EmployeeSerialization {

    private static final String FILE_NAME = "employees.ser";

    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alice", 101));
        employeeList.add(new Employee("Bob", 102));

        serializeEmployees(employeeList);

    
        List<Employee> deserializedList = deserializeEmployees();
        System.out.println("Deserialized Employees:");
        for (Employee emp : deserializedList) {
            System.out.println(emp);
        }
    }
}

