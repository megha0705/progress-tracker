import java.util.Scanner;
import To_Do_List.to_do_manager;
import Project_manager.pj_manager;
import java.sql.Date;
class app{

    public static void main(String[] args) {
        System.out.println("enter project name ");
        Scanner sc = new Scanner(System.in);
        String projectName = sc.nextLine();
        pj_manager pj = new pj_manager(projectName);
        pj.addPj();
        System.out.println("enter task name , description , time limit , project_id");
        String taskName = sc.nextLine();
        String taskDescriptionn = sc.nextLine();
        String timeLimitStr = sc.nextLine();
        Date timeLimit = Date.valueOf(timeLimitStr);
        int project_id = sc.nextInt();
        sc.nextLine();
        to_do_manager manager = new to_do_manager(taskName, taskDescriptionn, timeLimit, project_id);
        manager.addTask();

        

    }
}