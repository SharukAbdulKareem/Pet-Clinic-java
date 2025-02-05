<%-- 
    Document   : VetsTable
    Created on : Apr 25, 2024, 6:17:29 PM
    Author     : kavil
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="modal.MyVeterinary"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Get the current date
    Calendar currentDate = Calendar.getInstance();
    
    // Find the upcoming Sunday
    int currentDayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);
    int daysTillSunday = (Calendar.SUNDAY - currentDayOfWeek + 7) % 7;
    currentDate.add(Calendar.DAY_OF_MONTH, daysTillSunday);
%>

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
        select, input[type="submit"] {
            margin: 10px 0;
            padding: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        
        /* Style the label */
        label {
            margin-bottom: 5px;
            display: block;
        }
        
        /* Style the submit button */
        input[type="submit"] {
            background-color: #4CAF50; /* Green background color */
            color: white; /* White text color */
            border: none; /* No border */
            cursor: pointer; /* Pointer cursor on hover */
        }
        
        /* Change button color on hover */
        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green color on hover */
        }
    </style>
</head>
<body>
    <form action="WeeklyRotaDate" method="POST">
        <label for="sundaySelect">Select Upcoming Week:</label>
        <select name="sundaySelect" id="sundaySelect">
            <% 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                
                for (int i = 0; i < 1; i++) {
            %>
                <option value="<%= sdf.format(currentDate.getTime()) %>"><%= sdf.format(currentDate.getTime()) %></option>
            <%
                    currentDate.add(Calendar.DAY_OF_MONTH, 7); // Move to the next Sundayyyy
                }
            %>
        </select>
        <input type="submit" value="Submit">
    </form>
</body>
</html>