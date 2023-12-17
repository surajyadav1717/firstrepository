<%@page import="com.studentproject.pojo.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/style.css">


</head>


<body>

	<%
	User user = (User) session.getAttribute("user");
	%>


	<div id="main">

		<%
		if (user != null) {
		%>

		<h1>
			 STUDENT MANAGEMENT PROJECT :<%=user.getName()%></h1>
		<%
		} else {
		%>


		<h1>WELCOME TO STUDENT MANAGEMENT PROJECT</h1>

		<%
		}
		%>
	</div>

	<div align="center" id="lside">


		<jsp:include page="leftside.jsp"></jsp:include>
	</div>

	<div>
		<h2>
			<a href="adduser.jsp">Register</a>
		</h2>

		<h2>
			<a href="addstudent.jsp">Add Student</a>

		</h2>

		<h2>
			<a href="StudentServlet">Student List</a>
		</h2>


		<h2>

			<a href="addstudent.jsp">Add Student</a>

		</h2>
		<h2>
			<a href="UserServlet">UserList</a>
		</h2>


		<h2>
			<a href="login.jsp">Login</a>
		</h2>


		<h2>
			<a href="LoginServlet">Logout</a>
		</h2>

	</div>

</body>
</html>