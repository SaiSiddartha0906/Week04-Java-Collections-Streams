import java.util.ArrayList;
import java.util.List;

abstract class CourseType{
    private String coursename;

    public CourseType(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursename() {
        return coursename;
    }

    abstract public void displayDetails();
}

class ExamCourse extends CourseType{
    private String Examname;

    public ExamCourse(String coursename, String examname) {
        super(coursename);
        Examname = examname;
    }

    public String getExamname() {
        return Examname;
    }

    @Override
    public void displayDetails() {
        System.out.println("Course Name : "+getCoursename());
        System.out.println("Exam Name : "+Examname);
    }
}

class AssignmentCourse extends CourseType{
    private int marks;

    public AssignmentCourse(String coursename, int marks) {
        super(coursename);
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public void displayDetails() {
        System.out.println("Course Name : "+getCoursename());
        System.out.println("Marks Obtained : "+marks);
    }
}

class ResearchCourse extends CourseType{
    private String Department;

    public ResearchCourse(String coursename, String department) {
        super(coursename);
        Department = department;
    }

    public String getDepartment() {
        return Department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Course Name : "+getCoursename());
        System.out.println("Department Name : "+Department);
    }
}

class Course<T extends CourseType>{
    List<T> courselist=new ArrayList<>();

    public List<? extends CourseType> getCourselist() {
        return courselist;
    }

    public void addCourse(T course){
        courselist.add(course);
    }

}
public class UniversityCourseManagement {
    public static void showAnyCourseList(List<? extends CourseType> list) {
        for (CourseType course : list) {
            course.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> examCatalog = new Course<>();
        examCatalog.addCourse(new ExamCourse("Data Structures", "MidTerm"));
        examCatalog.addCourse(new ExamCourse("Algorithms", "EndTerm"));


        Course<AssignmentCourse> assignmentCatalog = new Course<>();
        assignmentCatalog.addCourse(new AssignmentCourse("AI", 95));
        assignmentCatalog.addCourse(new AssignmentCourse("ML", 88));


        Course<ResearchCourse> researchCatalog = new Course<>();
        researchCatalog.addCourse(new ResearchCourse("Quantum Computing", "Physics"));
        researchCatalog.addCourse(new ResearchCourse("Neural Networks", "CS"));
    }
}
