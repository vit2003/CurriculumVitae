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
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import vinhlp.account.AccountDAO;
import vinhlp.account.AccountDTO;

/**
 *
 * @author Asus
 */
@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/DeleteAccountServlet"})
public class DeleteAccountServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(DeleteAccountServlet.class.getName());
    private final String SEARCH_PAGE = "searchPage";

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

        String pk = request.getParameter("pk");
        String lastSearch = request.getParameter("searchValue");
        String url = SEARCH_PAGE;
        boolean error = true;
        try {
            HttpSession session = request.getSession();
            AccountDTO dto = (AccountDTO) session.getAttribute("CURRENT_ACCOUNT");
            String currentUsername = dto.getUsername().trim();
            System.out.println("current user: " + currentUsername);
            System.out.println("pk: " + pk);
            if (!currentUsername.equals(pk.trim().toLowerCase())) {
                AccountDAO dao = new AccountDAO();
                boolean result = dao.deleteAccount(pk);
                if (result) {
                    error = false;
                    url = "search?txtSearch=" + lastSearch;
                }
            }
            if (error) {
                if (currentUsername.equals(pk.trim().toLowerCase())){
                    request.setAttribute("DELETE_ACCOUNT_ERROR", "Can't delete logging account");
                } else {
                    request.setAttribute("DELETE_ACCOUNT_ERROR", "Error when delete account");
                }
                RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            logger.error("SQL error - " + e.getMessage());
        } catch (NamingException e) {
            logger.error("Naming error - " + e.getMessage());
        } finally {
            if (!error) {
                response.sendRedirect(url);
            }
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
