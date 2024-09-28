
package Project_manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import database.DB_Connection;

public class pj_manager_DB_connector{  
   

    public static void insertion(pj_manager p){
        try{
            Connection conn = DB_Connection.connect();
            String insertQuery = pj_query.getInsert();
            PreparedStatement Pstm =conn.prepareStatement(insertQuery);
            Pstm.setString(1,p.getPjName());
            Pstm.execute();
            System.out.println("data successfully addeed into the project table");
        }catch(Exception e){
            e.getStackTrace();
        }
    }
   

}
