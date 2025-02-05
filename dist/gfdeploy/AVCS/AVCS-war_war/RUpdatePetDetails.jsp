<%-- 
    Document   : RUpdateOwnDetails
    Created on : Apr 24, 2024, 10:56:33 PM
    Author     : sharuk
--%>

<%@page import="modal.MyPets"%>
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
                                    MyPets reportList = (MyPets) request.getAttribute("reportList");

                                    // Check if staffList is not null and not empty
                                    
                                        if (reportList != null) {
                                            
                                            
                                    %>
                    
 
                    
            <form action="PetsUpdate" method="POST" >
                <input type="hidden" name="petId" value="<%= reportList.getId() %>">
               
               
                    <table>
                        
                        
                        <tr>
                            <td>Owner: </td>
                            <td> <input type="text" name = "nusername" size = "20" value="<%= reportList.getOwnername() %>" ></td>
                        </tr>
                        
                        <tr>
                            <td>New IC Number: </td>
                            <td> <input type="text" name = "nicnumber" size = "20" value="<%= reportList.getIcnumber() %>" ></td>
                        </tr>
                        <tr>
                            <td>New Email: </td>
                            <td> <input type="text" name = "nemail" size = "20" value="<%= reportList.getEmail()%>" ></td>
                        </tr>
                        <tr>
                            <td>New Contact Number: </td>
                            <td> <input type="text" name = "ncontactnumber" size = "20" value="<%= reportList.getContact()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Address: </td>
                            <td> <input type="text" name = "naddress" size = "20" value="<%= reportList.getAddress()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Pet Name: </td>
                            <td> <input type="text" name = "npetname" size = "20" value="<%= reportList.getPetname()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Breed: </td>
                            <td> <input type="text" name = "nbreed" size = "20" value="<%= reportList.getBreed()   %>" ></td>
                        </tr>
                        <tr>
                            <td>New Sex of Animal: </td>
                            <td> <input type="text" name = "nsex" size = "20" value="<%= reportList.getSex()   %>" ></td>
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
