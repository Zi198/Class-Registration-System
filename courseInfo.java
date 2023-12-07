public class classInfo {
    static int number = 0;
    int id;
    String name;
    String status;
    String location;
    String startTime;
    String endTime;
    String description;
    String professor;

    classInfo( String name,String status, String location, String startTime, String endTime, String description,String professor){
        this.id = number;
        this.status = status;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.professor = professor;
        number++;
    }

    public static void main(String[] agvs){
        classInfo test = new classInfo( "Intro to Computer Science","open", "Bobst",  "8:00", "12:00", "A course", "Joanna")
        System.out.println("hdsadas");
    }
}
