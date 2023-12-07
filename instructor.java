import java.util.ArrayList;
import java.util.Scanner;

public class Instructor {
    private String name;
    private String password;
    private ArrayList<CourseInfo> allClasses;

    public Instructor(String name, String password){
        name = name;
        password = password;
        //need to add allclass arraylist
        allClasses = new ArrayList<CourseInfo>();
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public ArrayList getAllClasses(){
        return allclass;
    }

    public static addCourses(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the course:");
        String name = scanner.nextLine();

        System.out.println("Enter the status of the course:");
        String status = scanner.nextLine();

        System.out.println("Enter the location of the course:");
        String location = scanner.nextLine();

        System.out.println("Enter the start time of the course:");
        String startTime = scanner.nextLine();

        System.out.println("Enter the end time of the course:");
        String endTime = scanner.nextLine();

        System.out.println("Enter the description of the course:");
        String description = scanner.nextLine();

        System.out.println("Enter the name of the professor of the course:");
        String professor = scanner.nextLine();

        CourseInfo newCourse = new CourseInfo(name, status, location, startTime, endTime,description, professor)
        allClasses.add(newCourse);
    }


}