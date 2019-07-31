<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.ReservationBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Welcome.jsp"%>
	<br>
	<br>
	<h3>Ticket</h3>

	<%
		ReservationBean ticket = (ReservationBean) request.getAttribute("details");
	%>
	<form align="center">
		<table border="1" align="center">
			<thead>
				<tr>
					<th>PNR</th>
					<th>JID</th>
					<th>BID</th>
					<th>NAME</th>
					<th>ID PROOF NO</th>
					<th>NO OF SEATS</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>Date</th>
					<th>TIME</th>
					<th>BUS TYPE</th>
					<th>COST</th>
				</tr>
			</thead>


			<tr>
				<%
					out.print("<tr><td>" + ticket.getPnr() + "</td><td>" + ticket.getJid() + "</td>" + "<td>" + ticket.getBid()
							+ "</td><td>" + ticket.getName() + "</td><td>" + ticket.getIdproof() + "</td><td>"
							+ ticket.getNoOfSeats() + "</td>" + "<td>" + ticket.getSource() + "</td><td>"
							+ ticket.getDestination() + "</td><td>" + ticket.getDateofJourney() + "</td><td>" + ticket.getTime()
							+ "</td><td>" + ticket.getBtype() + "<td>" + ticket.getCost() + "</td></tr>");
				%>
			</tr>
		</table>
	</form>
</body>
</html>