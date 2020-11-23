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
    public static Connection ketnoi (String datablse){
        try{
            String user="sa";
            String pass ="123456789";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://DESKTOP-VHM9V13\\SQLEXPRESS:1433;databaseName="+datablse;
            Connection cn= DriverManager.getConnection(url,user,pass);
            return cn;
            }
        catch(Exception a){
            throw  new RuntimeException(a);
        }
    }
}
