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
	<h3>ReservationSuccessful</h3>

	<%
		ReservationBean reserve = (ReservationBean) request.getAttribute("reserved");
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
					out.print("<tr><td>" + reserve.getPnr() + "</td><td>" + reserve.getJid() + "</td>" + "<td>"
							+ reserve.getBid() + "</td><td>" + reserve.getName() + "</td><td>" + reserve.getIdproof()
							+ "</td><td>" + reserve.getNoOfSeats() + "</td>" + "<td>" + reserve.getSource() + "</td><td>"
							+ reserve.getDestination() + "</td><td>" + reserve.getDateofJourney() + "</td><td>"
							+ reserve.getTime() + "</td><td>" + reserve.getBtype() + "<td>" + reserve.getCost() + "</td></tr>");
				%>
			</tr>
		</table>
	</form>
</body>
</html>