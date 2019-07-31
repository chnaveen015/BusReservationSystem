<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="bean.BusJourneyBean,java.util.*,bean.ReservationBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="NoOfPassengers.jsp"%>
	<br>
	<br>
	<%
		ArrayList<ReservationBean> passenger = (ArrayList<ReservationBean>) request.getAttribute("passenger");
	%>
	<form align="center" action="reservation.jsp">
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
					if (passenger != null) {
						for (ReservationBean r : passenger) {
							out.print("<tr><td>" + r.getPnr() + "</td><td>" + r.getJid() + "</td>" + "<td>" + r.getBid()
									+ "</td><td>" + r.getName() + "</td><td>" + r.getIdproof() + "</td><td>" + r.getNoOfSeats()
									+ "</td>" + "<td>" + r.getSource() + "</td><td>" + r.getDestination() + "</td><td>"
									+ r.getDateofJourney() + "</td><td>" + r.getTime() + "</td><td>" + r.getBtype() + "<td>"
									+ r.getCost() + "</td></tr>");
						}
					} else {
						out.println("no passengers available here");
					}
				%>
			</tr>
		</table>
	</form>
</body>
</html>