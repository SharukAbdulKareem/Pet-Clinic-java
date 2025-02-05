<%-- 
    Document   : BookAppointment
    Created on : Apr 26, 2024, 3:14:20 AM
    Author     : sharuk
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        /* Center the form vertically and horizontally */
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        /* Style the form */
        form {
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        /* Style the form elements */
        select, input[type="time"], input[type="submit"] {
            margin: 10px 0;
            padding: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        
        /* Style the submit button */
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        
        /* Style the select dropdown */
        select {
            width: 100%;
        }
        
        /* Style the label */
        label {
            margin-bottom: 5px;
            display: block;
        }
    </style>
</head>
<body>
    <form action="BookAppointment" method="POST">
        <input type="hidden" name="petId" value="<%= request.getAttribute("petId") %>">
        <input type="hidden" name="appointmentDate" value="<%= request.getAttribute("date") %>">
        <label for="vetAssigned">Select Vet:</label>
        <select name="vetAssigned" id="vetAssigned">
            <option value="" disabled selected>Select Vet</option>
            <% 
            // Retrieve available vets from the request attribute
            List<String> vets = (List<String>) request.getAttribute("vets");
            if (vets != null) {
                for (String vet : vets) { 
            %>
                    <option value="<%= vet %>"><%= vet %></option>
            <% 
                }
            }
            %>
        </select>
        <label for="appointmentTime">Preferred Appointment Time:</label>
        <input type="time" id="appointmentTime" name="appointmentTime">
        <input type="submit" value="Make Appointment">
    </form>
</body>
</html>
