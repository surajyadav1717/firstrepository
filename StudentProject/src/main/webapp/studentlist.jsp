<%@page import="com.studentproject.pojo.Student"%>
<%@page import="com.studentproject.dao.Studentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/style.css">

</head>
<%
	List<Student> studentList =(List<Student>)session.getAttribute("studentList");
	%>

<body>

	<div align="center" id="lside">


		<jsp:include page="leftside.jsp"></jsp:include>
	</div>

	<div align="center">
		<h1>All STUDENT LIST</h1>

		<table border="4" cellspacing="10px" cellpadding="10">

			<tr>

				<th>ID</th>
				<th>Name</th>
				<th>RollNo</th>
				<th>Grade</th>
				<th>College</th>
				
				<th colspan="2">Action</th>
			</tr>

			<%
			for (Student c :studentList) { %>
			<tr>

				<td><%=c.getId()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getRollno()%></td>
				<td><%=c.getGrade()%></td>
				<td><%=c.getCollege()%></td>

				<td><a href="StudentServlet?action=delete&&id=<%=c.getId()%>">delete</a></td>

				<td><a href="StudentServlet?action=edit&&id=<%=c.getId()%>">Edit</a></td>

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