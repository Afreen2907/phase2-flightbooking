<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>
</head>
<body>
<%String flightNo = (String)request.getParameter("id"); 
	
	out.println("Your booking have been confirmed for the flight no: " + flightNo);

%>

<img src="asset/booking-confirmation.jpg" />


</body>
</html>