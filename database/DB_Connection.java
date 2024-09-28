package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
    public static Connection connect(){
        Connection con = null;
        try{
            String url = "jdbc:mysql://localhost:3306/my_db";
            String password = "Megha05711@%";
            String username = "root";
             con = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            e.getStackTrace();
        }
        return con;
    }
}
