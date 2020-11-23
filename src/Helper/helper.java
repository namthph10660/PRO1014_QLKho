/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TRAN NAM
 */
public class helper {
     public static Connection ketnoi(String database){
        try {
            String user="sa";
            String pass="0338459391";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://DESKTOP-JQB11OG\\SQLEXPRESS:49677;databaseName="+database;
            Connection cn= DriverManager.getConnection(url,user , pass);
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
}
