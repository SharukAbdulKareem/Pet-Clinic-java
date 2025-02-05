<%-- 
    Document   : VeterinaryDashboard
    Created on : Apr 24, 2024, 1:04:12 PM
    Author     : sharuk
--%>

<%@page import="modal.MyAppointments"%>
<%@page import="java.util.List"%>
<%@page import="modal.MyVeterinary"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        /* Styles for the container */
        .container {
            width: 80%; /* Adjust width as needed */
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
        
        /* Styles for the logout button */
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

        /* Styles for the header */
        .header {
            background-color: #333; /* Dark background color for the header */
            color: #fff; /* White text color for the header */
            padding: 10px 20px; /* Padding for the header */
            display: flex; /* Use flexbox for layout */
            justify-content: space-between; /* Align items with space between them */
            align-items: center; /* Align items vertically */
            text-align: center; /* Center text */
        }

        /* Styles for the table */
        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .table th, .table td {
            padding: 8px;
            border: 1px solid #ddd;
            text-align: left;
        }

        .table th {
            background-color: #f2f2f2;
        }

        .table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .table tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div>
    <%-- Retrieve the receptionist attribute from session --%>
    <% MyVeterinary veterinary = (MyVeterinary) session.getAttribute("veterinary"); %>
</div>
<div class="header">
    <h1>Welcome <%= veterinary.getUsername() %></h1>
</div>
<div class="container">
    <div class="text-center">
        <div class="container p-5 d-flex justify-content-center">
            <a href="UpdateVetDetails.jsp" type="button" class="btn btn-primary">Edit Personal Details</a>
            
            <a href="VeterinaryLogout" class="btn btn-primary">Logout</a>
        </div>
    </div>
    <div class="text-center" style="display: flex; align-items: center; justify-content: center; height: 50px;">
        <h3>Appointments</h3>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Owner</th>
            <th>Pet Name</th>
            <th>Breed</th>
            <th>Sex</th>
            <th>Appointment Date</th>
            <th>Appointment Time</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Retrieve reportList from the request attribute
            List<MyAppointments> reportList = (List<MyAppointments>) request.getAttribute("reportList");

            if (reportList != null) {
                for(MyAppointments rota : reportList){

        %>
        <tr>
            <td><%= rota.getId() %></td>
            <td><%= rota.getOwner() %></td>
            <td><%= rota.getPetname() %></td>
            <td><%= rota.getBreed() %></td>
            <td><%= rota.getSex()%></td>
            <td><%= rota.getAppointmentDate() %></td>
            <td><%= rota.getAppointmentTime() %></td>
            <td>
                <form action="GenerateReport" method="POST">
                    <input type="hidden" name="appointmentId" value="<%= rota.getId() %>"/>
                    <input type="hidden" name="petname" value="<%= rota.getPetname() %>"/>
                    <button type="submit">Select</button>
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="6">No Appointments has been assigned to you.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
