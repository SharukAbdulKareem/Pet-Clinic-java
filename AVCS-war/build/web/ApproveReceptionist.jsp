<%-- 
    Document   : ApproveReceptionist
    Created on : Apr 26, 2024, 9:15:55 PM
    Author     : sharuk
--%>

<%@page import="modal.MyReceptionist"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>

        <h1>Approve Pending Vets</h1>
                <br><br><br>

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Vet Id</th>
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
                                    List<MyReceptionist> reportList = (List<MyReceptionist>) request.getAttribute("receptionistList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyReceptionist rota : reportList) {
                                            
                                            if (!rota.isIs_approved()) {  
                                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            <td><%= rota.getUsername() %></td>
                            <td><%= rota.getGender() %></td>
                            <td><%= rota.getEmail() %></td>
                            <td><%= rota.getContactnumber()  %></td>
                            <td><%= rota.getPassword()  %></td>
                            <td>
                                <form action="ApproveReceptionist" method="post">
                                    <input type="hidden" name="recepId" value="<%= rota.getId() %>"/>
                                    
                                    
                                    <button type="submit">Approve</button>
                                </form>
                            </td>

                        </tr>
                        
                    <%
                                    }
                                        
                                    else {
                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            <td><%= rota.getUsername() %></td>
                            <td><%= rota.getGender() %></td>
                            <td><%= rota.getEmail() %></td>
                            <td><%= rota.getContactnumber()  %></td>
                            <td><%= rota.getPassword()  %></td>
                            <td>
                                <span> Approved </span>
                            </td>
                            

                        </tr>
                    
                    
                    
                    <%
                        }
                                    }
                                        
                                    } else {
                                    %>
                    <tr>
                            <td colspan="4">No Receptionist have been founded.</td>
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
