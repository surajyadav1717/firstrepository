<%@page import="com.studentproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%

	String admin=(String)session.getAttribute("admin");

	User user= (User)session.getAttribute("user");
%>

	<div id="core">


		<h1>ALL CONTENT</h1>



	</div>


	<h2>
		<a href="index.jsp">HOME </a>
	</h2>

	<% if(user!=null && admin==null){ %>

	<h2>
		<a href="addstudent.jsp"> ADD STUDENT </a>
	</h2>


	<h2>
		<a href="StudentServlet">STUDENT LIST</a>
	</h2>

	<%} if (admin!=null && user==null){ %>

	<h2>
		<a href="UserServlet">USERLIST</a>
	</h2>

	<%} if (user==null && admin==null) {%>

	<h2>
		<a href="adduser.jsp">REGISTER</a>
	</h2>

	<h2>
		<a href="login.jsp">LOGIN</a>
	</h2>


	<%} if(user!=null || admin!=null){
		%>

	<h2>
		<a href="LoginServlet">LOGOUT</a>
	</h2>

	<%}%>
</body>
</html>