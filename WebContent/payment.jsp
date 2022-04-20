<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway-Payment Confirmation</title>
</head>
<body>
<img src="asset/pk-1.png"/>
<br>
<br>
<br>
<% String flightNo = request.getParameter("id"); 
   String userId = request.getParameter("userId");
%>

	<a href="confirmation.jsp?userId=<%=userId %>&id=<%=flightNo %>" type="submit">Payment Done!</a>



</body>
</html>