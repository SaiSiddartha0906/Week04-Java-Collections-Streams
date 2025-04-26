package Map;

import java.util.*;

class Employee{
    String name;
    String dept;

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public String toString(){
        return name;
    }

    public String getDept() {
        return dept;
    }

}
public class GroupObjects{
    public static Map<String, List<Employee>> group(List<Employee> employees){
        Map<String, List<Employee>> map=new HashMap<>();

        for(Employee emp:employees){
            map.computeIfAbsent(emp.getDept(),k->new ArrayList<>()).add(emp);
        }
        return map;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> result = group(employees);

        for (Map.Entry<String, List<Employee>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
}}
