<%-- 
    Document   : WeeklyRotaTable
    Created on : Apr 26, 2024, 12:58:15 AM
    Author     : sharuk
--%>

<%@page import="modal.MyWeeklyRota"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Weekly Rota Details</h1>
                <br><br><br>

        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Vet 1</th>
                        <th>Vet 2</th>
                        <th>Vet 3</th>     
                        
                        
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyWeeklyRota> reportList = (List<MyWeeklyRota>) request.getAttribute("weeklyrotaList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyWeeklyRota rota : reportList) {
                                            
                                            
                                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            
                            <td><%= rota.getVet1() %></td>
                            <td><%= rota.getVet2() %></td>
                            <td><%= rota.getVet3() %></td>
                            
                            
                      

                        </tr>
                        
                    <%
                                    }
                                        }
else{
                    %>
      
                    <tr>
                            <td colspan="4">No weekly rota have been founded.</td>
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
