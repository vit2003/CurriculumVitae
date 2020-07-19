/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.stokeinoutdetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vinhlp.utils.ConnectSupport;

/**
 *
 * @author Asus
 */
public class StokeInOutDetailsDAO implements Serializable {

    private List<Stoke> listAllStoke;

    public List<Stoke> getListAllStoke() {
        return listAllStoke;
    }

    public void getAllStoke(String stokeInOutID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listAllStoke = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select productid, amount From StokeInOutDetail Where stokeinoutid = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, stokeInOutID);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("productid");
                    int quan = rs.getInt("amount");
                    Stoke astoke = new Stoke(id, quan);
                    listAllStoke.add(astoke);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean update(String stokeInOutID, String productID, int amount) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update StokeInOutDetail Set amount = ? Where stokeinoutid = ? And productid = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(2, stokeInOutID);
                preStm.setString(3, productID);
                preStm.setInt(1, amount);
                result = preStm.executeUpdate() > 0;
            }
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean createNewBill(StokeInOutDetailsDTO dto) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Insert Into StokeInOutDetail (id, stokeinoutid, productid, amount) values (?,?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, dto.getId());
                preStm.setString(2, dto.getStokeInOutId());
                preStm.setString(3, dto.getProductID());
                preStm.setInt(4, dto.getAmount());
                result = preStm.executeUpdate() > 0;
            }
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
}
