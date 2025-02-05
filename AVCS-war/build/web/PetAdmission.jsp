<%-- 
    Document   : PetAdmission
    Created on : Apr 24, 2024, 3:54:22 PM
    Author     : sharuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pets Admission</title>
    </head>
    <body>
        <form action="PetRegister" method="POST">
            <table>
                <tr>
                    <td>Owner Name: </td>
                    <td> <input type="text" name = "username" size = "20" required></td>
                </tr>
                <tr>
                    <td>IC: </td>
                    <td> <input type="text" name = "icnumber" size = "20" required></td>
                </tr>
                <tr>
                    <td>Contact Number: </td>
                    <td> <input type="text" name = "contact" size = "20" required></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td> <input type="text" name = "email" size = "20" required></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td> <input type="text" name = "address" size = "20" required></td>
                </tr>
                
           
                <tr>
                    <td>Pet Name: </td>
                    <td> <input type="text" name = "petName" size = "20" required></td>
                </tr>
                <tr>
                    <td>Breed: </td>
                    <td> <input type="text" name = "breed" size = "20" required></td>
                </tr>
                <tr>   
                    <td>Animal Sex: </td>
                        <td>
                            <select class="form-select col-sm-10" id="sex" name="sex" required>
                                    <option value="" selected disabled>Sex</option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>

                            </select>

                        </td>
                    
                </tr>
                
                
            </table>
            <p><input type="submit" value="Register"></p> 
        </form>
    </body>
    </body>
</html>
