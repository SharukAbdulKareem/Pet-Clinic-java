<%-- 
    Document   : Homepage
    Created on : Apr 24, 2024, 11:47:16 AM
    Author     : sharuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
    <style>
      /* Styles for navigation bar links (unchanged) */


      /* Styles for horizontal header */
      .header {
        display: flex; /* Use flexbox for horizontal layout */
        justify-content: space-between; /* Distribute links evenly */
        align-items: center; /* Align content vertically */
        background-color: #C3DFD6; /* Optional background color */
        padding: 10px 20px; /* Add some padding */
      }
      .header a {
        font-size: 1.2rem; /* Adjust font size as needed */
        font-weight: bold; /* Make links appear bolder */
        text-decoration: none; /* Remove underline decoration */
        color: #333; /* Text color */
        margin-right: 20px; /* Add margin between links */
      }
      .header a:hover { /* Style on hover for visual feedback */
        color: #000; /* Change text color on hover */
      }
      /* Styles for image centering and size */
        .image-container {
          text-align: center; /* Center the image horizontally */
          margin: 20px auto; /* Add some margin for spacing */
        }
        .image {
          width: 80%; /* Adjust width as needed (maximum 100%) */
          max-width: 250px; /* Set a maximum width if needed */
        }
        /* Styles for centering text */
        .container {
          text-align: center; /* Center text horizontally */
        }
  </style>
</head>
<body>
  <header class="header">
    <a href="VeterinaryLogin.jsp">Veterinary Login</a>
    <a href="StaffLogin.jsp">Staff Login</a>
    <a href="ReceptionistLogin.jsp">Receptionist Login</a>
  </header>

  
    <div class="container ">
        <div class="text-center">
          <h1>APU Veterinary Clinic System (AVCS)</h1>
        </div>
    </div>
    <div class="image-container">
        <img src="https://i.ibb.co/CWTy4MD/1.png" class="image" alt="Image description">
      </div>

      

  <script>
    window.onload = function() {
      // Check if the URL contains the logout parameter
      var urlParams = new URLSearchParams(window.location.search);
      if (urlParams.has('logout')) {
        alert("Goodbye! Hope to see you soon.");
      }
    };
  </script>

</body>
</html>
