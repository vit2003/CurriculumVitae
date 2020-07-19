/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vinhlp.role.RoleDAO;
import vinhlp.utils.ConnectSupport;

/**
 *
 * @author Asus
 */
public class UserDAO implements Serializable {

    public List<UserDTO> getAllUser() throws ClassNotFoundException, SQLException {
        List<UserDTO> result = new ArrayList<>();
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Username, Password, Role From [dbo].[User] Where Status = ?";
                preStm = con.prepareStatement(sql);
                preStm.setBoolean(1, true);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String roleUser = "";
                    if (role == 1) {
                        roleUser = "Admin";
                    } else if (role == 2) {
                        roleUser = "Seller";
                    } else if (role == 3) {
                        roleUser = "Inventory Staff";
                    }
                    UserDTO dto = new UserDTO(username, password, roleUser);
                    result.add(dto);
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

    public boolean changePassword(String username, String password) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement preStm = null;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update [dbo].[User] Set Password = ? Where Username = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, password);
                preStm.setString(2, username);
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

    public boolean isExistInventoryStaff() throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                int role = 3;
                String sql = "Select Username From [dbo].[User] Where Role = ?";
                preStm = con.prepareStatement(sql);
                preStm.setInt(1, role);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = true;
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

    public boolean changeRole(String username, int role) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement preStm = null;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update [dbo].[User] Set Role = ? Where Username = ?";
                preStm = con.prepareStatement(sql);
                preStm.setInt(1, role);
                preStm.setString(2, username);
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

    public boolean deleteUser(String username) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement preStm = null;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update [dbo].[User] Set Status = ? Where Username = ?";
                preStm = con.prepareStatement(sql);
                preStm.setBoolean(1, false);
                preStm.setString(2, username);
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

    public boolean isAdminUser(String username) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Username From [dbo].[User] Where Username = ? And Role = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setInt(2, 1);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = true;
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

    public String getInventoryStaffName() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String result = "";
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Username From [dbo].[User] Where Role = ?";
                preStm = con.prepareStatement(sql);
                preStm.setInt(1, 3);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("Username");
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
    
    public UserDTO checkLogin(String username, String password) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        UserDTO result = null;
        RoleDAO dao = new RoleDAO();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Username, Password, Role From [dbo].[User] Where Username = ? And Password = ? And Status = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setString(2, password);
                preStm.setBoolean(3, true);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("Username");
                    int role = rs.getInt("Role");
                    String roleUser = dao.getRoleName(role);
                    result = new UserDTO(username, password, roleUser);
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
