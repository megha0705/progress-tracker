package To_Do_List;

public class to_do_query {
   
   public static String getInsert(){
    String insert = "INSERT INTO task(taskName, taskDescription,timelimit,project_id) VALUES (?,?,?,?)";
    return insert;
   }
}