package To_Do_List;

public class to_do_manager {

    String taskName;
    String taskDescription;
    String status;
    java.sql.Date timelimit;
    int project_id;
   public to_do_manager(int project_id, String taskName, String taskDescription, java.sql.Date timelimit){
        this.project_id = project_id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.timelimit = timelimit;
        
        
    }
    public to_do_manager(int project_id){
        this.project_id = project_id;
    }
  public to_do_manager (String status){
    this.status = status;
  }

  public void setStatus(String status) {
    this.status = status;
}
    public String getName(){
        return taskName;
    }
    public String getDescription(){
        return taskDescription;
    }
   
    public java.sql.Date timeLimit(){
        return timelimit;
    }
    public int getProjectId(){
        return project_id;
    }
    @Override
public String toString() {
    return "Project id: " + this.project_id + ", task name: " + this.taskName + ", task description: "+ this.taskDescription+", time limit: " + this.timelimit;
}
}
