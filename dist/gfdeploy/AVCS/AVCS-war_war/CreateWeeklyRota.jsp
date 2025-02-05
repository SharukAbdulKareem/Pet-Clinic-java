<%-- 
    Document   : CreateWeeklyRota
    Created on : Apr 26, 2024, 12:14:17 AM
    Author     : sharuk
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="modal.MyVeterinary"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script>
        function validateForm() {
            var selectedVets = new Set();

            // Loop through each day
            var daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
            for (var i = 0; i < daysOfWeek.length; i++) {
                var vet1 = document.getElementById("vet1_" + daysOfWeek[i]).value;
                var vet2 = document.getElementById("vet2_" + daysOfWeek[i]).value;
                var vet3 = document.getElementById("vet3_" + daysOfWeek[i]).value;

                // Check if all three vet IDs are different for each day
                if (vet1 === vet2 || vet1 === vet3 || vet2 === vet3) {
                    document.getElementById("errorMessage").innerHTML = "Vet IDs must be different for each day.";
                    document.getElementById("errorMessage").style.color = "red";
                    return false;
                }

                // Add vet IDs to the set
                selectedVets.add(vet1);
                selectedVets.add(vet2);
                selectedVets.add(vet3);
            }
            // If all checks pass, submit the form
            return true;
        }
    </script>
</head>
<body>
<a href="VetDetails" id="backButton">Back</a>

<h1>Create Weekly Rota</h1>

<%
    List<MyVeterinary> vetList = (List<MyVeterinary>) request.getAttribute("vetList");

    // Display the veterinary details table
%>
<h2>Veterinary Details</h2>
<table border="1">
    <thead>
    <tr>
        <th>Vet ID</th>
        <th>Name</th>
        <th>Expertise 1</th>
        <th>Expertise 2</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (MyVeterinary vet : vetList) {
    %>
    <tr>
        <td><%= vet.getId() %></td>
        <td><%= vet.getUsername() %></td>
        <td><%= vet.getExpertise1() %></td>
        <td><%= vet.getExpertise2() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<form action="CreateWeeklyRota" method="POST" onsubmit="return validateForm();">
    <h2>Assign Vets for the Week</h2>
    <table border="1">
        <thead>
        <tr>
            <th>Day</th>
            <th>Date</th>
            <th>Vet 1</th>
            <th>Vet 2</th>
            <th>Vet 3</th>
        </tr>
        </thead>
        <tbody>
        <%
            String selectedDate = (String) request.getAttribute("selectedDate");
            List<String> daysOfWeek = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

            // Convert selected date to a Calendar object
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(selectedDate));

            for (String day : daysOfWeek) {
        %>
        <tr>
            <td><%= day %></td>
            <td><%= sdf.format(cal.getTime()) %></td>
            <% for (int i = 1; i <= 3; i++) { %>
            <td>
                <select name="vet<%= i %>_<%= day %>" id="vet<%= i %>_<%= day %>">
                    <% for (MyVeterinary vet : vetList) { %>
                    <option value="<%= vet.getUsername() %>"><%= vet.getUsername() %></option>
                    <% } %>
                </select>
            </td>
            <% } %>
            <td>
                <!-- Hidden input for the date -->
                <input type="hidden" name="date_<%= day %>" value="<%= sdf.format(cal.getTime()) %>">
                <!-- Hidden input for the vet IDs -->
                <input type="hidden" name="vet1_<%= day %>" id="hidden_vet1_<%= day %>" value="">
                <input type="hidden" name="vet2_<%= day %>" id="hidden_vet2_<%= day %>" value="">
                <input type="hidden" name="vet3_<%= day %>" id="hidden_vet3_<%= day %>" value="">
            </td>
        </tr>
        <%
            cal.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
            }
        %>
        </tbody>
    </table>

    <div id="errorMessage"></div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
