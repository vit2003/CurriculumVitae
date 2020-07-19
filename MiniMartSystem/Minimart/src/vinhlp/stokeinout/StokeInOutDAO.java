/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.stokeinout;

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
public class StokeInOutDAO implements Serializable {

    private List<StokeInOutDTO> alist;

    public List<StokeInOutDTO> getAlist() {
        return alist;
    }

    public void loadAllBillNearBy() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        alist = new ArrayList<>();
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select id, userid, lastmodifiedday, inorout From StokeInOut";
                preStm = con.prepareStatement(sql);
                rs = preStm.executeQuery();
                int count = 10;
                while (rs.next() && count > 0) {
                    String id = rs.getString("id");
                    String userid = rs.getString("userid");
                    String lastDate = rs.getString("lastmodifiedday");
                    boolean inout = rs.getBoolean("inorout");
                    String action = "in";
                    if (inout) {
                        action = "out";
                    }
                    StokeInOutDTO dto = new StokeInOutDTO(id, userid, lastDate, action);
                    alist.add(dto);
                    count--;
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

    public void loadAllBillNearBy(String month) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        alist = new ArrayList<>();
        String dateNow = java.time.LocalDate.now().toString();
        int year = Integer.parseInt(dateNow.substring(0, 4));
        int day = MonthSupport.getDayInMonth(Integer.parseInt(month), year);
        String fromDay = year + "-" + month + "-" + 1;
        String toDay = year + "-" + month + "-" + day;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select id, inorout From StokeInOut Where lastmodifiedday >= ? And lastmodifiedday <= ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, fromDay);
                preStm.setString(2, toDay);
                rs = preStm.executeQuery();
                int count = 10;
                while (rs.next() && count > 0) {
                    String id = rs.getString("id");
                    boolean inout = rs.getBoolean("inorout");
                    String action = "in";
                    if (inout) {
                        action = "out";
                    }
                    StokeInOutDTO dto = new StokeInOutDTO(id, action);
                    alist.add(dto);
                    count--;
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

    public String getInOrOutStock(String id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String result = "in";
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select inorout From StokeInOut Where id = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    boolean check = rs.getBoolean("inorout");
                    if (check) {
                        result = "out";
                    }
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

    public int getNumOfBillInThatDay(String date) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Select count(*) as count From StokeInOut Where lastmodifiedday = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, date);
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

    public boolean createNewBill(StokeInOutDTO dto) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement preStm = null;
        boolean result = false;
        try {
            con = ConnectSupport.makeConnection();
            if (con != null) {
                String sql = "Insert Into StokeInOut (id, userid, lastmodifiedday, inorout) values (?,?,?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, dto.getId());
                preStm.setString(2, dto.getUserID());
                preStm.setString(3, dto.getLastDate());
                boolean inout = false;
                if (dto.getInOrOut().equals("out")) {
                    inout = true;
                }
                preStm.setBoolean(4, inout);
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
