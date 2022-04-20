<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="entity.FlightDetails"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fly Flight Booking - Login</title>

</head>
<body>

<h1>Search Flight</h1>
<br> <br>
<form action="SearchDAO?userId=<%=request.getParameter("userId") %>" method="post">
<label for="source">Source City: </label>
 <select id="source" name="source_city" required>
 	<option>Singapore</option>
 	<option>Malaysia</option>
 	<option>Australia</option>
 </select>
<br> <br>
 <label for="destination">Destination Country: </label>
<select  id="destination" name="destination_city" required>
	<option>Singapore</option>
 	<option>Malaysia</option>
 	<option>Australia</option>
</select>
<br> <br>

 <label for="departDate">Depart Date:</label>
 <input type="date" id="departDate" name="departDate" required>
<br> <br>
<button type="submit">Submit</button>
</form>

<br> <br>
<% String userId = request.getParameter("userId"); %>
<hr>
<h4>Flight Search Result</h4>

<table border="1" cellpadding="2" cellspacing="2">
	<tr>
		<th>Flight No</th>
		<th>Airline Name</th>
		<th>Departure Time</th>
		<th>Arrival Time</th>
		<th>Source Country</th>
		<th>Destination Country</th>
		<th>Price($)</th>
		<th>        </th>
	</tr>
	
<% List<FlightDetails> details = (List<FlightDetails>)request.getAttribute("flightLists"); 
	if(details != null){
		
		for(FlightDetails detail : details){%>
		
		<tr>
				<td><%=detail.getFlight_no() %></td>
				<td><%=detail.getAirline_name() %></td>
				<td><%=detail.getDeparture_time() %></td>
				<td><%=detail.getArrival_time() %></td>
				<td><%=detail.getSource_city() %></td>
				<td><%=detail.getDestination_city() %></td>
				<td><%=detail.getPrice() %></td>
				<td><a href="payment.jsp?userId=<%=userId%>&id=<%=detail.getFlight_no() %>">Book</a></td>
				
				</tr>
	
	<%	}}
	
%>
	
	
</table>



<hr>

</body>
</html>