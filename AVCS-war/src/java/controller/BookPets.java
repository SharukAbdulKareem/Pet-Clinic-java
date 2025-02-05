/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.MyPets;
import modal.MyPetsFacade;
import modal.MyWeeklyRota;
import modal.MyWeeklyRotaFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "BookPets", urlPatterns = {"/BookPets"})
public class BookPets extends HttpServlet {

    @EJB
    private MyWeeklyRotaFacade myweeklyRotaFacade;

    @EJB
    private MyPetsFacade myPetsFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        LocalDate todaysDate = LocalDate.now();

        // DateTimeFormatter to parse date strings from the database
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        List<String> choosenDates = new ArrayList<String>();
        
        
        
        try (PrintWriter out = response.getWriter()) {
                        try{
                List<MyPets> allPetProfiles = myPetsFacade.findAll();
                
                List<MyWeeklyRota> allWeeklyRota = myweeklyRotaFacade.findAll();
                
                for (MyWeeklyRota weeklyRota : allWeeklyRota) {
                    // Get the date string from the WeeklyRota object
                    String String = weeklyRota.getId();

                    // Parse the date string to LocalDate
                    LocalDate rotaDate = LocalDate.parse(String, formatter);

                    // Check if the rotaDate is equal to or after the current date
                    if (!rotaDate.isBefore(todaysDate)) {
                        // Add the date string to the list
                        choosenDates.add(String);
                    }
                }
                
                // Set the staffList as a request attribute
                request.setAttribute("petProfiles", allPetProfiles);
                
                request.setAttribute("dates", choosenDates);

                // Forward the request to the JSP page
                request.getRequestDispatcher("AssignVets.jsp").include(request, response);

            }catch(Exception e){
                request.getRequestDispatcher("receptionistHome.jsp").include(request, response);
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
