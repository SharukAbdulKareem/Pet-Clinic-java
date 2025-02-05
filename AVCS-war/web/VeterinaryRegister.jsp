<%-- 
    Document   : VetRegister
    Created on : Apr 24, 2024, 12:25:01 PM
    Author     : sharuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="VetsTable.jsp"></a>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <style>
    /* Styles for registration form */
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

    /* Styles for input fields */
    .input, .select {
      width: calc(100% - 20px); /* Subtract padding and border width */
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      margin-bottom: 10px; /* Add space between input fields */
    }

    /* Styles for button */
    .button {
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
    <h2>Veterinary Registration</h2>

    <form action="VeterinaryRegister" method="POST">
      <div class="form-group">
        <label class="label" for="username">Username:</label>
        <input type="text" class="input" id="username" name="username" required>
      </div>

      <div class="form-group">
        <label class="label" for="contact">Contact Number:</label>
        <div class="input-group">
          
          <input type="text" class="input" name="contact" required>
        </div>
      </div>

      <div class="form-group">
        <label class="label" for="email">Email:</label>
        <input type="email" class="input" id="email" name="email" required>
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
        <label class="label" for="medicalID">Medical ID:</label>
            <input type="text" class="input" id="medicalID" name="medicalID" required>
      </div>
               
               
            <div class="form-group">
                <label for="label1" for="expertise1">Area of Expertise 1: </label>
                
                    <select class="select" id="expertise1" name="expertise1" required>
                        <option value="" selected disabled >Select A Area</option>
                        <option value="Farm Animals">Farm Animals</option>
                        <option value="Reptiles">Reptiles</option>
                        <option value="Birds">Birds</option>
                        <option value="Normal pets">Normal Pets</option> 
                        <option value="Fishes">Fishes</option> 
                        
                    </select>
                
            </div>
            <div class="form-group">
                <label for="label2" for="expertise2">Area of Expertise 2: </label>
                
                    <select class="select" id="expertise1" name="expertise2" required>
                        <option value="" selected disabled >Select A Area</option>
                        <option value="Farm Animals">Farm Animals</option>
                        <option value="Reptiles">Reptiles</option>
                        <option value="Birds">Birds</option>
                        <option value="Normal Pets">Normal Pets</option> 
                        <option value="Fishes">Fishes</option> 
                        
                    </select>
                
            </div>
        
            <div class="form-group">
                <label for="password" for="password">Password:</label>
                
                    <input type="password" class="input" id="password" name="password" required>
                
            </div>
            <div class="form-group">
                <label for="fpassword" class="col-sm-2 col-form-label">Confirm Password:</label>
                
                    <input type="password" class="input" id="fpassword" name="fpassword" required>
                
            </div>
            <div class="row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="button">Register</button>
                </div>
            </div>
        </form>
    </body>
</html>
