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
import modal.MyAppointments;
import modal.MyAppointmentsFacade;
import modal.MyReceptionist;
import modal.MyVeterinary;
import modal.MyVeterinaryFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "VeterinaryLogin", urlPatterns = {"/VeterinaryLogin"})
public class VeterinaryLogin extends HttpServlet {

    @EJB
    private MyVeterinaryFacade myVeterinaryFacade;
    
    @EJB
    private MyAppointmentsFacade myAppointmentsFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String username = request.getParameter("username");
            String passwordd = request.getParameter("password");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            try{
                MyVeterinary found = myVeterinaryFacade.searchByDoctorsName(username);
                
                if (!found.isIs_approved()) {
                    throw new VetsNHaventBeenApprovedException("<div class='p-3'><div class='alert alert-danger' role='alert'>Haven't Approved Yet</div></div>");
                    
                }
                
                
                
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
                s.setAttribute("veterinary",found);
                
                
                List<MyAppointments> foundAppointment = myAppointmentsFacade.searchByVet(username);
                
                if (foundAppointment != null) {
                    // Set the foundReport attribute for JSP to access
                    request.setAttribute("reportList", foundAppointment);
                    
                } else {
                    // Set an empty list to indicate no report found
                    request.setAttribute("reportList", null);
                    
                }

                request.getRequestDispatcher("VeterinaryDashboard.jsp").include(request,response);
//                out.println("<br><br> Hi" + username + ", welcome to APU");
                
                
            }catch(VetsNHaventBeenApprovedException e){
                request.getRequestDispatcher("VeterinaryLogin.jsp").include(request,response);
                 out.println("<div class='p-3'><div class='alert alert-danger' role='alert'>You Are Haven't Been Approved Yet By Our Staff</div></div>");

            }catch(Exception e){
                request.getRequestDispatcher("loginReceptionist.jsp").include(request,response);
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

class VetsNHaventBeenApprovedException extends Exception {

    public VetsNHaventBeenApprovedException(String message) {
        super(message);
    }
}
