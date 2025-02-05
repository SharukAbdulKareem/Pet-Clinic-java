/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URLDecoder;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
@WebServlet(name = "UpdateWeeklyRota", urlPatterns = {"/UpdateWeeklyRota"})
public class UpdateWeeklyRota extends HttpServlet {

    @EJB
    private MyWeeklyRotaFacade myweeklyRotaFacade;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                String formDataEncoded = request.getParameter("formData");

                // Decode the URL encoded JSON string
                String jsonData = URLDecoder.decode(formDataEncoded, "UTF-8");

                JsonReader reader = Json.createReader(new StringReader(jsonData));
                JsonArray jsonArray = reader.readArray();

                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject json = jsonArray.getJsonObject(i);
                    String date = json.getString("date");
                    String vet1 = json.getString("vet1");
                    String vet2 = json.getString("vet2");
                    String vet3 = json.getString("vet3");

                    myweeklyRotaFacade.edit(new MyWeeklyRota(date, vet1, vet2, vet3));
                }

                out.println("<script>");
                out.println("alert('The chosen week rota has been updated successfully!');");
                out.println("window.location.href='" + request.getContextPath() + "/StaffDashboard.jsp'");
                
                out.println("</script>");
                
            } catch (Exception e) {
                out.println("<script>");
                out.println("alert('Error: An error occured white updating the week rota!');");
                out.println("window.location.href='" + request.getContextPath() + "/StaffDashboard.jsp'");
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
