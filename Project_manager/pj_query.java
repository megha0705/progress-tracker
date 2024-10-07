package Project_manager;

public class pj_query {
    
   public static String getInsert(){
    String insert = "INSERT INTO projects(project_name) VALUES (?)";
    return insert;
   }
  public static String getPJ(){
   String pj_name_id = "SELECT * FROM projects";
   return pj_name_id;
  }
  public static String selectTable(){
    String joinPjTask = "SELECT p.project_id, p.project_name, t.project_id,  t.taskName, t.taskDescription ,t.timelimit FROM task t INNER JOIN projects p ON p.project_id = t.project_id";
    return joinPjTask;
  }
  public static String selectId(){
    String selectWithId = "SELECT p.project_id, p.project_name, t.project_id,  t.taskName, t.taskDescription ,t.timelimit FROM task t INNER JOIN projects p ON p.project_id = t.project_id WHERE p.project_id = ?";
    return selectWithId;
  }

}