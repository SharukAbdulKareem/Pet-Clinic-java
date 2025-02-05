/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.MyVeterinary;
import modal.MyVeterinaryFacade;
import modal.MyWeeklyRota;
import modal.MyWeeklyRotaFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "WeeklyRotaDate", urlPatterns = {"/WeeklyRotaDate"})
public class WeeklyRotaDate extends HttpServlet {

    @EJB
    private MyWeeklyRotaFacade myweeklyRotaFacade;
    
    @EJB
    private MyVeterinaryFacade myVeterinaryFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String selectedDate = request.getParameter("sundaySelect");
        
        
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date startDate = sdf.parse(selectedDate);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                Date endDate = calendar.getTime();

                List<MyWeeklyRota> weeklyRotaList = myweeklyRotaFacade.findAll();
                

                // Filter rows within the date range
                boolean dateFounded = false;
                
                List<MyWeeklyRota> weeklyRotaDetailsList = new ArrayList<>();
                
                for (MyWeeklyRota wRota : weeklyRotaList) {
                    Date rotaDate = sdf.parse(wRota.getId());
                    if (rotaDate.after(startDate) && rotaDate.before(endDate) && !rotaDate.equals(endDate)) {
                        // Add details to the list
                        MyWeeklyRota details = new MyWeeklyRota( wRota.getId(), wRota.getVet1(), wRota.getVet2(),wRota.getVet3()
                        );
                        weeklyRotaDetailsList.add(details);
                        
                        dateFounded = true;
                    }
                    
                    if (rotaDate.equals(startDate)) {
                        // Extract details for the selected date
                        String vet1 = wRota.getVet1();
                        String vet2 = wRota.getVet2();
                        String vet3 = wRota.getVet3();
                        
                        MyWeeklyRota details = new MyWeeklyRota(wRota.getId(), vet1,vet2, vet3 );
                        
                        weeklyRotaDetailsList.add(details);
                        
                        dateFounded = true;
                    }

                }
                
                if (dateFounded) {
                    List<MyVeterinary> vets = myVeterinaryFacade.findAll();
                    request.setAttribute("vetList", vets);
                    request.setAttribute("weeklyRotaDetailsList", weeklyRotaDetailsList);
                    request.getRequestDispatcher("UpdateWeeklyRota.jsp").include(request, response);
                }

                if (!dateFounded) {
                    List<MyVeterinary> allVets = myVeterinaryFacade.findAll();
                    request.setAttribute("vetList", allVets);
                    request.setAttribute("selectedDate", selectedDate);
                    request.getRequestDispatcher("CreateWeeklyRota.jsp").include(request, response);
                }
                

            } catch (Exception e) {
                out.println("Error parsing date: " + e.getMessage());
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
