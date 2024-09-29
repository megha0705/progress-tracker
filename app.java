import java.util.Scanner;
import To_Do_List.to_do_manager;
import Project_manager.pj_manager;
import Project_manager.pj_manager_DB_connector;
import To_Do_List.to_do_DB_connector;
import java.sql.Date;
class app{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         System.out.println("enter project name ");
        String projectName = sc.nextLine();
        pj_manager pj = new pj_manager(projectName);
        try{
            System.out.println("trying to add pj");
        pj_manager_DB_connector.insertion(pj);//this line is not getting executed
        System.out.println("project name is added succesfully");
        }catch(Exception e){
            e.printStackTrace();
        }
           System.out.println("enter task name , description , time limit , project_id");
        String taskName = sc.nextLine();
        String taskDescriptionn = sc.nextLine();
        String timeLimitStr = sc.nextLine();
        Date timeLimit = Date.valueOf(timeLimitStr);
        int project_id = sc.nextInt();
        sc.nextLine();
        to_do_manager manager = new to_do_manager(taskName, taskDescriptionn, timeLimit, project_id);
        try{
            System.out.println("try to add the data");
        to_do_DB_connector.insertTask(manager);
            System.out.println("data is succesfully added to the task");
        }catch(Exception e){
            e.printStackTrace();
        }

        

    }
}