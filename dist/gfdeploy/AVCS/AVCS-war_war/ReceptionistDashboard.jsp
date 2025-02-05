<%-- 
    Document   : ReceptionistDashboard
    Created on : Apr 24, 2024, 12:22:37 PM
    Author     : sharuk
--%>

<%@page import="modal.MyReceptionist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        /* Styles for the container */
        .container {
            width: 500px; /* Adjust width as needed */
            margin: 50px auto; /* Center the container vertically and horizontally */
        }

        /* Styles for buttons */
        .btn-primary {
            background-color: #C3DFD6; /* Updated background color */
            border: none;
            color: black;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: block;
            font-size: 16px;
            margin-top: 10px;
            cursor: pointer;
            border-radius: 4px;
            margin-right: 10px; /* Add some space between buttons */
        }
        
        .btn-primary:hover {
            background-color: #A1CEBD; /* Darker background color on hover */
        }
        
        .logout-button {
            background-color: transparent; /* Transparent background */
            border: none; /* Remove border */
            color: #fff; /* White text color */
            font-size: 16px; /* Font size */
            cursor: pointer; /* Cursor style */
        }

        /* Styles for the logout icon */
        .logout-icon {
            fill: #fff; /* White fill color for the icon */
            width: 24px; /* Icon width */
            height: 24px; /* Icon height */
            cursor: pointer; /* Cursor style */
        }
        .header {
            background-color: #333; /* Dark background color for the header */
            color: #fff; /* White text color for the header */
            padding: 10px 20px; /* Padding for the header */
            display: flex; /* Use flexbox for layout */
            justify-content: space-between; /* Align items with space between them */
            align-items: center; /* Align items vertically */
            text-align: center;
        }
        
    </style>
</head>
<body>
    
    <div>
        <%-- Retrieve the receptionist attribute from session --%>
        <% MyReceptionist receptionist = (MyReceptionist) session.getAttribute("receptionist"); %>
        
        <%-- Check if the receptionist attribute exists --%>
        <% if (receptionist != null) { %>
            <%-- Display receptionist details --%>
            
        <% } else { %>
            <p>No receptionist logged in.</p>
        <% } %>
    </div>
    
    
    
    <div class="header">
        <h1>Welcome <%= receptionist.getUsername() %></h1>
        
        
    </div>
    
    <div class="container mt-2">
        <div class="text-center">
            <div class="container p-5 d-flex justify-content-center">
                <a href="PetAdmission.jsp" class="btn btn-primary">Pet Registration</a>
                <a href="PetsList" class="btn btn-primary">Pets List</a>
                <a href="ROwnDetailsUpdate.jsp" class="btn btn-primary">Update Personal Details</a>
                <a href="WeeklyRotaDetails" class="btn btn-primary">Check Weekly Rota Details</a>
                <a href="BookPets" class="btn btn-primary">Book Appointment</a>
                <a href="ViewAppointment" class="btn btn-primary">View Appointment</a>
                <a href="ReceptionistLogout" class="btn btn-primary">Logout</a>
            </div>
        </div>
    </div>
</body>
</html>
