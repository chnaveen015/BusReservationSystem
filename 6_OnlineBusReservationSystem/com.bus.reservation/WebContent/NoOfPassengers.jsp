<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
#right-body {
	width: 80%;
	float: justify;
}
</style>
<body>
	<%@ include file="Admin.jsp"%>
	<br>
	<br>
	<br>
	<div id=right-body>
		<form action="NoOfPassengersServlet" align="center">
			<table align="center">
				<tr>
					<td>Enter the Bus ID:</td>
					<td><input type="number" name="bid"></td>
				</tr>
				<tr>
					<td>Enter The Date:</td>
					<td><input type="date" name="date"></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>