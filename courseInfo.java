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

    CourseInfo( int id, String name,String status, String location, String startTime, String endTime, String description,String professor){
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.professor = professor;
    }

    CourseInfo( String name,String status, String location, String startTime, String endTime, String description,String professor){
        this(number,name,status,location,startTime,endTime,description,professor);
        number++;
    }

    public String toString(){
        String result = "";
        result = result +"Course ID: "+Integer.toString(this.id)+"\n";
        result = result +"Course Name: "+this.name+"\n";
        result = result +"Instructor: "+this.professor+"\n";
        result = result +"Status: "+this.status+ "\n";
        result = result +"Location: "+this.location+"\n";
        result = result +"Start AT:" + this.startTime+"\n";
        result = result +"End At:" + this.endTime+"\n";
        result = result +"Info: "+this.description+"\n";
        return result;
    }

    public String inFile(){
        String word = "";
        word = word+this.id+"|"+this.name+"|"+this.professor+"|"+this.status+"|"+this.location+"|"+this.startTime+"|"+this.endTime+"|"+this.description+"\n";
        return word;
    }

    public String getId(){
        return Integer.toString(this.id);
    } 

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
        return;
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
        return;
    }

    public void setLocation(String newLocation){
        this.location = newLocation;
        return;
    }

    public void setStartTime(String newStartTime){
        this.startTime = newStartTime;
        return;
    }

    public void setEndTime(String newEndTime){
        this.endTime = newEndTime;
        return;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
        return;
    }

    public void setProfessor(String newProfessor){
        this.professor = newProfessor;
        return;
    }

    public static void setNumber(int number){
        CourseInfo.number = number;
    }

    public static int getNumber(){
        return CourseInfo.number;
    }
}
