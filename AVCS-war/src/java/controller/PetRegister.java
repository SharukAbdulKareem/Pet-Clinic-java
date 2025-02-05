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
import modal.MyPets;
import modal.MyPetsFacade;
import modal.MyVeterinary;
import modal.MyVeterinaryFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "PetRegister", urlPatterns = {"/PetRegister"})
public class PetRegister extends HttpServlet {

    
    @EJB
    private MyPetsFacade myPetsFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ownername = request.getParameter("username");
        String icnumber =  request.getParameter("icnumber");
        String address = request.getParameter("address");
        String contact2 = request.getParameter("contact");
        String email = request.getParameter("email");
        
        
        String petname = request.getParameter("petName");
        String breed = request.getParameter("breed");
        String sex = request.getParameter("sex");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            try{


                int contact = Integer.parseInt(contact2);
  
                myPetsFacade.create(new MyPets( ownername, icnumber, address,  contact,  email,  petname,  breed, sex));
                request.getRequestDispatcher("ReceptionistDashboard.jsp").include(request,response);
                out.println("<div class='p-3'><div class='alert alert-success' role='alert'>Hi " + ownername + ", Registration has been completed. Welcome to APU Veterinary Clinic Doctor.</div></div>");

                
            }catch(Exception e){
                request.getRequestDispatcher("ReceptionistDashboard.jsp").include(request,response);
                out.println("<div class='p-3'><div class='alert alert-danger' role='alert'>Sorry " + e.getLocalizedMessage() + e.toString() + e.getCause()+   ", something is wrong</div></div>");
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
