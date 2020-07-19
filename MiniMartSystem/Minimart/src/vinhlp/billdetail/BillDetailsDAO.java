/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.billdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import vinhlp.utils.ConnectSupport;

/**
 *
 * @author Asus
 */
public class BillDetailsDAO implements Serializable{
    public boolean insertNewBillDetails(BillDetailsDTO dto) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Insert Into BillDetails(id, billid, productid, amount) Values (?,?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, dto.getId());
                preStm.setString(2, dto.getBillId());
                preStm.setString(3, dto.getProductId());
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
