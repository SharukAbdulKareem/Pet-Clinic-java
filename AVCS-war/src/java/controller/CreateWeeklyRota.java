/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.MyWeeklyRota;
import modal.MyWeeklyRotaFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "CreateWeeklyRota", urlPatterns = {"/CreateWeeklyRota"})
public class CreateWeeklyRota extends HttpServlet {
    
    @EJB
    private MyWeeklyRotaFacade myweeklyRotaFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try{
                List<String> daysOfWeek = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
                for (String day : daysOfWeek) {
                    // Get values for each day
                    String date = request.getParameter("date_" + day);
                    String vet1 = request.getParameter("vet1_" + day);
                    String vet2 = request.getParameter("vet2_" + day);
                    String vet3 = request.getParameter("vet3_" + day);                  

                    // Insert into the database
                    myweeklyRotaFacade.create(new MyWeeklyRota(date, vet1, vet2, vet3));
                }
                
                out.println("<script>");
                out.println("alert('The chosen week rota has been created successfully!');");
                out.println("window.location.href='StaffDashboard.jsp';");
                out.println("</script>");
                
            } catch(Exception e){
                out.println("<script>");
                out.println("alert('Error: An error occured white creating the week rota!');");
                out.println("window.location.href='StaffDashboard.jsp';");
                out.println("</script>");
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
