package To_Do_List;

public class to_do_query {
   //query for inserting the task data
   public static String getInsert(){
    String insert = "INSERT INTO task(taskName, taskDescription,timelimit,project_id, status) VALUES (?,?,?,?, 'pending')";
    return insert;
   }
  /* public static String updateCompletion_time(){
      String com_time = "UPDATE task SET "
   }*/
   //query for updating the status to complete / incomplete based on th completion time;
   public static String updateStatus(){
      String update = "UPDATE task SET  completion_time = CURRENT_TIMESTAMP , status = CASE  WHEN DATE(CURRENT_TIMESTAMP)> timelimit THEN 'incomplete' ELSE 'complete' END WHERE taskNo = ?";
      return update;
   }
}