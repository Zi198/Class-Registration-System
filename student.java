import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private static int number;
    private int studentId;
    private String name;
    private String email;
    private String password;
    private ArrayList<CourseInfo> registeredCourses;

    Student(){
        studentId = -1;
        name = "";
        email = "";
        password = "";
    }

    Student(int id, String name, String email, String password){
        this.studentId = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registeredCourses = new ArrayList<CourseInfo>();
    }

    Student(String name, String email, String password){
        this(number, name,email,password);
        Student.number++;
    }

    public static void setTotal(int value){
        Student.number =value;
        return;
    }

    public static int getNumber(){
        return Student.number;
    }

    public static Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        Student temp = new Student(name,email,password);
        scanner.close();
        return temp;
    }

    public boolean login(String password){
        if (password.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }

    public String inFile(){
        String word = "";
        word = word+Integer.valueOf(this.studentId)+"|"+this.name+"|"+this.email+"|"+this.password;
        for (int i = 0;i<this.registeredCourses.size();i++){
            word = word+"|"+this.registeredCourses.get(i).getId();
        }
        word = word+"\n";
        return word;
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
        
    public boolean removeCourse(int courseId) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            CourseInfo course = registeredCourses.get(i);
            if (Integer.valueOf(course.getId()) == courseId) {
                registeredCourses.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void viewRegisteredCourses() {
        if (registeredCourses.size() == 0) {
            System.out.println("No registered courses.");
            return;
        }

        System.out.println("Registered Courses:");
        System.out.println();
        for (CourseInfo course : registeredCourses) {
            System.out.println(course);
            System.out.println();
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

    public String toString(){
        String word = "";
        word = word+"ID: "+this.studentId+"\n";
        word = word+"Name: "+this.name+"\n";
        word = word +"Email: "+this.email+"\n";
        return word;
    }
}
