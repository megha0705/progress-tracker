package progress_bar;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import To_Do_List.to_do_manager;
import database.DB_Connection;

public class progress_DB_Connector {
    public static void pj_progress(to_do_manager tdm){
    
        try{
            Connection conn = DB_Connection.connect();
            String progressQuery = progress_query.progress();
            PreparedStatement pstm = conn.prepareStatement(progressQuery);
            pstm.setInt(1, tdm.getProjectId());
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                int total_task = rs.getInt(1);
                 int completed_task = rs.getInt(2);
                double percentage = ((double)completed_task/total_task) * 100;
                System.out.println("total progress of the project is = " + percentage + "%");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
