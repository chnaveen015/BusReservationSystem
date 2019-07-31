<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
	<%@ include file="STARTFROMHERE.jsp"%>
	<hr>
	<br>
	<br>
	<%
		ArrayList<String> sources = (ArrayList<String>) request.getAttribute("sources");
	
	ArrayList<String> destinations = (ArrayList<String>) request.getAttribute("destination");
	%>



	<form action="NoOfBusesServlet" method="post">
		<table align="center">
			<tr>
				<td>select the source:</td>
				<td><select name="sources">

						<%
							for (String s : sources) {
						%>
						<option>
							<%=s%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Enter the destination:</td>
				<td><select name="destinations">

						<%
							for (String d : destinations) {
						%>
						<option>
							<%=d%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>



			<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>


</body>
</html>