<%-- 
    Document   : AssignVets
    Created on : Apr 26, 2024, 2:54:08 AM
    Author     : sharuk
--%>

<%@page import="modal.MyPets"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       

        <h1>All Pet Profiles</h1>
        
        <br><br><br>

        <table border="1" width="100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Owner</th>
                    <th>Pet </th>
                    
                    <th>Breed</th>
                    <th>Sex</th>
                    <th>
                        Action
                    </th>
                    
                </tr>
            </thead>
            <tbody>
                <% 
                // Retrieve staffList from the request attribute
                List<MyPets> profiles = (List<MyPets>) request.getAttribute("petProfiles");
             
                // Check if staffList is not null and not empty
                if (!profiles.isEmpty()) {
                    for (MyPets profile : profiles) {
                %>
                        <tr>
                            <td><%= profile.getId() %></td>
                            <td><%= profile.getOwnername() %></td>
                            <td><%= profile.getPetname() %></td>
                            <td><%= profile.getBreed() %></td>
                            <td><%= profile.getSex() %></td>
                            <td>
                            <form action="VetsAvailability" method="POST">
                                <input type="hidden" name="petId" value="<%= profile.getId() %>">
                                    <select name="appointmentDate">
                                        <option value="" disabled selected>Select Appointment Date</option>
                                        <% 
                                        List<String> dates = (List<String>) request.getAttribute("dates");
                                        if (dates != null) {
                                            for (String date : dates) { 
                                        %>
                                                <option value="<%= date %>"><%= date %></option>
                                        <% 
                                            }
                                        }
                                        %>
                                    </select>
                                <input type="submit" value="Select">
                            </form>
                            </td>
                            
                        </tr>
                <%
                    }
                } else {
                %>
                    <tr>
                        <td colspan="6">No pets found.</td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
            
        <br><br><br>

        
             
    </body>
</html>
