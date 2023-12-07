import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String password;
    private ArrayList<CourseInfo> registeredCourses;

    public Student(int id, String name, String email, String password){
        this.studentId = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registeredCourses = new ArrayList<CourseInfo>();
    }

    public int getStudentId(){
        return this.studentId;
    }

    public String getEmail(){
        return this.email;
    }

    public String getName(){
        return this.name;
    }

    
    public boolean resetPassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        } else {
            return false;
        }
    }
        
    public void registerCourse(CourseInfo course) {
        this.registeredCourses.add(course);
    }
        
    public void removeCourse(int courseId) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            CourseInfo course = registeredCourses.get(i);
            if (Integer.valueOf(course.getId()) == courseId) {
                registeredCourses.remove(i);
                break;
            }
        }
    }
    
    public void viewRegisteredCourses() {
        if (registeredCourses.size() == 0) {
            System.out.println("No registered courses.");
            return;
        }

        System.out.println("Registered Courses:");
        for (CourseInfo course : registeredCourses) {
            System.out.println("Course ID: " + course.getId() + ", Course Name: " + course.getName());
        }
    }
    
    public CourseInfo searchCourseById(int id) {
        for (CourseInfo course : this.registeredCourses) {
            if (Integer.valueOf(course.getId()) == id) {
                return course;
            }
        }
        return null;
    }
        
    public CourseInfo searchCourseByName(String name) {
        for (CourseInfo course : this.registeredCourses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }
}
