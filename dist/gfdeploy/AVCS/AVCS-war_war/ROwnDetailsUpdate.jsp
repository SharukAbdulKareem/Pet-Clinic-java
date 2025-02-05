<%-- 
    Document   : ROwnDetailsUpdate
    Created on : Apr 24, 2024, 9:51:32 PM
    Author     : sharuk
--%>

<%@page import="modal.MyReceptionist"%>
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
                    
                    MyReceptionist allVets = (MyReceptionist) session.getAttribute("receptionist");
                                      
                    %>
                    
 
                    
            <form action="ReceptionistUpdateOwn" method="POST" >
                <input type="hidden" name="recepId" value="<%= allVets.getId() %>">
                <input type="hidden" name="recepName" value="<%= allVets.getUsername() %>">
               
               
                    <table>

                        <tr>
                            <td>New Age: </td>
                            <td> <input type="text" name = "nage" size = "20" value="<%= allVets.getAge()%>" ></td>
                        </tr>
                        <tr>
                            <td>New Contact Number: </td>
                            <td> <input type="text" name = "ncontactnumber" size = "20" value="<%= allVets.getContactnumber()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Email: </td>
                            <td> <input type="text" name = "nemail" size = "20" value="<%= allVets.getEmail()%>" ></td>
                        </tr>
                        <tr>
                            <td>New Gender: </td>
                            <td>  
                                <select class="form-select col-sm-10" id="ngender" name="ngender" required>
                                    <option value="" selected disabled ><%= allVets.getGender()%></option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                    
                                </select>                  
                            </td>               
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td> <input type="text" name = "password" size = "20" value="<%= allVets.getPassword() %>"></td>
                        </tr>
                        <tr>
                            <td>Confirm Password: </td>
                            <td> <input type="text" name = "confNPassword" size = "20" value="<%= allVets.getPassword() %>"></td>
                        </tr>

                    </table>
                <p><input type="submit" value="Update"></p> 
        </form>
                

        
                    
        <br><br><br>
    <!-- New section for deleting staff -->

    </body>
</html>
