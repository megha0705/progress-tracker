package Project_manager;

public class pj_manager {
    String project_name;
    int project_id;
   public  pj_manager(String project_name){
    this.project_name = project_name;
    
   }
   public  pj_manager(int project_id,String project_name){
    this.project_id = project_id;
    this.project_name = project_name;

    
   }
   public static void  addPj(){
    System.out.println("project name is added to the table");
   }
   public  String getPjName(){
    return project_name;
   }
}
