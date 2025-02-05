<%-- 
    Document   : StaffRegister
    Created on : Apr 23, 2024, 5:41:00 PM
    Author     : sharuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        /* Styles for the container */
        .registration-form {
            width: 500px; /* Adjust width as needed */
            margin: 50px auto; /* Center the form vertically and horizontally */
            padding: 20px;
            border: 1px solid #ddd; /* Add a thin border */
            border-radius: 4px; /* Add rounded corners */
          }
        .container {
            width: 500px; /* Adjust width as needed */
            margin: 50px auto; /* Center the container vertically and horizontally */
        }

        /* Styles for labels */
        .label {
            display: block; /* Make labels appear on separate lines */
            margin-bottom: 5px; /* Add some space below the label */
            font-weight: bold; /* Add space below labels */
        }

        /* Styles for input fields */
        .form-control {
            width: calc(100% - 20px); /* Subtract padding and border width */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 10px /* Add space between input fields */
        }

        /* Styles for button */
        .btn-primary {
            background-color: #C3DFD6; /* Updated background color */
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
        
        h2 {
            text-align: center;
          }
    </style>
</head>
<body>
    <div class="registration-form">
       
            <h2>Staff Register</h2>
        
        <br><br>
        <form action="StaffRegister" method="POST" onSubmit="return verifyForm()">
            <div class="row mb-3">
                <label for="name" class="label">Username:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="row mb-3">
                <label for="age" class="label">Age:</label>
                <input type="text" class="form-control" id="age" name="age" required>
            </div>
            <div class="row mb-3">
                <label for="contact" class="label">Contact Number:</label>
                <div class="input-group mb-3">
                    <span class="input-group-text">+60</span>
                    <input type="text" class="form-control" name="contact" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="email" class="label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="row mb-3">
                <label for="password" class="label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="row mb-3">
                <label for="fpassword" class="label">Confirm Password:</label>
                <input type="password" class="form-control" id="fpassword" name="fpassword" required>
            </div>
            <div class="row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
