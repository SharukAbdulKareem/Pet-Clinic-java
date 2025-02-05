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
import modal.MyVeterinary;
import modal.MyVeterinaryFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "DeleteVets", urlPatterns = {"/DeleteVets"})
public class DeleteVets extends HttpServlet {

    @EJB
    private MyVeterinaryFacade myVeterinaryFacade; 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String vetId = request.getParameter("receptionistId");  
        
        
        MyVeterinary foundVets = myVeterinaryFacade.find(Long.parseLong(vetId));
        
        try (PrintWriter out = response.getWriter()) {
            try{
  

            MyVeterinary foundVets1 = myVeterinaryFacade.find(Long.parseLong(vetId));
            
            if (foundVets1 != null) {
                    // Set the foundReport attribute for JSP to access
                    
                    request.setAttribute("vetsList", foundVets1);
                    
                    
            } else {
                    // Set an empty list to indicate no report found
                    request.setAttribute("vetsList", null);
                    
            }
                
                
                request.getRequestDispatcher("SUpdateVetsDetails.jsp").include(request,response);
                
         
                
            }catch(Exception e){
                request.getRequestDispatcher("StaffDashboard.jsp").include(request,response);
                out.println("<br><br> Sorry " + foundVets.getUsername()   + ", invalid input");
                e.printStackTrace();
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
