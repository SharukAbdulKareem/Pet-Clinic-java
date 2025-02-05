<%-- 
    Document   : GenerateReport
    Created on : Apr 26, 2024, 4:43:17 PM
    Author     : sharuk
--%>

<%@page import="modal.MyPetReport"%>
<%@page import="java.util.List"%>
<%@page import="modal.MyAppointments"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    </tr>
                </thead>
                    <tbody>
                     <% 
                                    // Retrieve staffList from the request attribute
                                   MyAppointments foundAppointment = (MyAppointments) (request.getAttribute("foundAppointment"));
                                    
                                   List<MyPetReport> foundReport = (List<MyPetReport>) request.getAttribute("foundReportt");
     
                                    if (foundReport != null && !foundReport.isEmpty()) {
                                         for (MyPetReport report : foundReport) {

            
                                    %>
                        <tr>
                            
                            
                            <td><%=   report.getId()   %></td>
                            <td><%=   report.getAppointments().getPetname()   %></td>
                            <td><%=   report.getAppointments().getId()     %></td>
                            <td><%=   report.getDiagnosis()     %></td>
                            <td><%=   report.getPrognosis()   %></td>    
                            <td><%=   report.getAppointments().getAppointmentDate()     %></td>
                            <td><%=   report.getAppointments().getAppointmentTime()     %></td>
                            
                            
                        <% 
                                }
                            } else {
                        %>
                                <tr>
                                    <td colspan="7">No Reports found.</td>
                                </tr>
                        <% 
                            }
                        %>
                    </tbody>
        </table>
    

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Report Page</title>
    </head>
        <body>
  
        <br><br>
        
        <h2>Details:</h2>
            
            <p>Pet Name: <%= foundAppointment.getPetname() %></p>
            <p>Pet Breed: <%= foundAppointment.getBreed() %></p>
            <p>Pet Name: <%= foundAppointment.getSex() %></p>
            <p>Appointment Date: <%=  foundAppointment.getAppointmentDate() %></p>
            <p>Time: <%= foundAppointment.getAppointmentTime() %></p>
            <p>Vet: <%= foundAppointment.getVetAssigned() %></p>
            

        
        <br><br>
        <h2>Generate Report: </h2>
        <form action="GenerateReport2" method="POST">
            <input type="hidden" name="petId" value="<%= foundAppointment.getId() %>">
            <table>
                
                <tr>
                    <td>Diagnosis: </td>
                    <td> <textarea name = "diagnosis" rows="5" cols="50"></textarea></td>
                </tr>
                <tr>
                    <td>Prognosis: </td>
                    <td> <input type="text" name = "prognosis" size = "20"></td>
                </tr>

                
            </table>
            <p><input type="submit" value="Report"></p> 
        </form>
    </body>
</html>
