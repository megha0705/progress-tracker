import java.util.Scanner;

import java.util.*;
import java.util.ArrayList;
import java.util.Map.Entry;

import To_Do_List.to_do_manager;
import Project_manager.pj_manager;
import Project_manager.pj_manager_DB_connector;
import Project_manager.to_do_list_connector;
import To_Do_List.to_do_DB_connector;
import java.sql.Date;
class app{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      /*     System.out.println("enter project name ");
        String projectName = sc.nextLine();
        pj_manager pj = new pj_manager(projectName);
        try{
            System.out.println("trying to add pj");
        pj_manager_DB_connector.insertion(pj);//this line is not getting executed
        pj_manager_DB_connector.selectPj();
        System.out.println("project name is added succesfully");
        }catch(Exception e){
            e.printStackTrace();
        }

*/
 
 /*        System.out.println("enter task name , description , time limit , project_id");
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
*/

//SELECT BOTH TABLES;
System.out.println("write 'select' to see the entire table");
String str = sc.nextLine();
if(str.equals("select")){
HashMap<pj_manager, List<to_do_manager>> hm = new HashMap<>(to_do_list_connector.selectEntirePjTask());
for(Entry<pj_manager , List<to_do_manager>> entry : hm.entrySet()){
pj_manager project = entry.getKey();
System.out.println("projects=" + project);

List<to_do_manager> tasks = entry.getValue();
for(to_do_manager task : tasks){
    System.out.println("tasks =" + task);
}
}
}
        

    }
}