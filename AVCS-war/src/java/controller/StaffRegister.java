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
import modal.MyStaff;
import modal.MyStaffFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "StaffRegister", urlPatterns = {"/StaffRegister"})
public class StaffRegister extends HttpServlet {

    @EJB
    private MyStaffFacade myStaffFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("name");
        String agee = request.getParameter("age");
        String contactt = "60" + request.getParameter("contact");
        String email = request.getParameter("email"); 
        String passwordd = request.getParameter("fpassword");
        
        
        try (PrintWriter out = response.getWriter()) {
            try{

                MyStaff found = myStaffFacade.searchByUsername(username);
                
                if (found != null){
                    throw new Exception();
                }
                int age1 = 0;
                
                try{
                     age1 = Integer.parseInt(agee);
                    
                }catch(NumberFormatException e){
                    out.println("<div class='p-3'><div class='alert alert-danger' role='alert'>Number Format Shouldn't Be in String Format</div></div>");
                }
                
                int contact = Integer.parseInt(contactt);
                int password = Integer.parseInt(passwordd);
                
                myStaffFacade.create(new MyStaff(username,age1,contact,email,password));
                request.getRequestDispatcher("StaffLogin.jsp").include(request,response);
                out.println("<div class='p-3'><div class='alert alert-success' role='alert'>Hi " + username + ", Registration has been completed.</div></div>");
                
                
            }catch(Exception e){
                request.getRequestDispatcher("StaffRegister.jsp").include(request,response);
                out.println("<div class='p-3'><div class='alert alert-danger' role='alert'>Sorry " + e.getLocalizedMessage() + ", invalid input</div></div>");
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
