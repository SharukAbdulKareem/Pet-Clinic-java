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
import javax.servlet.http.HttpSession;
import modal.MyReceptionist;
import modal.MyReceptionistFacade;
import modal.MyStaff;
import modal.MyStaffFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "StaffLogin", urlPatterns = {"/StaffLogin"})
public class StaffLogin extends HttpServlet {

    @EJB
    private MyStaffFacade myStaffFacade;
    
    
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String passwordd = request.getParameter("password");

        
        
        try (PrintWriter out = response.getWriter()) {
            try{
                MyStaff found = myStaffFacade.searchByUsername(username);
                
                // if name not found 
                if (found == null){
                    throw new Exception();
                }
                
                // password is int
                int password = Integer.parseInt(passwordd);
                
                if (password != found.getPassword()){
                    throw new Exception();
                }
                
                HttpSession s = request.getSession();
                s.setAttribute("staff",found);
                

                
                request.getRequestDispatcher("StaffDashboard.jsp").include(request,response);

                
                
            }catch(Exception e){
                request.getRequestDispatcher("StaffLogin.jsp").include(request,response);
                 out.println("<div class='p-3'><div class='alert alert-danger' role='alert'>Wrong Username or Password</div></div>");

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
