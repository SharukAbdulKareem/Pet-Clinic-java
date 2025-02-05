<%-- 
    Document   : SUpdateStaffDetails
    Created on : Apr 25, 2024, 1:28:33 PM
    Author     : sharuk
--%>

<%@page import="modal.MyStaff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Update Your Details</h1>
                <br><br><br>
                
                   <% 
                                    // Retrieve staffList from the request attribute
                                    MyStaff reportList = (MyStaff) request.getAttribute("staffList");

                                    // Check if staffList is not null and not empty
                                    
                                        if (reportList != null) {
                                            
                                            
                                    %>
                    
 
                    
            <form action="StaffUpdate" method="POST" >
                <input type="hidden" name="staffId" value="<%= reportList.getId() %>">
                <input type="hidden" name="nusername" value="<%= reportList.getUsername() %>">
               
               
                    <table>

                        

                        <tr>
                            <td>New Age: </td>
                            <td> <input type="text" name = "nage" size = "20"  value="<%= reportList.getAge()%>" ></td>
                        </tr>
                        
                        <tr>
                            <td>New Contact Number: </td>
                            <td> <input type="text" name = "ncontactnumber" size = "20" value="<%= reportList.getContactnumber()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Email: </td>
                            <td> <input type="text" name = "nemail" size = "20" value="<%= reportList.getEmail()%>" ></td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td> <input type="text" name = "password" size = "20" value="<%= reportList.getPassword() %>"></td>
                        </tr>

                        <tr>
                            <td>Confirm Password: </td>
                            <td> <input type="text" name = "confNPassword" size = "20" value="<%= reportList.getPassword() %>"></td>
                        </tr>

                    </table>
                <p><input type="submit" value="Update"></p> 
        </form>
                
                <%
                    }
                    
                    %>
    
        
                    
        <br><br><br>
    <!-- New section for deleting staff -->

    </body>
</html>
