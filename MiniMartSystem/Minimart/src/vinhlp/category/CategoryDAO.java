/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.category;

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
public class CategoryDAO implements Serializable {

    private List<CategoryDTO> alist;

    public List<CategoryDTO> getAlist() {
        return alist;
    }

    public void getAllCategory() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        alist = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select ID, Name From Category Where status = 'true'";
                preStm = con.prepareStatement(sql);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String name = rs.getString("Name");
                    CategoryDTO dto = new CategoryDTO(id, name);
                    alist.add(dto);
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

    public void searchCategory(String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        alist = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select ID, Name From Category Where status = 'true' And Name like ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, "%"+name+"%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String idCate = rs.getString("ID");
                    String nameCate = rs.getString("Name");
                    CategoryDTO dto = new CategoryDTO(idCate, nameCate);
                    alist.add(dto);
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

    public String getCategoryID(String categoryName) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String result = "";
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select ID From Category where Name = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, categoryName);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("ID");
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

    public boolean changeNameOfCategory(String id, String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update Category Set Name = ? Where ID = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, name);
                preStm.setString(2, id);
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

    public boolean deleteCategory(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update Category Set status = 'false' Where ID = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
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

    public boolean createCategory(String id, String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Insert Category(ID, Name, status) Values (?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
                preStm.setString(2, name);
                preStm.setBoolean(3, true);
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

    public boolean returnCategory(String id, String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update Category Set status = 'true', Name = ? Where ID = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, name);
                preStm.setString(2, id);
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
