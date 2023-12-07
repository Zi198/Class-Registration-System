public class CourseInfo {
    static int number = 0;
    int id;
    String name;
    String status;
    String location;
    String startTime;
    String endTime;
    String description;
    String professor;

    CourseInfo( String name,String status, String location, String startTime, String endTime, String description,String professor){
        this.id = number;
        this.name = name;
        this.status = status;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.professor = professor;
        number++;
    }

    public String toString(){
        String result = "";
        result = result +"Course ID: "+Integer.toString(this.id)+"\n";
        result = result +"Course Name: "+this.name+"\n";
        result = result +"Instructor: "+this.professor+"\n";
        result = result +"Status: "+this.status+ "\n";
        result = result +"Location: "+this.location+"\n";
        result = result +"Start AT:" + this.endTime+"\n";
        result = result +"End At:" + this.endTime+"\n";
        result = result +"Info: "+this.description+"\n";
        return result;
    }
    public static void main(String[] agvs){
        CourseInfo test = new CourseInfo( "Intro to Computer Science","open", "Bobst",  "8:00", "12:00", "A course", "Joanna");
        System.out.println(test);
    }
}
