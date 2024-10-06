package To_Do_List;

public class to_do_manager {

    String taskName;
    String taskDescription;
    
    java.sql.Date timelimit;
    int project_id;
   public to_do_manager(int project_id, String taskName, String taskDescription, java.sql.Date timelimit){
        this.project_id = project_id;

        this.taskName = taskName;
        this.taskDescription = taskDescription;
        
        this.timelimit = timelimit;
        
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
}
