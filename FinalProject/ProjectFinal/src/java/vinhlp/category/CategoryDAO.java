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
import javax.naming.NamingException;
import vinhlp.utils.ConnectSupport;

/**
 *
 * @author Asus
 */
public class CategoryDAO implements Serializable {

    List<CategoryDTO> allCategories;

    public List<CategoryDTO> getAllCategories() {
        return allCategories;
    }

    public void loadAllCategory() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        allCategories = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnect();
            if (con != null) {
                String sql = "Select id, name From category Where status='true'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    CategoryDTO dto = new CategoryDTO(id, name);
                    allCategories.add(dto);
                }
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
    }
}
