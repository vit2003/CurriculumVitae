/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import vinhlp.account.AccountDAO;
import vinhlp.account.AccountDTO;
import vinhlp.account.UpdateAccountError;

/**
 *
 * @author Asus
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(UpdateServlet.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String chkAdmin = request.getParameter("chkAdmin");
        String address = request.getParameter("txtAddress");
        boolean isAdmin = false;
        if (chkAdmin != null) {
            isAdmin = true;
        }
        String lastSearch = request.getParameter("txtLastSearch");
        boolean foundError = false;
        UpdateAccountError error = new UpdateAccountError();
        HttpSession session = request.getSession();
        AccountDTO dto = (AccountDTO) session.getAttribute("CURRENT_ACCOUNT");

        try {
            if (password.length() < 6 || password.length() > 50) {
                error.setPasswordLegthErr("Password must to 6 to 50 character!");
                foundError = true;
            }
            if (username.equalsIgnoreCase(dto.getUsername())) {
                error.setChangeCurrentAccountErr("Can't change password of the account is loging in");
                foundError = true;
            }
            AccountDAO dao = new AccountDAO();
            if (dao.checkAccountIsAdmin(username) && !isAdmin) {
                error.setUnAdminErr("Can't change role of account is Admin");
                foundError = true;
            }
            if (address.length() == 0){
                error.setNullAddressErr("Can't update with null address");
                foundError = true;
            }
            if (foundError) {
                session.setAttribute("UPDATE_ERROR", error);
            } else {
                boolean result = dao.updateAccount(username, password, isAdmin, address);
                if (result) {

                } else {
                    error.setUpdateDatabaseErr("Update process fail!");
                    session.setAttribute("UPDATE_ERROR", error);
                }
            }
            if (!foundError) {
                session.removeAttribute("UPDATE_ERROR");
            }
        } catch (SQLException e) {
            logger.error("SQL error - " + e.getMessage());
        } catch (NamingException e) {
            logger.error("Naming error - " + e.getMessage());
        } finally {
            String url = "search?txtSearch=" + lastSearch;
            response.sendRedirect(url);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
