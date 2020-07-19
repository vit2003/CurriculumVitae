/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.book;

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
public class BookDAO implements Serializable {

    private List<BookDTO> allBooks;

    public List<BookDTO> getAllBooks() {
        return allBooks;
    }

    public void getAllBook() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        allBooks = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnect();
            if (con != null) {
                String sql = "Select id, name, quantity, category, price From book Where status = 'true'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    String category = rs.getString("category");
                    float price = rs.getFloat("price");
                    BookDTO dto = new BookDTO(id, name, quantity, category, price);
                    allBooks.add(dto);
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
