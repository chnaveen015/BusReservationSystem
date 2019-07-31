<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Welcome.jsp"%><hr>
	<br>
	<br>
	<form action="CancelServlet" align="center">
		<table align="center">
			<tr>
				<td>Enter the PNR number:</td>
				<td><input type="number" name="pnr"></td>
				<td><input type="submit" name="cancel" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>