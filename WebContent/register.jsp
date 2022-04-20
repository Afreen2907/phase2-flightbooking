<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fly Flight Booking - Login</title>
</head>
<body>

<h1>Registration Form</h1>
<br> <br>

<% String misPassword = (String)request.getAttribute("mismatch-password");%>

<form action="RegisterDAO" method="post">
	First Name: <input type="text" name="firstName">   Last Name: <input type="text" name="lastName">
	<br> <br>
	Age: 		<input type="number" name="age">       Document Type: <select name = "docType">
																		<option>Passport</option>
																		<option>NRIC</option>
																		<option>Aadar Card</option>
																	</select>
	<br> <br>
	Address: 	<input type="text" name="address">	   Country: <input type="text" name="country">
	<br> <br>
	<hr>
	<br> 
	
	User Email: <input type="text" name="useremail" required>
	<br> <br>
	
	Password: <input type="password" name="password" required>  Confirm Password: <input type="password" name="conPassword" required> <% 
		if(misPassword != null){
			out.println(misPassword);
		}
	%>
	<br> <br>
	
	<hr>
		<button type="submit">Submit</button>

</form>

</body>
</html>