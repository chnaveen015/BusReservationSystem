<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.BasicDetailsBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function validate() {
		var numericExpression = /^[0-9]{12}$/;
		var a = document.forms["form"]["idProof"].value;
		if (a == null || a == "") {
			alert("enter the adhar num");
			return false;
		}
		if (a.match(numericExpression)) {
			return true;
		} else {
			alert("adhar number must be filled with 12 digit number only");
			return false;
		}

		return true;

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
	<%
		BasicDetailsBean details = (BasicDetailsBean) session.getAttribute("details");
		;
	%>
	<form action="ReservationServlet" name="form"
		onsubmit="return validate()">
		<table align="center" border="2">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="Name"></td>
			</tr>
			<tr>
				<td>Bus journey id:</td>
				<td><input type="number" name="id"
					value=<%=request.getParameter("jid")%> readonly></td>
			</tr>
			<tr>
				<td>Source:</td>
				<td><input type="text" name="source"
					value=<%=details.getSource()%> readonly></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><input type="text" name="destination"
					value=<%=details.getDestination()%> readonly></td>
			</tr>
			<tr>
				<td>No of Seats:</td>
				<td><input type="number" name="noOfSeats"
					value=<%=details.getNoOfSeats()%> readonly></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="date" name="dateofjourney"
					value=<%=details.getDateOfJourney()%> readonly></td>
			</tr>
			<tr>
				<td>Adhar No:</td>
				<td><input type="text" name="idProof"></td>
			</tr>
			<tr align="center">
				<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>