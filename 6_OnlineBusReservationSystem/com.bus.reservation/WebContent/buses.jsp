<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.CostTicketBean,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
	<%
		ArrayList<CostTicketBean> costTicketBean = (ArrayList<CostTicketBean>) request.getAttribute("arrayList");
	%>
	<form align="center" action="reservation.jsp">
		<table border="1" align="center">
			<thead>
				<tr>
					<th>JOURNEY ID</th>
					<th>BID</th>
					<th>COST</th>
					<th>BTYPE</th>
					<th>AVAILABLE SEATS</th>
					<th>Arrival Time</th>
				</tr>
			</thead>


			<tr>
				<%
					for (CostTicketBean costTicket : costTicketBean) {
						out.print("<tr><td>" + costTicket.getJid() + "</td><td>" + costTicket.getBid() + "</td>" + "<td>" + costTicket.getCost() + "</td>"
								+ "<td>" + costTicket.getBtype() + "</td>" + "<td>" + costTicket.getAseats() + "</td><td>" + costTicket.getTime()
								+ "</td></tr>");
					}
				%>
			</tr>
		</table>
		<br>
		<br> Enter the Journey Id:<input type="number" name="jid"><input
			type="submit">
	</form>

</body>
</html>