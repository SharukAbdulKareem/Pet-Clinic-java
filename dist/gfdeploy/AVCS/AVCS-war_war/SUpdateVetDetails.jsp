<%-- 
    Document   : SUpdateVetDetails
    Created on : Apr 25, 2024, 3:58:02 AM
    Author     : sharuk
--%>

<%@page import="modal.MyVeterinary"%>
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
                                    MyVeterinary reportList = (MyVeterinary) request.getAttribute("vetList");

                                    // Check if staffList is not null and not empty
                                    
                                        if (reportList != null) {
                                            
                                            
                                    %>
                    
 
                    
            <form action="VeterinaryUpdate" method="POST" >
                <input type="hidden" name="recepId" value="<%= reportList.getId() %>">
                <input type="hidden" name="recepName" value="<%= reportList.getUsername() %>">
               
                    <table>

                        
                        <tr>
                            <td>New Contact Number: </td>
                            <td> <input type="text" name = "ncontactnumber" size = "20" value="<%= reportList.getContactnumber()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Email: </td>
                            <td> <input type="text" name = "nemail" size = "20" value="<%= reportList.getEmail()%>" ></td>
                        </tr>
                        
                        <tr>
                            <td>New Gender: </td>
                            <td>  
                                <select class="form-select col-sm-10" id="ngender" name="ngender" required>
                                    <option value="" selected disabled ><%= reportList.getGender()%></option>
                                    <option value="male">male</option>
                                    <option value="female">female</option>
                                    
                                </select>                  
                            </td>               
                        </tr>
                        <tr>
                            <td>New Medical ID: </td>
                            <td> <input type="text" name = "nmedicalID" size = "20" value="<%= reportList.getMedicalid()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Expertise Area1: </td>
                            <td>  
                                <select class="form-select col-sm-10" id="ngender" name="nexp1" required>
                                    <option value="" selected disabled ><%= reportList.getExpertise1()   %></option>
                                    <option value="Farm Animals">Farm Animals</option>
                                    <option value="Reptiles">Reptiles</option>
                                    <option value="Birds">Birds</option>
                                    <option value="Normal Pets">Normal Pets</option> 
                                    <option value="Fishes">Fishes</option> 
                                    
                                </select>                  
                            </td>               
                        </tr>
                        <tr>
                            <td>New Expertise Area2: </td>
                            <td>  
                                <select class="form-select col-sm-10" id="ngender" name="nexp2" required>
                                    <option value="" selected disabled ><%= reportList.getExpertise2()%></option>
                                    <option value="Farm Animals">Farm Animals</option>
                                    <option value="Reptiles">Reptiles</option>
                                    <option value="Birds">Birds</option>
                                    <option value="Normal Pets"> Normal Pets</option> 
                                    <option value="Fishes">Fishes</option> 
                                    
                                </select>                  
                            </td>               
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
