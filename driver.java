import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class driver{
    
    static ArrayList<CourseInfo> allCourses;
	static ArrayList<Student> allStudents;

    public static void main(String[] args) throws IOException {


		collectCourses();
		// Student test = new Student(0,"Helios","xh2376@nyu.edu","123456");
		// test.registerCourse(allCourses.get(0));
		// test.viewRegisteredCourses();
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Please choose you account type:");
			System.out.println("1. Student Account");
			System.out.println("2. Instructor Account");
			System.out.println("Choose '3' to exits");
			int option = Integer.valueOf(scanner.nextLine());
			if (option==1){
				studentMode();
			}
			else if (option==2){
				instructorMode();
			}
			else if (option==3){
				break;
			}
			else{
				System.out.println("Enter the wrong option. Please enter again.");
			}
		}
		scanner.close();
		saveCourses();
    }

	public static Student studentMode(){
		Scanner scan  = new Scanner(System.in);
		System.out.println("Please choose your operation:");
		System.out.println("1. Create a new student account");
		System.out.println("2. Login in an existing student account");
		System.out.println("Enter '3' to exit to the last place");
		int option = Integer.valueOf(scan.nextLine());
		while(true){
			if (option==1){
				Student temp = Student.createStudent()
				allStudents.add(temp);
				System.out.println("Account create succefully!");
				return(temp);
			}
			else if (option==2){
				if (allStudents.size()==0){
					System.out.println("Sorry, there is no existing account!");
					return null;
				}
				System.out.println("Please enter your Id: ");
				int id = Integer.valueOf(scan.nextLine());
				System.out.println("Please enter your password: ");
				String password = scan.nextLine();
				for (Student student: allStudents){
					boolean status = false;
					if (student.getStudentId()==id){
						status = student.login(password);
					}
					if (status == true){
						System.out.println("Login Successfully!");
						return student;
					}
				}
				System.out.println("Your Id does not exist or your password is wrong, sorry!");
				return null;
			}
			else if (option==3){
				return null;
			}
			else{
				System.out.println("Please enter the right option");
			}
		}
		scan.close();
		return null;
	}

	public static void instructorMode(){
		//Professor Login Check with hardcoded username and password
		if(!perfomLogin()){
			System.out.println("Login failed. Exiting program.");
			return;
		}
		else{
			Instructor loggedInInstructor = new Instructor("admin","password",allCourses);
			boolean exit = false;
			Scanner scanner = new Scanner(System.in);
			while(!exit){
				System.out.println("Welcome, " + loggedInInstructor.getName());
				System.out.println("1. Add a course");
				System.out.println("2. View courses");
				System.out.println("3. Remove a course");
				System.out.println("4. Edit a course");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");

				int choice = Integer.valueOf(scanner.nextInt());
				switch(choice){
					case 1: 
						loggedInInstructor.addCourses();
						break;
					case 2: 
						loggedInInstructor.viewCourses();
						break;
					case 3: 
						loggedInInstructor.removeCourses();
						break;
					case 4: 
						loggedInInstructor.editCourse();
						break;
					case 5: 
						exit = true;
						System.out.println("Exiting...");
						break;
					default:
						System.out.println("Invalid choice. Please enter a valid number between 1 and 5.");
				}
				scanner.close();
			}
		}
	}

	public static void collectCourses()  throws IOException{
		allCourses = new ArrayList<>();
		File course = new File("course.bin");
		if(! course.exists()) {
			course.createNewFile();
		}
		else {
			Scanner scan = new Scanner(course);
			if (scan.hasNextLine()){
				int total = Integer.valueOf(scan.nextLine());
				CourseInfo.setNumber(total);
			}
			while(scan.hasNextLine()) {
				String content = scan.nextLine();
				allCourses.add(toCourseInfo(content));
			}
			scan.close();
		}
	}

	public static void saveCourses() throws IOException{
		if (allCourses.size()==0){
			return;
		}
		File course = new File("course.bin");
		FileWriter writer = new FileWriter(course);
		writer.write(CourseInfo.getNumber()+"\n");
		for (int i=0;i<allCourses.size();i++) {
			writer.write(allCourses.get(i).inFile());
		}
		writer.close();
	}

	public static boolean perfomLogin(){
		Scanner scanner = new Scanner(System.in);
		//hardcoded username and password
		String userName = "admin";
		String password = "password";

		System.out.print("Enter username: ");
		String user = scanner.nextLine();
		System.out.print("Enter password: ");
		String pass = scanner.nextLine();
		scanner.close();
		return user.equals(userName) && pass.equals(password);
	}

	public static CourseInfo toCourseInfo(String info){
		info = info+"|";
		String temp = "";
		int where = 0;
		int id = 0;
		String name = "";
		String instructor = "";
		String status = "";
		String location = "";
		String startTime = "";
		String endTime = "";
		String description = "";
		for (int i =0;i<info.length();i++){
	
			String single = info.substring(i,i+1);
			if (single.equals("|")){
				if (where==0){
					id = Integer.valueOf(temp);
				}
				else if (where == 1){
					name = temp;
				}
				else if (where==2){
					instructor = temp;
				}
				else if(where==3){
					status = temp;
				}
				else if(where==4){
					location = temp;
				}
				else if (where==5){
					startTime = temp;
				}
				else if (where ==6){
					endTime = temp;
				}
				else if (where ==7){
					description = temp;
				}
				temp = "";
				where++;
			} 
			else{
				temp = temp+single;
			}
		}
		CourseInfo course = new CourseInfo(id,name, status, location, startTime, endTime, description, instructor);
		return course;
	}


}