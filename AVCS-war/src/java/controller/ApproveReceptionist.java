/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ApproveReceptionist", urlPatterns = {"/ApproveReceptionist"})
public class ApproveReceptionist extends HttpServlet {

    @EJB
    private MyReceptionistFacade myReceptionistFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String recepId = request.getParameter("recepId");
        
        try (PrintWriter out = response.getWriter()) {
            try{

                MyReceptionist found = myReceptionistFacade.find(Long.parseLong(recepId));
                                             
                if(found == null){
                    out.println("error");
                }else{

                    found.setIs_approved(true);
                    

                    myReceptionistFacade.edit(found);
                    request.getRequestDispatcher("StaffDashboard.jsp").include(request, response);
            
                }
            }catch(Exception e){
                request.getRequestDispatcher("notfound.jsp").include(request, response);
                out.println("<br><br>Sorry " + recepId  + ", invalid input");
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
