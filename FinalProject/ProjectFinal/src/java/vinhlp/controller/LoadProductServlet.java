/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import vinhlp.book.BookDAO;
import vinhlp.book.BookDTO;
import vinhlp.category.CategoryDAO;
import vinhlp.category.CategoryDTO;

/**
 *
 * @author Asus
 */
@WebServlet(name = "LoadProductServlet", urlPatterns = {"/LoadProductServlet"})
public class LoadProductServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(LoadProductServlet.class.getName());
    
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
            BookDAO dao = new BookDAO();
            dao.getAllBook();
            List<BookDTO> allBooks = dao.getAllBooks();
            HttpSession session = request.getSession();
            session.setAttribute("PRODUCT_STORE", allBooks);
            CategoryDAO cateDAO = new CategoryDAO();
            cateDAO.loadAllCategory();
            List<CategoryDTO> allCate = cateDAO.getAllCategories();
            session.setAttribute("CATEGORY_DTO", allCate);
        }
        catch (SQLException e){
            logger.error("SQL error - "+e.getMessage());
        }
        catch (NamingException e){
            logger.error("Naming error - "+e.getMessage());
        }
        finally {
            response.sendRedirect("shoppingPage");
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
