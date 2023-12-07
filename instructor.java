import java.util.ArrayList;
import java.util.Scanner;

public class Instructor {
    private String name;
    private String password;
    private ArrayList<CourseInfo> allClasses;

    public Instructor(String name, String password){
        this.name = name;
        this.password = password;
        //need to add allclass arraylist
        this.allClasses = new ArrayList<CourseInfo>();
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public ArrayList<CourseInfo> getAllClasses(){
        return this.allClasses;
    }

    public void addCourses(){
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
        this.allClasses.add(newCourse);
    }

    public void viewCourses(){
        for (CourseInfo course: this.allClasses){
            System.out.println(course);
        }
    }

    public void removeCourses(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the course you want to edit:");
        String name = scanner.nextLine();

        scanner.close();
        for(int i =0;i<allClasses.size();i++){
            CourseInfo temp = allClasses.get(i);
            if (temp.getName().equals(name)){
                allClasses.remove(i);
                return;
            }
        }

        System.out.println("Course not found");
    }

    //change status, name 
    public void editCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the course you want to edit:");
        String oldName = scanner.nextLine();

        System.out.println("Enter the new name of the course you want to edit:");
        String newName = scanner.nextLine();

        System.out.println("New status:");
        String newStatus = scanner.nextLine();

        System.out.println("New location:");
        String newLocation = scanner.nextLine();

        System.out.println("Description:");
        String newDescription = scanner.nextLine();

        System.out.println("New Start time:");
        String newStartTime = scanner.nextLine();

        System.out.println("New End time:");
        String newEndTime = scanner.nextLine();

        scanner.close();
        for (CourseInfo course : this.allClasses) {
            if (course.getName().equals(oldName)) {
                course.setName(newName); 
                course.setStatus(newStatus); 
                course.setLocation(newLocation);
                course.setStartTime(newStartTime);
                course.setEndTime(newEndTime);
                course.setDescription(newDescription); 
                System.out.println("Course updated successfully");
                return;
            }
        }

    }

}