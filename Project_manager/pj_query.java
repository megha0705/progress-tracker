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
}