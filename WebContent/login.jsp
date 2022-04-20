<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fly Flight Booking - Login</title>
</head>
<body>

<h1>Login Form</h1>
<br> <br>

<form action="LoginDAO" method="post">
	User Email: <input type="text" name="useremail" required>
	<br> <br>
	Password:   <input type="password"  name="password" required>
	<br> <br>
	<button type="submit">Submit</button>
</form>

<br><br>

<% String authenticate = (String)request.getAttribute("authenticate");

if(authenticate != null){
	out.println(authenticate);
}
%>
	


<br> <br>

<a href="register.jsp">Sign Up? </a>
</body>
</html>