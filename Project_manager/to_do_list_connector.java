package Project_manager;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import database.DB_Connection;
import To_Do_List.to_do_manager;
public class to_do_list_connector {
    public static HashMap<pj_manager, List<to_do_manager>> selectEntirePjTask(){
        HashMap<pj_manager, List<to_do_manager>> map = new HashMap<>();

        try{
            Connection conn = DB_Connection.connect();
        String selectEntire = pj_query.selectTable();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(selectEntire);
        while(rs.next()){
            pj_manager pjm = new pj_manager(rs.getInt(1),rs.getString(2));
            List<to_do_manager> l = new ArrayList<>();
            to_do_manager tdm  = new to_do_manager(rs.getInt(3), rs.getString(4),rs.getString(5), rs.getDate(6));
            l.add(tdm);
            if(map.containsKey(pjm)){
                map.get(pjm).add(tdm);
            }else{
                map.put(pjm ,l);
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return map;
    
    }
}
