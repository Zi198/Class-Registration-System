import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private List<ClassInfo> registeredClasses;

    public Student(int id, String name, String email ){
        studentId = id;
        name = name;
        email = email;
        registeredClasses = new List<>();
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