<%-- 
    Document   : UpdateVetDetails
    Created on : Apr 28, 2024, 2:09:58 AM
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
                    
                    MyVeterinary allVets = (MyVeterinary) session.getAttribute("veterinary");
                                      
                    %>
                    
 
                    
            <form action="VeterinaryUpdateOwn" method="POST" >
                <input type="hidden" name="vetId" value="<%= allVets.getId() %>">
                <input type="hidden" name="vetName" value="<%= allVets.getUsername() %>">
               
               
                    <table>

                        
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
                            <td>MedicalID </td>
                            <td> <input type="text" name = "nmedicalID" size = "20" value="<%= allVets.getMedicalid()  %>" ></td>
                        </tr>
                        <tr>
                            <td>Expertise 1</td>
                            <td>
                                <select class="form-select col-sm-10" id="nexpertise1" name="nexpertise1" required>
                                    <option value="" selected disabled ><%= allVets.getExpertise1()%></option>
                                    <option value="Farm Animals">Farm Animals</option>
                                    <option value="Reptiles">Reptiles</option>
                                    <option value="Birds">Birds</option>
                                    <option value="Normal Pets">Normal Pets</option>
                                    <option value="Fishes">Fishes</option> 
                             </select>   
                                
                                
                                
                            </td>
                            
                        
                        
                        </tr>
                        
                        <tr>
                            <td>Expertise 2</td>
                            <td>
                                <select class="form-select col-sm-10" id="nexpertise2" name="nexpertise2" required>
                                    <option value="" selected disabled ><%= allVets.getExpertise2()%></option>
                                    <option value="Farm Animals">Farm Animals</option>
                                    <option value="Reptiles">Reptiles</option>
                                    <option value="Birds">Birds</option>
                                    <option value="Normal Pets">Normal Pets</option> 
                                    <option value="Fishes">Fishes</option> 
                                    
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