<%-- 
    Document   : ReceptionistRegister
    Created on : Apr 24, 2024, 10:08:54 AM
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

        /* Styles for labels */
        .label {
            display: block; /* Make labels appear on separate lines */
            margin-bottom: 5px; /* Add some space below the label */
            font-weight: bold; /* Make labels bold */
        }
        
        .select {
            width: calc(100% - 20px); /* Subtract padding and border width */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 10px; /* Add space between input fields */
        }

        /* Styles for input fields */
        .form-control {
            width: calc(100% - 20px); /* Subtract padding and border width */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 10px; /* Add space between input fields */
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

        /* Centering the heading */
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="registration-form">
    <h2>Receptionist Register</h2>

    <form action="ReceptionistRegister" method="POST">
        <div class="form-group">
            <label class="label" for="name">Username:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label class="label" for="age">Age:</label>
            <input type="text" class="form-control" id="age" name="age" required>
        </div>

        <div class="form-group">
            <label class="label" for="gender">Gender:</label>
            <select class="select" id="gender" name="gender" required>
                <option value="" selected disabled>Select Your Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select>
        </div>
        

        <div class="form-group">
            <label class="label" for="contact">Contact Number:</label>
            <div class="input-group">
                
                <input type="text" class="form-control" name="contact" required>
            </div>
        </div>

        <div class="form-group">
            <label class="label" for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label class="label" for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label class="label" for="fpassword">Confirm Password:</label>
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