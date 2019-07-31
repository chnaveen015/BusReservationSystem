<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.BusJourneyBean,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="income.jsp"%>
	<br>
	<br>
	<br>
	<%
		ArrayList<BusJourneyBean> journey = (ArrayList<BusJourneyBean>) request.getAttribute("income");
	%>
	<form align="center" action="reservation.jsp">
		<table border="1" align="center">
			<thead>
				<tr>
					<th>BID</th>
					<th>INCOME</th>
					<th>AVAILABLE SEATS</th>
					<th>Date</th>
				</tr>
			</thead>


			<tr>
				<%
					if (journey != null) {
						for (BusJourneyBean bjb : journey) {
							out.print("<tr><td>" + bjb.getBid() + "</td><td>" + bjb.getCost() + "</td>" + "<td>"
									+ bjb.getAvailableseats() + "</td><td>" + bjb.getDateofBusTravel() + "</td></tr>");
						}
					} else {
						out.println("no buses available here");
					}
				%>
			</tr>
		</table>
	</form>

</body>
</html>