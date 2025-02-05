<%-- 
    Document   : receptionistApprove
    Created on : Apr 24, 2024, 11:22:37 AM
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
                            <th> Approve </th>
                            <th> Action </th>

                        </tr>
                    </thead>
                        <tbody>
                        <% 
                                        // Retrieve staffList from the request attribute
                                        List<MyReceptionist> receptionistList = (List<MyReceptionist>) request.getAttribute("receptionistList");

                                        // Check if staffList is not null and not empty
                                        if (!receptionistList.isEmpty()) {
                                            for (MyReceptionist rota : receptionistList) {

                                                if (!rota.isIs_approved()) {  
                                        %>
                            <tr>

                                <td><%= rota.getId() %></td>
                                <td><%= rota.getUsername() %></td>
                                <td><%= rota.getGender() %></td>
                                <td><%= rota.getEmail() %></td>
                                <td><%= rota.getContactnumber()  %></td>        
                                <td><%= rota.getPassword()  %></td>
                                <td><%= rota.isIs_approved()  %></td>
                                <td>
                                    <form action="ApproveVet" method="post">
                                        <input type="hidden" name="vetId" value="<%= rota.getId() %>"/>


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
                                <td><%= rota.isIs_approved()  %></td>
                                <td>
                                    <!-- Button is not displayed for 1(True) -->
                                </td>

                            </tr>



                        <%
                            }
                                        }

                                        } else {
                                        %>
                        <tr>
                                <td colspan="8">No Receptionist have been founded.</td>
                        </tr>
                        <%
                                        }
                                        %>
                        </tbody>
            </table>



            <br><br><br>
        </body>
</html>
