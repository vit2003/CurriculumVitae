/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.role;

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
public class RoleDAO implements Serializable {

    private List<String> listRole;

    public List<String> getListRole() {
        return listRole;
    }

    public void getAllRole() throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listRole = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select note From Role";
                preStm = con.prepareStatement(sql);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    listRole.add(rs.getString("note"));
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
    
    public String getRoleName(int role) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String result = "";
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select note From Role Where Role = ?";
                preStm = con.prepareStatement(sql);
                preStm.setInt(1, role);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("note");
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
        return result;
    }
}
