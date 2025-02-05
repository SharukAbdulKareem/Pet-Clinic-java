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
import modal.MyVeterinary;
import modal.MyVeterinaryFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "VeterinaryUpdateOwn", urlPatterns = {"/VeterinaryUpdateOwn"})
public class VeterinaryUpdateOwn extends HttpServlet {

     @EJB
    private MyVeterinaryFacade myVeterinaryFacade;
     
     @EJB
    private MyAppointmentsFacade myAppointmentsFacade;
     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String recepName = request.getParameter("vetName");
        String recepIdStr = request.getParameter("vetId");
        String newMedicID = request.getParameter("nmedicalID");
        String newContactNumberr = request.getParameter("ncontactnumber");
        String newEmail = request.getParameter("nemail");
        String newGender = request.getParameter("ngender");
        String nex1 = request.getParameter("nexpertise1");
        String nex2 = request.getParameter("nexpertise2");

        String newconfPassword = request.getParameter("confNPassword");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            
            try{
                HttpSession session = request.getSession();
                MyVeterinary veterinary = (MyVeterinary) session.getAttribute("veterinary");
                String veterinaryId = veterinary.getUsername();
  
                            int contact = Integer.parseInt(newContactNumberr);
                            int password = Integer.parseInt(newconfPassword);



                            MyVeterinary updatedVeterinary = new MyVeterinary(Long.parseLong(recepIdStr), recepName, contact, newEmail,newGender,newMedicID,nex1,nex2,  password , true  );
//                            HttpSession s = request.getSession();
//                            s.setAttribute("recep",myReceptionistFacade.find(Long.parseLong(recepIdStr)));
                            myVeterinaryFacade.edit(updatedVeterinary);

                            session.setAttribute("veterinary", updatedVeterinary);
                            
                            List<MyAppointments> updatedAppointments = myAppointmentsFacade.searchByVet(veterinaryId)  ;

                // Set updated appointment list as request attribute
                            request.setAttribute("reportList", updatedAppointments);
                            
                            request.getRequestDispatcher("VeterinaryDashboard.jsp").include(request,response);
//                            out.println("<br><br>I Love You... Hi " + recepIdStr + ", update completed.");
                            out.println(" Your details has been updated succesfully");


                        
                        }catch(Exception e){
        //                request.getRequestDispatcher("dashboardVet.jsp").include(request,response);
                        out.println("<br><br> ILY Sorry " + recepIdStr + ", invalid didnt change");
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
