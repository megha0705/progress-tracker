package To_Do_List;
import database.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class to_do_DB_connector {
    public static void insertTask(to_do_manager tdm){
        try{
            Connection conn = DB_Connection.connect();
        String query = to_do_query.getInsert();
        PreparedStatement Pstm =conn.prepareStatement(query);
        
        Pstm.setString(1,tdm.getName());
        Pstm.setString(2,tdm.getDescription());
        Pstm.setDate(3,tdm.timeLimit());
        Pstm.setInt(4,tdm.getProjectId());
        Pstm.execute();
        System.out.println("data inserted succesfully");
        }catch(Exception e){
            e.getStackTrace();
        }
        

    }
}
