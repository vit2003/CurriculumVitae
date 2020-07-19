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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import vinhlp.account.AccountDAO;
import vinhlp.account.AccountDTO;
import vinhlp.account.CreateNewAccountError;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CreateNewAccountServlet", urlPatterns = {"/CreateNewAccountServlet"})
public class CreateNewAccountServlet extends HttpServlet {

    private final String REGIS_PAGE = "createaccount.jsp";
    private final String LOGIN_PAGE = "login.html";
    static Logger logger = Logger.getLogger(CreateNewAccountServlet.class.getName());

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

        String username = request.getParameter("txtUsername").trim();
        String password = request.getParameter("txtPassword").trim();
        String confirm = request.getParameter("txtConfirm").trim();
        String fullname = request.getParameter("txtFullname").trim();
        String address = request.getParameter("txtAddress").trim();
        CreateNewAccountError error = new CreateNewAccountError();
        boolean foundErr = false;

        String url = REGIS_PAGE;

        try {
            if (username.length() < 6 || username.length() > 30) {
                error.setUsernameLegthErr("The username must be form 6 to 30 character!");
                foundErr = true;
            }
            if (password.length() < 6 || password.length() > 50) {
                error.setPasswordLegthErr("The password must be form 6 to 50 character!");
                foundErr = true;
            } else {
                if (!confirm.equals(password)) {
                    error.setConfirmWrongErr("The confirm password is wrong!");
                    foundErr = true;
                }
            }
            if (fullname.length() < 6 || fullname.length() > 50) {
                error.setFullnameLegthErr("The fullname must be form 6 to 50 character!");
                foundErr = true;
            }
            if (address.length() < 6) {
                error.setAddressLegthErr("The address is too sort to valid!");
                foundErr = true;
            }
            if (foundErr) {
                request.setAttribute("CREATE_ACCOUNT_ERROR", error);
            } else {
                AccountDTO dto = new AccountDTO(username, password, fullname, false, address);
                AccountDAO dao = new AccountDAO();
                boolean isExistButDeleted = dao.isAccountDeleted(username);
                boolean result = false;
                if (isExistButDeleted) {
                    result = dao.updateAllInformationOfAccount(dto);
                } else {
                    result = dao.insertNewAccount(dto);
                }
                if (result) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException e) {
            String message = e.getMessage();
            if (message.contains("duplicate")) {
                error.setDuplacateAccountErr("This username has been used!");
            }
            logger.error("SQL error - " + e.getMessage());
        } catch (NamingException e) {
            logger.error("Naming error - " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
