/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.MyReceptionist;
import modal.MyReceptionistFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "ReceptionistSearch", urlPatterns = {"/ReceptionistSearch"})
public class ReceptionistSearch extends HttpServlet {

    @EJB
    private MyReceptionistFacade myReceptionistFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String recepName = request.getParameter("receptionistname");
        
        
        try (PrintWriter out = response.getWriter()) {
            try {
                List<MyReceptionist> findReceptionist = myReceptionistFacade.searchByReceptionistName(recepName);
                

                if (findReceptionist != null) {
                    // Set the foundReport attribute for JSP to access
                    request.setAttribute("receptionistList", findReceptionist);
                } else {
                    // Set an empty list to indicate no report found
                    request.setAttribute("reportList", null);
                    
                }

                // Forward to the JSP page to display report details
                request.getRequestDispatcher("ReceptionistTable2.jsp").forward(request, response);

            } catch (Exception e) {
                // Handle exceptions, redirect to an error page, or display an error message
                request.getRequestDispatcher("error.jsp").include(request, response);
                out.println("<br><br>Sorry, an error occurred.");
            }
            
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
