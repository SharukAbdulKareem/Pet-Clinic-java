<%-- 
    Document   : ViewAppointments
    Created on : Apr 26, 2024, 1:50:23 PM
    Author     : sharuk
--%>

<%@page import="modal.MyAppointments"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
                

        <br>
        <h1>Appointment Details</h1>
 
                <br><br><br>

        <table border="1" width='100%'>
                <thead>
                    <tr>
                        <th>Appointment ID </th>
                        <th>Owner </th>
                        <th>Pet Name</th>        
                        <th>Appointment Date</th>
                        <th>Appointment Time </th>
                        <th>Vets Assigned</th>
                        <th>Action    </th>
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyAppointments> appointmentList = (List<MyAppointments>) request.getAttribute("appointmentList");

                                    // Check if staffList is not null and not empty
                                    if (!appointmentList.isEmpty()) {
                                        for (MyAppointments rota : appointmentList) {
                                            
                                    %>
                        <tr>
                            
                            <td><%= rota.getId()%></td>
                            <td><%= rota.getOwner()  %></td>
                            <td><%= rota.getPetname()  %></td>
                            <td><%= rota.getAppointmentDate()   %></td>
                            <td><%= rota.getAppointmentTime()  %></td>
                            <td><%= rota.getVetAssigned()  %></td>
                            <td>
                                <form action="DeleteAppointment" method="post">
                                        <input type="hidden" name="appointmentId" value="<%=rota.getId()%>"/>
                                        
                                        <button type="submit">Delete</button>
                                </form>
                            </td>
                            
                            
                        </tr>

                    <%
                                }
                            
                        } else {
                    %>
                    
                    <tr>
                            <td colspan="4">No appointments have been founded.</td>
                    </tr>
                    <%
                                    }
                                    %>
                    </tbody>
        </table>
        <br><br><br>
    <!-- New section for deleting staff -->

    </body>
</html>

