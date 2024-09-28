package Project_manager;

public class pj_manager {
    String project_name;
   public  pj_manager(String project_name){
    this.project_name = project_name;
    addPj();
   }
   public static void  addPj(){
    System.out.println("project name is added to the table");
   }
   public  String getPjName(){
    return project_name;
   }
}
