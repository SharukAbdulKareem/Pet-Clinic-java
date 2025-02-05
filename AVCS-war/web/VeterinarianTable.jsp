<%-- 
    Document   : VeterinarianTable
    Created on : Apr 25, 2024, 3:28:50 AM
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

        <h1>Vet Details </h1>
                <br><br><br>
                
        <form action="VeterinarianSearch" method="POST">
            Username:
            <input type="text" name="username" size="20" required>
            
                <input type="submit" value="Search">
            
        </form> 
                <br><br>

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Vet Id</th>
                        <th>Username</th>
                        <th>Gender</th>     
                        <th>Email</th>
                        <th>Contact Number</th>
                        
                        <th>Expertise Area 1</th>
                        <th>Expertise Area 2</th>
                        <th>Password</th>
                        
                        <th> Action </th>
                        
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyVeterinary> reportList = (List<MyVeterinary>) request.getAttribute("VeterinaryList");

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
                            
                            <td><%= rota.getExpertise1()  %></td>
                            <td><%= rota.getExpertise2()  %></td>
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
                    
                    <br><br>
                    
        
                    
                    
                    
        <br><br><br>
    <!-- New section for deleting staff -->

    </body>
</html>
