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

	<div align="center" id="lside">


		<jsp:include page="leftside.jsp"></jsp:include>
	</div>


	<%
	User user = (User) session.getAttribute("user");
	%>

	<div align="center">

		<h1>UPDATE USER </h1>
		<form action="UserServlet" method="post">

			<input type="hidden" name="action" value="updateuser"> <input
				type="hidden" name="id" value="<%=user.getId()%>">

			<table cellspacing="10px" cellpadding="10px" border="4">


				<tr>
					<th>Name</th>
					<td><input type="text" name="name" value="<%=user.getName()%>"></td>
				</tr>

				<tr>
					<th>Email</th>
					<td><input type="email" name="email"
						value="<%=user.getEmail()%>"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="text" name="password"
						value="<%=user.getPassword()%>"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Save"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>


			</table>
		</form>
		<h2>

			<a href="index.jsp">Home</a>

		</h2>

	</div>

</body>
</html>