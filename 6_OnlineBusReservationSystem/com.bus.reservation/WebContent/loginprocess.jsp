<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="Dao.LoginDao"%>
	<jsp:useBean id="obj" class="bean.LoginBean" />

	<jsp:setProperty property="*" name="obj" />
	<%  
	String uname=(String)request.getParameter("uname");
	String pass=(String)request.getParameter("pass");
	obj.setUsername(uname);
	obj.setPassword(pass);
	session.setAttribute("uname",uname);
	request.setAttribute("obj",obj);
	RequestDispatcher rd=request.getRequestDispatcher("LoginServlet");
	rd.forward(request,response);
%>
</body>
</html>