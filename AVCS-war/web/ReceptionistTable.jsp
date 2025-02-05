<%-- 
    Document   : ReceptionistTable
    Created on : Apr 25, 2024, 1:37:27 AM
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

        <h1>Receptionist Details </h1>
                <br><br><br>
                
        <form action="ReceptionistSearch" method="POST">
            Username:
            <input type="text" name="receptionistname" size="20" required>
            
                <input type="submit" value="Search">
            
        </form>         
                
                <br><br>

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Receptionist Id</th>
                        <th>Username</th>
                        <th>Age</th>
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
                                    List<MyReceptionist> reportList = (List<MyReceptionist>) request.getAttribute("receptionistList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyReceptionist rota : reportList) {
                                            
                                            
                                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            <td><%= rota.getUsername() %></td>
                            <td><%= rota.getAge() %></td>
                            <td><%= rota.getGender() %></td>
                            <td><%= rota.getEmail() %></td>
                            <td><%= rota.getContactnumber()  %></td>
                            <td><%= rota.getPassword()  %></td>
                            
                            <td>
                                <form action="DeleteReceptionist" method="post">
                                    <input type="hidden" name="receptionistId" value="<%= rota.getId() %>"/>
                                    
                                    
                                    <button type="submit">Delete</button>
                                </form>
                                    
                                 <form action="UpdateReceptonist1" method="post">
                                    <input type="hidden" name="receptionistId" value="<%= rota.getId() %>"/>
                                    
                                    
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
