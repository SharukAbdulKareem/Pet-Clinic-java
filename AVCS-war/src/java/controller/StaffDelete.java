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
import javax.servlet.http.HttpSession;
import modal.MyStaff;
import modal.MyStaffFacade;

/**
 *
 * @author sharuk
 */
@WebServlet(name = "StaffDelete", urlPatterns = {"/StaffDelete"})
public class StaffDelete extends HttpServlet {

    @EJB
    private MyStaffFacade myStaffFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String staffId = request.getParameter("staffId");   

        MyStaff removedStaff =  myStaffFacade.find(Long.parseLong(staffId));
        
        
            try {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    // Get the logged-in staff from the session
                    MyStaff loggedInStaff = (MyStaff) session.getAttribute("staff");

                    if (staffId != null && !staffId.isEmpty() && removedStaff != null) {
                        if (!removedStaff.equals(loggedInStaff)) { // Check if the staff being deleted is not the logged-in staff
                            myStaffFacade.remove(removedStaff);
                            session.setAttribute("staff", loggedInStaff);
                            
                            
                            
                            request.getRequestDispatcher("StaffDashboard.jsp").include(request,response);
                        } else {
                            // Redirect to a page indicating that staff cannot delete themselves
                            response.setContentType("text/html");
                            PrintWriter out = response.getWriter();
                            out.println("<script>");
                            out.println("alert('You cannot delete yourself');");
                            out.println("window.location.href='" + request.getContextPath() + "/StaffDashboard.jsp'");
                            out.println("</script>");

                            
//                            response.sendRedirect("cantDeleteYourself.jsp");
                        }
                    } else {
                        response.sendRedirect("notfound.jsp");
                    }
                } else {
                    response.sendRedirect("loginStaff.jsp"); // Redirect to login if session is not found
                }
            } catch(Exception e){
                e.printStackTrace();
                response.sendRedirect("notfound.jsp");
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
