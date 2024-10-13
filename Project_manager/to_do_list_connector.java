package Project_manager;

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import database.DB_Connection;
import To_Do_List.to_do_manager;
public class to_do_list_connector {
    //selecting both the projects and task table 
    public static HashMap<pj_manager, List<to_do_manager>> selectEntirePjTask(){
        HashMap<pj_manager, List<to_do_manager>> map = new HashMap<>();
        try{
            Connection conn = DB_Connection.connect();
            String selectEntire = pj_query.selectTable();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(selectEntire);
            while(rs.next()){
                //creating pj_manager object with project id , proejct name
                pj_manager pjm = new pj_manager(rs.getInt(1),rs.getString(2));
                //arraylist for storing each rows of task
                List<to_do_manager> l = new ArrayList<>();
                //creating to_do_manager object with id , name , description,status , timelimit etc
                to_do_manager tdm  = new to_do_manager(rs.getInt(3), rs.getString(4),rs.getString(5), rs.getDate(6));
                //adding the object into the arrayList
                l.add(tdm);
                //if map already contains that pjm. append the task to the existing list
                if(map.containsKey(pjm)){
                    map.get(pjm).add(tdm);
                }else{
                    //else just put the pjm as key and list of task as value
                    map.put(pjm ,l);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }

    // select any rows with project id;
    public static HashMap<pj_manager , List<to_do_manager>> selectWithId(pj_manager p){
        HashMap<pj_manager , List<to_do_manager>> hm = new HashMap<>();
        try{
            Connection conn = DB_Connection.connect();
            String selectId = pj_query.selectId();
            PreparedStatement pstm = conn.prepareStatement(selectId);
            //selecting a perticular rows with a specific project id
            pstm.setInt(1, p.getPjId());
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                pj_manager projects = new pj_manager(rs.getInt(1), rs.getString(2));
                ArrayList<to_do_manager> arr = new ArrayList<>();
                to_do_manager tdm = new to_do_manager(rs.getInt(3),rs.getString(4),rs.getString(5), rs.getDate(6));
                arr.add(tdm);
                if(hm.containsKey(projects)){
                    hm.get(projects).add(tdm);
                }else{
                    hm.put(projects, arr);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return hm;
    }
}
