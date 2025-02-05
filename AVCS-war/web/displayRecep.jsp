<%-- 
    Document   : displayRecep
    Created on : Apr 24, 2024, 11:37:30 AM
    Author     : sharuk
--%>

<%@page import="java.util.List"%>
<%@page import="modal.MyReceptionist"%>
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

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Recep Id</th>
                        <th> Username </th>
                        <th>Gender</th>     
                        <th>Email</th>
                        <th>Contact Number</th>
                        <th>Password</th>                       
                        <th> Action </th>
                        
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyReceptionist> reportList = (List<MyReceptionist>) request.getAttribute("reportList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyReceptionist rota : reportList) {
                                            
                                            
                                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            <td><%= rota.getUsername() %></td>
                            <td><%= rota.getGender() %></td>
                            <td><%= rota.getEmail() %></td>
                            <td><%= rota.getContactnumber()  %></td>
                            <td><%= rota.getPassword()  %></td>
                            
                            <td>
                                <form action="DeleteVet" method="post">
                                    <input type="hidden" name="vetId" value="<%= rota.getId() %>"/>
                                    
                                    
                                    <button type="submit">Delete</button>
                                </form>
                                    
                                 <form action="EditVet" method="post">
                                    <input type="hidden" name="vetId" value="<%= rota.getId() %>"/>
                                    
                                    
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
                            <td colspan="8">No Receptionist have been founded.</td>
                    </tr>
                    <%
                                    }
                                    %>
                    </tbody>
        </table>
                    
                    <br><br>
                    
        <form action="VetSearch2" method="POST">
            Username:
            <input type="text" name="username" size="20" required>
            <p>
                <input type="submit" value="Search">
            </p>
        </form> 
                    
                    
                    
        <br><br><br>
    <!-- New section for deleting staff -->

    </body>
</html>
