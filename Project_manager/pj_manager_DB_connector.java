
package Project_manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Statement;

import java.lang.reflect.Array;



import java.sql.SQLException;


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
            e.printStackTrace();
        }
    }
    public static void selectPj(){
       try{
        Connection conn = DB_Connection.connect();
        String selectPjQuery = pj_query.getPJ();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(selectPjQuery);
        while(rs.next()){
        System.out.println("project id = "+ rs.getInt(1)+ "project name =" + rs.getString(2));
            
        }

       }catch(Exception e){
        e.printStackTrace();
       }
       
    }



}



