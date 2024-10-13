package To_Do_List;
import database.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class to_do_DB_connector {
    //function for inserting task on to the "task" table
    public static void insertTask(to_do_manager tdm){
        try{
            Connection conn = DB_Connection.connect();
            String query = to_do_query.getInsert();
            PreparedStatement Pstm =conn.prepareStatement(query);
            Pstm.setString(1,tdm.getName());
            Pstm.setString(2,tdm.getDescription());
            Pstm.setDate(3,tdm.timeLimit());
            Pstm.setInt(4,tdm.getProjectId());
            System.out.println(Pstm);
            Pstm.execute();
            System.out.println("data inserted succesfully");
            }catch(Exception e){
                e.getStackTrace();
            }
    }

    //allowing the user to update their status , function for that
    public static void updateStatus(to_do_manager tdm){
        try{
            Connection con = DB_Connection.connect();
            String update = to_do_query.updateStatus();
            PreparedStatement pstm = con.prepareStatement(update);
            pstm.setInt(1, tdm.getProjectId());
            pstm.execute();
            System.out.println("status updated succesfully");
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
