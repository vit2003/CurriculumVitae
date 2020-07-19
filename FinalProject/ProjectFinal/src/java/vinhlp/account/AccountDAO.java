/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.account;

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
public class AccountDAO implements Serializable {

    private List<AccountDTO> searchResult;

    public List<AccountDTO> getSearchResult() {
        return searchResult;
    }

    public AccountDTO checkLogin(String username, String password) throws SQLException, NamingException {
        AccountDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        con = ConnectSupport.makeConnect();
        if (con != null) {
            String sql = "Select fullname, isAdmin, address From account Where username = ? And password = ? And status = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setBoolean(3, true);
            rs = stm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("fullname");
                boolean isAdmin = rs.getBoolean("isAdmin");
                String address = rs.getString("address");
                result = new AccountDTO(username, fullname, isAdmin, address);
            }
        }
        return result;
    }

    public void searchAccount(String searchValue) throws SQLException, NamingException {
        AccountDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        con = ConnectSupport.makeConnect();
        searchResult = new ArrayList<>();
        if (con != null) {
            String sql = "Select username, fullname, password, isAdmin, address From account Where fullname Like ? And status = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%"+searchValue+"%");
            stm.setBoolean(2, true);
            rs = stm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fulname = rs.getString("fullname");
                boolean isAdmin = rs.getBoolean("isAdmin");
                String address = rs.getString("address");
                AccountDTO dto = new AccountDTO(username, password, fulname, isAdmin, address);
                searchResult.add(dto);
            }
        }
    }
    
    public boolean deleteAccount (String username) throws SQLException, NamingException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Update account Set status = 'false' Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
    
    public boolean checkAccountIsAdmin(String username) throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        con = ConnectSupport.makeConnect();
        if (con != null) {
            String sql = "Select isAdmin From account Where username = ? And isAdmin = ? And status = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setBoolean(2, true);
            stm.setBoolean(3, true);
            rs = stm.executeQuery();
            if (rs.next()) {
                result = true;
            }
        }
        return result;
    }
    
    public boolean updateAccount (String username, String password, boolean isAdmin, String address) throws SQLException, NamingException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Update account Set password = ?, isAdmin = ?, address = ? Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, isAdmin);
                stm.setString(3, address);
                stm.setString(4, username);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
    
    public boolean insertNewAccount (AccountDTO dto) throws SQLException, NamingException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Insert Into account(username, password, fullname, isAdmin, status, address) Values (?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullname());
                stm.setBoolean(4, dto.isIsAdmin());
                stm.setBoolean(5, true);
                stm.setString(6, dto.getAddress());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
    
    public boolean isAccountDeleted (String username) throws SQLException, NamingException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Select username from account where username = ? and status = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setBoolean(2, false);
                rs = stm.executeQuery();
                if (rs.next()){
                    result = true;
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
        return result;
    }
    
    public boolean updateAllInformationOfAccount (AccountDTO dto) throws SQLException, NamingException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = ConnectSupport.makeConnect();
            if (con != null){
                String sql = "Update account Set password = ?, fullname = ?, isAdmin = ?, address = ?, status = ? Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getPassword());
                stm.setString(2, dto.getFullname());
                stm.setBoolean(3, dto.isIsAdmin());
                stm.setString(4, dto.getAddress());
                stm.setBoolean(5, true);
                stm.setString(6, dto.getUsername());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
}
