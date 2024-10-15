import java.util.*;
import java.util.Map.Entry;
import progress_bar.*;
import To_Do_List.to_do_manager;
import Project_manager.pj_manager;
import Project_manager.pj_manager_DB_connector;
import Project_manager.to_do_list_connector;
import To_Do_List.to_do_DB_connector;
import java.sql.Date;
class app{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    System.out.println("[new project : 1 || add task to existing project : 2 || select both projetcs and task table : 3 || select a specific column : 4 || uppdate status : 5 || progress bar : 6]");
    int input = sc.nextInt();
    switch(input){
    case 1 :
        //projject table
        System.out.println("enter project name ");
        sc.nextLine();
        String projectName = sc.nextLine();
        pj_manager pj = new pj_manager(projectName);
        try{
            System.out.println("trying to add pj");
            pj_manager_DB_connector.insertion(pj);
            pj_manager_DB_connector.selectPj();
            System.out.println("project name is added succesfully");
        }catch(Exception e){
            e.printStackTrace();
        }
        // task table
        System.out.println("enter task name , description , time limit , project_id");
        String taskName = sc.nextLine();
        String taskDescriptionn = sc.nextLine();
        String timeLimitStr = sc.nextLine();
        Date timeLimit = Date.valueOf(timeLimitStr);
        int project_id = sc.nextInt();
        sc.nextLine();
        to_do_manager manager = new to_do_manager(project_id,taskName, taskDescriptionn, timeLimit);
        try{
            System.out.println("try to add the data");
            to_do_DB_connector.insertTask(manager);
            System.out.println("data is succesfully added to the task");
        }catch(Exception e){
            e.printStackTrace();
        }
        break;
    case 2: 
        
        System.out.println("enter  time limit , task name , description  , project_id");
        sc.nextLine();
        String timeLimitSt = sc.nextLine();
        Date timelimit = Date.valueOf(timeLimitSt);
        String taskNa = sc.nextLine();
        String taskDescription = sc.nextLine();
        int projectid = sc.nextInt();
        sc.nextLine();
        to_do_manager mng = new to_do_manager(projectid,taskNa, taskDescription, timelimit);
        try{
            System.out.println("try to add the data");
        to_do_DB_connector.insertTask(mng);
            System.out.println("data is succesfully added to the task");
        }catch(Exception e){
            e.printStackTrace();
        }
        break;
    
    case 3:
    System.out.println("write 'select all' to see the entire table");
    sc.nextLine();
    String str = sc.nextLine();
    if(str.equals("select all")){
        HashMap<pj_manager, List<to_do_manager>> hm = new HashMap<>(to_do_list_connector.selectEntirePjTask());
        for(Entry<pj_manager , List<to_do_manager>> entry : hm.entrySet()){
            pj_manager project = entry.getKey();
            System.out.println(project);
            List<to_do_manager> tasks = entry.getValue();
        for(to_do_manager task : tasks){
            System.out.println(task);
        }
        }
    }
    break;

    case 4 :

    System.out.println("you wanna select a perticular row of a table ?");
    sc.nextLine();
    String str2 = sc.nextLine();
    if(str2.equals("yes")){
    System.out.println("provide the project id of the row u wanna select");
    
    int pj_id = sc.nextInt();
    pj_manager PJ = new pj_manager(pj_id);
    HashMap<pj_manager , List<to_do_manager>> map = new HashMap<>(to_do_list_connector.selectWithId(PJ));

    System.out.println("id is successfully set");
    for(Entry<pj_manager , List<to_do_manager>> e : map.entrySet()){
        pj_manager project = e.getKey();
        System.out.println(project);
        List<to_do_manager> tasks = e.getValue();
        for(to_do_manager task : tasks){
            System.out.println(task);
        }
    }
    
}
    break;
    case 5 :
    System.out.println("write the project id of the status u wanna update");
    int n = sc.nextInt();
    to_do_manager tdm = new to_do_manager(n);
    to_do_DB_connector.updateStatus(tdm);
    break;
    case 6:
    System.out.println("provide the project_id of the project");
    int pjId = sc.nextInt();
    to_do_manager td = new to_do_manager(pjId);
    double percentage  = progress_DB_Connector.pj_progress(td);
    int m = 10;
    System.out.println("progress bar : ");
    System.out.print("[");
    for(int i = 0; i < m; i++){
        if(i < percentage){
            System.out.print("X");

        }else{
            System.out.print("-");
        }
    }
    System.out.print("]" + percentage*10 + "%");
    break;

   }
}
    
}