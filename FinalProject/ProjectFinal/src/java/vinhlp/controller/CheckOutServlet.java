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
import vinhlp.account.AccountDTO;
import vinhlp.bill.BillDAO;
import vinhlp.billdetails.BillDetailsDAO;
import vinhlp.book.BookDTO;
import vinhlp.cart.CartObject;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(CheckOutServlet.class.getName());
    
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
        try {
            HttpSession session = request.getSession();
            //get cart
            CartObject cart = (CartObject) session.getAttribute("CART");
            //get current account
            AccountDTO currentAccount = (AccountDTO) session.getAttribute("CURRENT_ACCOUNT");
            //get total of all cart
            float total = (float) session.getAttribute("TOTAL_ALL_CART");
            if(cart != null){
                //insert data into bill table
                BillDAO dao = new BillDAO();
                boolean result = false;
                result = dao.insertNewBill(currentAccount.getUsername(), total, currentAccount.getAddress());
                //insert all book they buy into bill detail
                if (result){
                    BillDetailsDAO detailsDAO = new BillDetailsDAO();
                    for (BookDTO dto : cart.getItem().keySet()){
                        result = detailsDAO.insertNewRecord(dao.getCurrentBill(), dto.getId(), cart.getItem().get(dto));
                    }
                    if (result){
                        session.removeAttribute("CART");
                        session.removeAttribute("TOTAL_ALL_CART");
                        request.setAttribute("CHECKOUT_STATUS", "Check out success!");
                    }
                }
            }
        }
        catch (SQLException e){
            logger.error("SQL error - "+e.getMessage());
        }
        catch (NamingException e){
            logger.error("Naming error - "+e.getMessage());
        }
        finally {
            RequestDispatcher rd = request.getRequestDispatcher("shopping.jsp");
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
