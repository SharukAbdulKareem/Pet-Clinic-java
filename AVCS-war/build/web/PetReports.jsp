<%-- 
    Document   : PetReports
    Created on : Apr 27, 2024, 12:04:45 AM
    Author     : sharuk
--%>

<%@page import="modal.MyPetReport"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>

        <h1>Reports</h1>
                <br><br><br>

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Report ID </th>
                        <th>Pet Name</th>
                        <th>Appointment ID</th>
                        <th>Diagnosis</th>        
                        <th>Prognosis</th>
                        
                        <th>Appointment Date</th>
                        <th>Appointment Time</th>
                        
                        <th>Vet On Duty</th>
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyPetReport> reportList = (List<MyPetReport>) request.getAttribute("reportList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyPetReport rota : reportList) {
                                            
                                            
                                            
                                    %>
                        <tr>
                            
                            <td><%=   rota.getId()   %></td>
                            <td><%=   rota.getAppointments().getPetname()   %></td>
                            <td><%=   rota.getAppointments().getId()     %></td>
                            <td><%=   rota.getDiagnosis()     %></td>
                            <td><%=   rota.getPrognosis()   %></td>    
                            <td><%=   rota.getAppointments().getAppointmentDate()     %></td>
                            <td><%=   rota.getAppointments().getAppointmentTime()     %></td>
                            <td><%=   rota.getAppointments().getVetAssigned()   %></td> 

                        </td>
                            
                         
                        </tr>
                    <%
                                    }
                                        
                                    } else {
                                    %>
                    <tr>
                            <td colspan="8">No Reports have been founded.</td>
                    </tr>
                    <%
                                    }
                                    %>
                    </tbody>
        </table>
                    
                    <br><br>
                    
        
                    
        
    <!-- New section for deleting staff -->

    </body>
</html>

