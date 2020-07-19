/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.bill;

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
public class BillDAO implements Serializable {

    private String currentBill;

    public String getCurrentBill() {
        return currentBill;
    }

    public int getIdOfDay() throws SQLException, NamingException {
        int result = 1;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null) {
                String sql = "Select count(*) As 'count' From bill Where day = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, java.time.LocalDate.now().toString());
                rs = stm.executeQuery();
                if (rs.next()) {
                    int temp = rs.getInt("count");
                    if (temp >= 1) {
                        result = ++temp;
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean insertNewBill(String username, float total, String address) throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        int billID = getIdOfDay();
        currentBill = java.time.LocalDate.now().toString() + "_" + billID;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null) {
                String sql = "Insert Into bill(id, username, total, day, address) Values (?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, currentBill);
                stm.setString(2, username);
                stm.setFloat(3, total);
                stm.setString(4, java.time.LocalDate.now().toString());
                stm.setString(5, address);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
