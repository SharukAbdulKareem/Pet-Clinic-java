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
import modal.MyReceptionist;
import modal.MyReceptionistFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "ReceptionistUpdate", urlPatterns = {"/ReceptionistUpdate"})
public class ReceptionistUpdate extends HttpServlet {

    @EJB
    private MyReceptionistFacade myReceptionistFacade; 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            
        String recepName = request.getParameter("recepName");
        String recepIdStr = request.getParameter("recepId");
        String newAge = request.getParameter("nage");
        String newContactNumberr = request.getParameter("ncontactnumber");
        String newEmail = request.getParameter("nemail");
        String newGender = request.getParameter("ngender");
        String newconfPassword = request.getParameter("confNPassword");
        
        
        try (PrintWriter out = response.getWriter()) {
            
                        try{
        
                   // MyVets vet = myVetsFacade.find(Long.parseLong(vetIdStr));

                        MyReceptionist recep = myReceptionistFacade.find(Long.parseLong(recepIdStr));

                        if (recep == null){
                            throw new Exception();
                        }

                        else{

                            int age = Integer.parseInt(newAge);
                            int contact = Integer.parseInt(newContactNumberr);
                            int password = Integer.parseInt(newconfPassword);



                            myReceptionistFacade.edit(new MyReceptionist(Long.parseLong(recepIdStr), recepName , age, contact, newEmail,newGender,  password , true  ));
//                            HttpSession s = request.getSession();
//                            s.setAttribute("recep",myReceptionistFacade.find(Long.parseLong(recepIdStr)));

                            request.getRequestDispatcher("StaffDashboard.jsp").include(request,response);
//                            out.println("<br><br>I Love You... Hi " + recepIdStr + ", update completed.");
                            out.println("<div class='p-3'><div class='alert alert-success' role='alert'> Details of "+ recep.getUsername() +" has been updated.</div></div>");



                        }
                        }catch(Exception e){
        //                request.getRequestDispatcher("dashboardVet.jsp").include(request,response);
                        out.println("<br><br> ILY Sorry " + recepName + ", invalid didnt change");
                        out.println(e); 
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
