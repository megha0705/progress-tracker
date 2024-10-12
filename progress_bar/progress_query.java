package progress_bar;

public class progress_query {
    public static String progress(){
        String task_progress = "SELECT COUNT(taskName) AS total_task , SUM(CASE WHEN status = 'complete' THEN 1 ELSE 0 END)AS completed_task FROM task WHERE project_id = ?";
        return task_progress;
    }
}
