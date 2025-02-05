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
import modal.MyPetReport;
import modal.MyPetReportFacade;
import modal.MyVeterinary;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "GenerateReport", urlPatterns = {"/GenerateReport"})
public class GenerateReport extends HttpServlet {

    @EJB
    private MyAppointmentsFacade myAppointmentsFacade;
    
    @EJB
    private MyPetReportFacade myPetReportFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String apptId = request.getParameter("appointmentId");
        String petname = request.getParameter("petname");
        
        
        try (PrintWriter out = response.getWriter()) {
            try{

                MyAppointments appointment = myAppointmentsFacade.find(Long.parseLong(apptId));
                
                List<MyPetReport> petreport = myPetReportFacade.searchByPetName((petname));
                
                request.setAttribute("foundAppointment", appointment);
                request.setAttribute("foundReportt", petreport);
                

                    
                    
                request.getRequestDispatcher("GenerateReport.jsp").forward(request, response);
                
                
            }catch(Exception e){
                request.getRequestDispatcher("VeterinaryDashboard.jsp").include(request,response);
                out.println("<br><br> Sorry " + e.getCause() + ", invalid input");
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
