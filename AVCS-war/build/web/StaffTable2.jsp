<%-- 
    Document   : StaffTable2
    Created on : Apr 26, 2024, 11:41:29 PM
    Author     : sharuk
--%>

<%@page import="modal.MyStaff"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Staff Details</h1>
                <br>
                
        <form action="StaffSearch" method="POST">
            Username:
            <input type="text" name="username" size="20" required>
            
                <input type="submit" value="Search">
            
        </form> 
        <br><br>      
        <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Staff ID</th>
                        <th>Username </th>
                        <th>Age</th> 
                        
                        <th>Email</th>
                        <th>Contact Number</th>
                        
                        
                        <th>Password</th>
                        
                        <th> Action </th>
                        
                    </tr>
                </thead>
                    <tbody>
                    <% 
                                    // Retrieve staffList from the request attribute
                                    List<MyStaff> reportList = (List<MyStaff>) request.getAttribute("staffList");

                                    // Check if staffList is not null and not empty
                                    if (!reportList.isEmpty()) {
                                        for (MyStaff rota : reportList) {
                                            
                                            
                                    %>
                        <tr>
                            
                            <td><%= rota.getId() %></td>
                            <td><%= rota.getUsername() %></td>
                            <td><%= rota.getAge() %></td>
                            <td><%= rota.getEmail() %></td>
                            <td><%= rota.getContactnumber()  %></td>
                            
                            
                            <td><%= rota.getPassword()  %></td>
                            
                            <td>
                                <form action="StaffDelete" method="post">
                                    <input type="hidden" name="staffId" value="<%= rota.getId() %>"/>
                                    
                                    
                                    <button type="submit">Delete</button>
                                </form>
                                    
                                 <form action="StaffUpdate1" method="post">
                                    <input type="hidden" name="staffId" value="<%= rota.getId() %>"/>
                                    
                                    
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
