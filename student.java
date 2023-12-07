import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String password;
    private ArrayList<CourseInfo> registeredCourses;

    public Student(int id, String name, String email, String password){
        studentId = id;
        name = name;
        email = email;
        registeredCourses = new ArrayList<>();
    }

    public int getStudentId{
        return studentId;
    }

    public String getStudentEmail{
        return email;
    }

    public String getStudentName{
        return name;
    }

}
