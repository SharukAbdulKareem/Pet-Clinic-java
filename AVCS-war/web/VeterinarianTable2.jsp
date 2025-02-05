<%-- 
    Document   : VeterinarianTable2
    Created on : Apr 26, 2024, 11:19:57 PM
    Author     : sharuk
--%>

<%@page import="modal.MyVeterinary"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>

        <h1>Book Appointment Details</h1>
                <br><br><br>

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Vet Id</th>
                        <th> Username </th>
                        <th>Gender</th>     
                        <th>Email</th>
                        <th>Contact Number</th>
                        <th>Expertise1</th> 
                        <th>Expertise2</th> 
                        <th>Medical ID</th>
                        <th>Password</th>
                        
                        <th> Action </th>
                        
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyVeterinary> reportList = (List<MyVeterinary>) request.getAttribute("vetsList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyVeterinary rota : reportList) {
                                            
                                            
                                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            <td><%= rota.getUsername() %></td>
                            <td><%= rota.getGender() %></td>
                            <td><%= rota.getEmail() %></td>
                            <td><%= rota.getContactnumber()  %></td>
                            <td><%= rota.getExpertise1() %></td>
                            <td><%= rota.getExpertise2() %></td>
                            <td><%= rota.getMedicalid() %></td>
                            <td><%= rota.getPassword()  %></td>
                            
                            <td>
                                <form action="DeleteVets" method="post">
                                    <input type="hidden" name="vetsId" value="<%= rota.getId() %>"/>
                                    
                                    
                                    <button type="submit">Delete</button>
                                </form>
                                    
                                 <form action="UpdateVet1" method="post">
                                    <input type="hidden" name="vetsId" value="<%= rota.getId() %>"/>
                                    
                                    
                                    <button type="submit">Edit</button>
                                </form>
                            </td>

                        </tr>
                        
                    <%
                                    }
                                        }
else{
                    %>
      
                    <tr>
                            <td colspan="4">No Vets have been founded.</td>
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
