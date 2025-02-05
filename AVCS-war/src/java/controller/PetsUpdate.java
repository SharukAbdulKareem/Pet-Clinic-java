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

/**
 *
 * @author sharuk
 */
@WebServlet(name = "PetsUpdate", urlPatterns = {"/PetsUpdate"})
public class PetsUpdate extends HttpServlet {
    
    @EJB
    private MyPetsFacade myPetsFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String petOwnerId = request.getParameter("petId");
        String newUsername = request.getParameter("nusername");
        String newICnumber = request.getParameter("nicnumber");
        String newEmail = request.getParameter("nemail");
        String newContactNumberr = request.getParameter("ncontactnumber");
        String newAddress = request.getParameter("naddress");
        String newpetname = request.getParameter("npetname");
        String newbreed = request.getParameter("nbreed");
        String newsex = request.getParameter("nsex");
        
        
                try (PrintWriter out = response.getWriter()) {
                    try{

        //                MyVets vet = myVetsFacade.find(Long.parseLong(vetIdStr));

                        MyPets vet = myPetsFacade.find(Long.parseLong(petOwnerId));

                        if (vet == null){
                            throw new Exception();
                        }

                        else{

                            int contact = Integer.parseInt(newContactNumberr);
                            



                            myPetsFacade.edit(new MyPets(Long.parseLong(petOwnerId), newUsername ,newICnumber,newAddress, contact, newEmail, newpetname, newbreed, newsex ));
//                            HttpSession s = request.getSession();
//                            s.setAttribute("vet",myVetsFacade.find(Long.parseLong(vetIdStr)));

                            request.getRequestDispatcher("ReceptionistDashboard.jsp").include(request,response);
//                            out.println("<br><br>I Love You... Hi " + vetIdStr + ", update completed.");
                            out.println("<div class='p-3'><div class='alert alert-success' role='alert'> Details for "+ vet.getOwnername() +" and his beloved pet has been updated.</div></div>");


                        }


                    }catch(Exception e){
        //                request.getRequestDispatcher("dashboardVet.jsp").include(request,response);
                        out.println("<br><br>  Sorry " + petOwnerId + ", invalid didnt change");
                        out.println(e); 
        //                out.println(e.printStackTrace().toString());
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
