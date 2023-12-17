
<%@page import="com.studentproject.pojo.Student"%>
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
	<div id="lside">


		<jsp:include page="leftside.jsp"></jsp:include>
	</div>

	

	<%
	Student student = (Student) session.getAttribute("student");
	%>



	<div align="center">
	

		<h1>Update Student Form</h1>

		<form action="StudentServlet" method="post">
			<input type="hidden" name="action" value="updatestudent"> <input
				type="hidden" name="id" value="<%=student.getId()%>">

			<table border="5" cellspacing="10px" cellpadding="10px">



				<tr>
					<th>Name</th>
					<td><input type="text" name="name"
						value="<%=student.getName()%>"></td>
				</tr>
				
				
				<tr>
				<th>RollNo</th>
				<td><input type="text" name="rollno" value="<%=student.getRollno()%>"></td>
				</tr>
				
				<tr>
				<th>Grade</th>
				<td><input type="text" name="grade" value ="<%=student.getGrade()%>"></td>
				</tr>

				<tr>
					<th>College</th>
					<td><input type="text" name="college"
						value="<%=student.getCollege()%>"></td>
				<tr>

					<th><input type="submit" value="save"></th>
					<th><input type="Reset" value="reset"></th>
				</tr>
			</table>

		</form>

		<h2>

			<a href="index.jsp">Home</a>

		</h2>
	</div>
</body>
</html>