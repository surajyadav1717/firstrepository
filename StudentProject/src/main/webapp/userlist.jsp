<%@page import="com.studentproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

	<div id="lside">


		<jsp:include page="leftside.jsp"></jsp:include>
	</div>


	<%
	List<User> userList = (List<User>)session.getAttribute("userList");
	%>

	<div align="center">

		<h1>All USERS LIST</h1>

		<table cellspacing ="10" cellpadding="10" border="6">

			<tr>

				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th colspan="2">Action</th>

			</tr>
 
			<%
			for (User u : userList) {
			%>

			<tr>

				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPassword()%></td>

				<td><a href="UserServlet?action=delete&&id=<%=u.getId()%>">Delete</a></td>
				<td><a href="UserServlet?action=edit&&id=<%=u.getId()%>">Edit</a></td>

			</tr>

			<%
			}
			%>
		</table>
		<h2>

			<a href="index.jsp">Home</a>

		</h2>
	</div>

</body>
</html>