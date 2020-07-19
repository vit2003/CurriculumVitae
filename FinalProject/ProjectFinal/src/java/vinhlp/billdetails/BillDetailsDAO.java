/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.billdetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import vinhlp.utils.ConnectSupport;

/**
 *
 * @author Asus
 */
public class BillDetailsDAO implements Serializable{
    
    public int getNumberOfBillId(String billID) throws SQLException, NamingException{
        int result = 0;
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Select count(*) As 'count' From billdetails Where billid = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, billID);
                rs = preStm.executeQuery();
                if (rs.next()){
                    int temp = rs.getInt("count");
                    if (temp > 0){
                        result = temp;
                    }
                }
            }
            
        } finally {
            if (rs != null){
                rs.close();
            }
            if (preStm != null){
                preStm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result+1;
    }
    
    public boolean insertNewRecord(String billID, String bookID, int quantity) throws SQLException, NamingException{
        boolean result = false;
        Connection con = null;
        PreparedStatement preStm = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Insert Into billdetails(id, billid, bookid, quantity) Values (?,?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, billID+"_"+getNumberOfBillId(billID));
                System.out.println("billID: "+billID);
                preStm.setString(2, billID);
                preStm.setString(3, bookID);
                preStm.setInt(4, quantity);
                result = preStm.executeUpdate() > 0;
            }
        } finally {
            if (preStm != null){
                preStm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
    
}
