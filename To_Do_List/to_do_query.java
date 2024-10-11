package To_Do_List;

public class to_do_query {
   
   public static String getInsert(){
    String insert = "INSERT INTO task(taskName, taskDescription,timelimit,project_id, status) VALUES (?,?,?,?, 'pending')";
    return insert;
   }
   public static String updateStatus(){
      String update = "UPDATE task SET status = 'complete', completion_time = CURRENT_TIMESTAMP  WHERE project_id = ?";
      return update;
   }
}