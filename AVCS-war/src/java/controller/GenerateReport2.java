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
@WebServlet(name = "GenerateReport2", urlPatterns = {"/GenerateReport2"})
public class GenerateReport2 extends HttpServlet {

    @EJB
    private MyPetReportFacade myPetReportFacade ; 
    
    @EJB
    private MyAppointmentsFacade myAppointmentsFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String petId = request.getParameter("petId");
        
        String diagnosis = request.getParameter("diagnosis");
        String prognosis = request.getParameter("prognosis");
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            
            try{
                HttpSession session = request.getSession();
                MyVeterinary veterinary = (MyVeterinary) session.getAttribute("veterinary");
                String veterinaryId = veterinary.getUsername();
                
                
                MyAppointments found = myAppointmentsFacade.find(Long.parseLong(petId));
                
                
                    
                myPetReportFacade.create(new MyPetReport(  diagnosis,prognosis, found ));
                
                List<MyAppointments> updatedAppointments = myAppointmentsFacade.searchByVet(veterinaryId)  ;

                // Set updated appointment list as request attribute
                request.setAttribute("reportList", updatedAppointments);

                // Forward the request to VeterinaryDashboard.jsp
                request.getRequestDispatcher("VeterinaryDashboard.jsp").forward(request, response);
                
//                request.getRequestDispatcher("VeterinaryDashboard.jsp").forward(request,response);
//                HttpSession s = request.getSession();
//                s.setAttribute("veterinary",found);
                
                
//                out.println("<script>");
//                out.println("alert('Report has been succesfully generated');");
//                out.println("window.location.href='" + request.getContextPath() + "/VeterinaryDashboard.jsp'");
//                out.println("</script>");
//                request.getRequestDispatcher("StaffDashboard.jsp").include(request,response);
                
                
                    
                
                
            }catch (Exception e){
                request.getRequestDispatcher("notfound.jsp").include(request, response);
                out.println("<br><br>Sorry " + petId + ", invalid input");
                
                
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
