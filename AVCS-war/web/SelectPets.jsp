<%-- 
    Document   : SelectPets
    Created on : Apr 24, 2024, 9:12:52 PM
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

            <h1> Pets and Owners</h1>
                    <br><br><br>

            <table border="1" width="100%">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Owner Name</th>
                            <th>Address</th>     
                            <th>Contact</th>
                            <th>Email</th>
                            <th>Pet Name</th>     
                            <th>Breed</th>
                            <th>Sex</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                        <tbody>
                        <% 
                                        // Retrieve staffList from the request attribute
                                        List<MyPets> petsList = (List<MyPets>) request.getAttribute("petsList");

                                        // Check if staffList is not null and not empty
                                        if (!petsList.isEmpty()) {
                                            for (MyPets rota : petsList) {

                                        %>
                            <tr>

                                <td><%= rota.getId() %></td>
                                <td><%= rota.getOwnername() %></td>
                                <td><%= rota.getAddress() %></td>
                                <td><%= rota.getContact() %></td>
                                <td><%= rota.getEmail() %></td>
                                <td><%= rota.getPetname() %></td>
                                <td><%= rota.getBreed() %></td>
                                <td><%= rota.getSex() %></td>
                                
                                
                                <td>
                                    <form action="PetsUpdate1" method="POST">
                                        <input type="hidden" name="petId" value="<%= rota.getId() %>"/>
                                        <button type="submit">Update</button>
                                    </form>
                                    
                                    <form action="PetsDelete" method="POST">
                                        <input type="hidden" name="petId" value="<%= rota.getId() %>"/>

                                        <button type="submit">Delete</button>
                                    </form>
                                </td>


                            </tr>
                        <%
                                        }

                                        } else {
                                        %>
                        <tr>
                                <td colspan="9">No Slots have been founded.</td>
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
