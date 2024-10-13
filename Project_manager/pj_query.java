package Project_manager;

public class pj_query {
    //query for inserting data into pj
   public static String getInsert(){
    String insert = "INSERT INTO projects(project_name) VALUES (?)";
    return insert;
   }
   //query for selecting the entire table
  public static String getPJ(){
   String pj_name_id = "SELECT * FROM projects";
   return pj_name_id;
  }
  //query for selectig the joined table of task & project
  public static String selectTable(){
    String joinPjTask = "SELECT p.project_id, p.project_name, t.project_id,  t.taskName, t.taskDescription ,t.timelimit FROM task t INNER JOIN projects p ON p.project_id = t.project_id";
    return joinPjTask;
  }
  //query for selecting the rows of joined table
  public static String selectId(){
    String selectWithId = "SELECT p.project_id, p.project_name, t.project_id,  t.taskName, t.taskDescription ,t.timelimit FROM task t INNER JOIN projects p ON p.project_id = t.project_id WHERE p.project_id = ?";
    return selectWithId;
  }

}