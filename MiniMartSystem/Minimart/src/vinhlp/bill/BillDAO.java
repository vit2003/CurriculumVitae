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
import java.util.ArrayList;
import java.util.List;
import vinhlp.utils.ConnectSupport;
import vinhlp.utils.MonthSupport;

/**
 *
 * @author Asus
 */
public class BillDAO implements Serializable {

    private List<BillDTO> listBill;

    public List<BillDTO> getListBill() {
        return listBill;
    }

    public int getTimeCustomerComeInOneDay(String username, String day) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        int result = 1;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select count(*) as 'count' From Bill Where userid = ? And date = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setString(2, day);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("count");
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

    public void getAllBill(int month) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        listBill = new ArrayList<>();
        String dateNow = java.time.LocalDate.now().toString();
        int year = Integer.parseInt(dateNow.substring(0,4));
        int day = MonthSupport.getDayInMonth(month, year);
        String fromDay = year + "-" + month + "-"+1;
        String toDay = year + "-" + month + "-"+day;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select id, total From Bill Where date >= ? And date <= ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, fromDay);
                preStm.setString(2, toDay);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    float total = rs.getFloat("total");
                    BillDTO dto = new BillDTO(id, total);
                    listBill.add(dto);
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

    public boolean insertNewBill(BillDTO dto) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Insert Into Bill(id, userid, total, date) Values (?,?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, dto.getId());
                preStm.setString(2, dto.getUserid());
                preStm.setFloat(3, dto.getTotal());
                preStm.setString(4, dto.getDate());
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
