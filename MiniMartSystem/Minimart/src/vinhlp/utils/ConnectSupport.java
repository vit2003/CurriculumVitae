/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class ConnectSupport implements Serializable{
    public static Connection makeConnection() throws ClassNotFoundException, SQLException{
        //Create variable to return 
        Connection result = null;
        //Get Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Make connection
        result = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=MiniMart","sa","vinhle123");
        return result;
    }
}
