<%-- 
    Document   : ReceptionistLogin
    Created on : Apr 24, 2024, 10:08:09 AM
    Author     : sharuk
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
      /* Styles for login form container */
      .login-container {
        width: 300px; /* Adjust width as needed */
        margin: 50px auto; /* Center the form vertically and horizontally */
        border: 1px solid #ddd; /* Add a thin border */
        padding: 20px; /* Add some padding */
        border-radius: 4px; /* Add rounded corners */
      }

      /* Styles for headings */
      .h1 {
        text-align: center; /* Center the heading text */
        margin-bottom: 20px; /* Add some space below the heading */
      }

      /* Styles for labels */
      .label {
        display: block; /* Make labels appear on separate lines */
        margin-bottom: 5px; /* Add some space below the label */
      }

      /* Styles for input fields */
      .input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
      }

      /* Styles for button */
      .button {
        background-color: #C3DFD6; /* Green color */
        border: none;
        color: black;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin-top: 10px;
        cursor: pointer;
        border-radius: 4px;
      }

      /* Styles for link */
      .link {
        color: purple; /* Adjust link color as needed */
        text-decoration: none; /* Remove underline */
      }
    </style>
  </head>
  <body>
    <div class="login-container">
      <h1 class="h1">Receptionist Login</h1>

      <form action="ReceptionistLogin" method="POST">
        <label class="label">Username</label>
        <input type="text" name="username" class="input">

        <label class="label">Password</label>
        <input type="password" name="password" class="input">

        <div class="button-container">
            <button class="button" type="submit"><b>Login</b></button>
        </div>

        <br>
        <p>
          If you're a new Receptionist
          <a href="ReceptionistRegister.jsp" class="link">Register here!</a>
        </p>
      </form>
    </div>

  </body>
</html>
