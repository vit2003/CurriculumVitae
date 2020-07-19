/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.product;

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
public class ProductDAO implements Serializable {

    private List<ProductDTO> listDTO;

    public List<ProductDTO> getListDTO() {
        return listDTO;
    }

    public void loadProductFollowCategory(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listDTO = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Id, Name, UnitPrice, Packaging, Status, quantity From Product Where Category = ? And Status = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
                preStm.setBoolean(2, true);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("Id");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("UnitPrice");
                    String date = rs.getString("Packaging");
                    boolean status = rs.getBoolean("Status");
                    int quan = rs.getInt("quantity");
                    ProductDTO dto = new ProductDTO(proID, name, id, date, price, status, quan);
                    listDTO.add(dto);
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

    public void searchProduct(String id, String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listDTO = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Id, Name, UnitPrice, Packaging, Status, quantity From Product Where Category = ? And Status = ? And name like ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
                preStm.setBoolean(2, true);
                preStm.setString(3, "%" + name + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("Id");
                    String namePro = rs.getString("Name");
                    float price = rs.getFloat("UnitPrice");
                    String date = rs.getString("Packaging");
                    boolean status = rs.getBoolean("Status");
                    int quan = rs.getInt("quantity");
                    ProductDTO dto = new ProductDTO(proID, namePro, id, date, price, status, quan);
                    listDTO.add(dto);
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

    public void loadProduct() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listDTO = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Id, Name, Category, UnitPrice, Packaging, Status, quantity From Product Where Status = ?";
                preStm = con.prepareStatement(sql);
                preStm.setBoolean(1, true);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("Id");
                    String name = rs.getString("Name");
                    String id = rs.getString("Category");
                    float price = rs.getFloat("UnitPrice");
                    String date = rs.getString("Packaging");
                    boolean status = rs.getBoolean("Status");
                    int quan = rs.getInt("quantity");
                    ProductDTO dto = new ProductDTO(proID, name, id, date, price, status, quan);
                    listDTO.add(dto);
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

    public boolean insertNewProduct(ProductDTO dto) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Insert Into Product(Id,Name,Category,UnitPrice,Packaging,Status) Values (?,?,?,?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, dto.getId());
                preStm.setString(2, dto.getName());
                preStm.setString(3, dto.getCategory());
                preStm.setFloat(4, dto.getUniprice());
                preStm.setString(5, dto.getPackaging());
                preStm.setBoolean(6, true);
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

    public boolean updateProduct(String id, String name, float price, String date) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update Product Set Name = ?, UnitPrice = ?, Packaging = ? Where Id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, name);
                preStm.setFloat(2, price);
                preStm.setString(3, date);
                preStm.setString(4, id);
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

    public boolean deleteProduct(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update Product Set Status = ? Where Id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setBoolean(1, false);
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

    public void searchProductByLikeName(String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listDTO = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Id, Name, Category, UnitPrice, Packaging, Status, quantity From Product Where Name like ? And Status = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, "%" + name + "%");
                preStm.setBoolean(2, true);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("Id");
                    String nameProduct = rs.getString("Name");
                    String category = rs.getString("Category");
                    float price = rs.getFloat("UnitPrice");
                    String date = rs.getString("Packaging");
                    boolean status = rs.getBoolean("Status");
                    int quan = rs.getInt("quantity");
                    ProductDTO dto = new ProductDTO(proID, nameProduct, category, date, price, status, quan);
                    listDTO.add(dto);
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

    public String getProductID(String name) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String result = "";
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Id From Product Where Name = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, name);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("Id");
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

    public int getQuantityOfProduct(String Id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select quantity From Product Where Id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, Id);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("quantity");
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

    public boolean updateQuantity(String id, int quantity) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Update Product Set quantity = ? Where Id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setInt(1, quantity);
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

    public String getProductName(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String result = "";
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select Name From Product Where Id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("Name");
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
    
    public float getProductPrice(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        float result = 0;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select UnitPrice From Product Where Id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getFloat("UnitPrice");
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
