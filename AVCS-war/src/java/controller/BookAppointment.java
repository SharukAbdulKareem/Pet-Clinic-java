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
import modal.MyAppointments;
import modal.MyAppointmentsFacade;
import modal.MyPets;
import modal.MyPetsFacade;
import modal.MyWeeklyRota;
import modal.MyWeeklyRotaFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "BookAppointment", urlPatterns = {"/BookAppointment"})
public class BookAppointment extends HttpServlet {

   
    @EJB
    private MyWeeklyRotaFacade myweeklyRotaFacade;

    @EJB
    private MyPetsFacade myPetsFacade;
    
    @EJB
    private MyAppointmentsFacade myAppointmentsFacade;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
//        long petId = Long.parseLong(request.getParameter("petId"));
        
        String vetAssigned = request.getParameter("vetAssigned");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime"); // Retrieve appointment time
        
        try (PrintWriter out = response.getWriter()) {
            try{
                
               Long petId = Long.parseLong(request.getParameter("petId"));

                
                MyPets pet = myPetsFacade.find(petId);
                
                // Convert petId to String
//                String petIdAsString = String.valueOf(pet.getId());
                

                if (!isAppointmentClashing(vetAssigned, appointmentDate, appointmentTime)) {
                    myAppointmentsFacade.create(new MyAppointments(pet.getId(), pet.getOwnername(),pet.getPetname(), pet.getBreed() , pet.getSex(), appointmentDate, appointmentTime, vetAssigned));
                    out.println("<script>");
                    out.println("alert('Success: Appointment has been made successfully!');");
                    
                    
                    out.println("window.location.href='" + request.getContextPath() + "/ReceptionistDashboard.jsp'");
                    
                    out.println("</script>");
                } else {
                    out.println("<script>");
                    out.println("alert('Error: Another appointment already exists at the selected time! Please choose a different time.');");
                    out.println("window.location.href='" + request.getContextPath() + "/ReceptionistDashboard.jsp'");
                    out.println("</script>");
                }

            } catch (Exception e) {
                out.println("<script>");
                out.println("alert('Error: " + e.getMessage() + e.getCause() + "');");
                out.println("window.location.href='ReceptionistDashboard.jsp';");
                out.println("</script>");
           
            }
            
            
        }
    }
    
    
    private boolean isAppointmentClashing(String vetAssigned, String appointmentDate, String appointmentTime) {
        // Retrieve appointments for the specified vet, date, and time
        List<MyAppointments> appointments = myAppointmentsFacade.findByVetDateAndTime(vetAssigned, appointmentDate, appointmentTime);
        // If appointments list is not empty, there's a clash
        return !appointments.isEmpty();
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
