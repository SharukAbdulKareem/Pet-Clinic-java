<%-- 
    Document   : UpdateWeeklyRota
    Created on : Apr 25, 2024, 8:21:06 PM
    Author     : sharuk
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modal.MyVeterinary"%>
<%@page import="modal.MyWeeklyRota"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<MyWeeklyRota> weeklyRotaDetailsList = (List<MyWeeklyRota>) request.getAttribute("weeklyRotaDetailsList");
    
    List<MyVeterinary> vetList = (List<MyVeterinary>) request.getAttribute("vetList");

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function editWeeklyRota() {
                 // Loop through all rows
                var rows = document.querySelectorAll("tbody tr");
                rows.forEach(function(row) {
                    var veterinary1 = row.querySelector(".vet1");
                    var veterinary2 = row.querySelector(".vet2");
                    var veterinary3 = row.querySelector(".vet3");

                    var vet1Value = veterinary1.innerHTML;
                    var vet2Value = veterinary2.innerHTML;
                    var vet3Value = veterinary3.innerHTML;
 
                    var vet1 = createVetSelect(vet1Value);
                    var vet2 = createVetSelect(vet2Value);
                    var vet3 = createVetSelect(vet3Value);

                    veterinary1.innerHTML = "";
                    veterinary2.innerHTML = "";
                    veterinary3.innerHTML = "";

                    veterinary1.appendChild(vet1);
                    veterinary2.appendChild(vet2);
                    veterinary3.appendChild(vet3);
                });

                // Hide the "Edit All Rows" button
                document.getElementById("editButton").style.display = "none";
                
                document.getElementById("updateButton").style.display = "inline-block";
            }

            function createVetSelect(selectedValue) {
                 var select = document.createElement("select");

                // Add vet IDs to the combo box
                <% for (MyVeterinary vet : vetList) { %>
                    option = document.createElement("option");
                    option.value = "<%= vet.getUsername() %>";
                    option.text = "<%= vet.getUsername() %>";
                    // Check if the current vet ID matches the selected value
                    if ("<%= vet.getUsername() %>" === selectedValue) {
                        option.selected = true;
                    }
                    select.add(option);
                <% } %>

                return select;
            }
            
            function validateSelection() {
                var rows = document.querySelectorAll("tbody tr");
                var formData = [];
                var errorMessages = []; // Initialize errorMessages array

                rows.forEach(function(row) {
                    var vet1Field = row.querySelector(".vet1 select");
                    var vet2Field = row.querySelector(".vet2 select");
                    var vet3Field = row.querySelector(".vet3 select");

                    var vet1Value = vet1Field.value;
                    var vet2Value = vet2Field.value;
                    var vet3Value = vet3Field.value;

                    formData.push({
                        date: row.getAttribute("data-id"),
                        vet1: vet1Value,
                        vet2: vet2Value,
                        vet3: vet3Value
                    });

                    // Check if vet IDs are different for each day
                    if (vet1Value === vet2Value || vet1Value === vet3Value || vet2Value === vet3Value) {
                        errorMessages.push("Veterinarians Cannot Be Same For Each Day.");
                    }
                });

                var errorMessageDiv = document.getElementById("errorMessage");
                errorMessageDiv.innerHTML = ""; // Clear previous error messages
                errorMessageDiv.style.color = "red";

                if (errorMessages.length > 0) {
                    errorMessages.forEach(function(message) {
                        errorMessageDiv.innerHTML += "<p>" + message + "</p>";
                    });
                    return false; // Prevent form submission
                }

                // Populate the hidden input field with JSON string
                document.getElementById("formDataInput").value = JSON.stringify(formData);

                return true; // Allow form submission
            }

        </script>
        <style>
            #updateButton {
                display: none;
            }
        </style>
    </head>
    <body>
        
        
        
    
        <form action="UpdateWeeklyRota" method="POST" onsubmit="return validateSelection();">
            <h2> Weekly Rota</h2>
            <table border="1" width="100%">
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
                     <% for (MyWeeklyRota report : weeklyRotaDetailsList) { %>
                        <tr data-id="<%= report.getId() %>">
                            <td><%= report.getId() %></td>
                            <td><%= getDayOfWeek(report.getId(), sdf) %></td>
                            <td class="vet1"><%= report.getVet1() %></td>
                            <td class="vet2"><%= report.getVet2() %></td>
                            <td class="vet3"><%= report.getVet3() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
                
                <br> <br>

            <div id="errorMessage"></div>
            <button type="button" id="editButton" onclick="editWeeklyRota()">Edit Weekly Rota</button>
            <input type="submit" id="updateButton" value="Update">
            
             <!-- Hidden input field to hold JSON string -->
            <input type="hidden" id="formDataInput" name="formData">
        </form>
                
        <%!
            private String getDayOfWeek(String dateStr, SimpleDateFormat sdf) {
                try {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(sdf.parse(dateStr));
                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                    // Convert numeric day of the week to a string
                    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                    return daysOfWeek[dayOfWeek - 1];
                } catch (Exception e) {
                    return "Error";
                }
            }
        %>
    </body>
</html>