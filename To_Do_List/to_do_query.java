package To_Do_List;

public class to_do_query {
   //query for inserting the task data
   public static String getInsert(){
    String insert = "INSERT INTO task(taskName, taskDescription,timelimit,project_id, status) VALUES (?,?,?,?, 'pending')";
    return insert;
   }
   //query for updating the status to complete and record the completion time
   public static String updateStatus(){
      String update = "UPDATE task SET status = 'complete', completion_time = CURRENT_TIMESTAMP  WHERE taskNo = ?";
      return update;
   }
}