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
import modal.MyAppointments;
import modal.MyAppointmentsFacade;
import modal.MyWeeklyRotaFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "DeleteAppointment", urlPatterns = {"/DeleteAppointment"})
public class DeleteAppointment extends HttpServlet {

    @EJB
    private MyAppointmentsFacade myAppointmentsFacade;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String appointmentId = request.getParameter("appointmentId");   
        
        MyAppointments removedAppointment =  myAppointmentsFacade.find(Long.parseLong(appointmentId));
        
        
        
        try (PrintWriter out = response.getWriter()) {
            try{
            
                if(appointmentId != null && !appointmentId.isEmpty()){


                    if(removedAppointment != null){
                    myAppointmentsFacade.remove(removedAppointment);
                    out.println("<script>");
                    out.println("alert('Success: Appointment has been deleted successfully!');");
                    out.println("window.location.href='ReceptionistDashboard.jsp';");
                    out.println("</script>");
                    
                    



                } else {

                         response.sendRedirect("notfound.jsp");
                    }

                } else{
                    response.sendRedirect("notfound.jsp");
                }
            } catch(Exception e){
                e.printStackTrace();
                response.sendRedirect("notfound.jsp");
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
