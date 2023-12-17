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

	<div align="center">
	
	
	<div id="lside">


		<jsp:include page="leftside.jsp"></jsp:include>
	</div>

		<h1>ADD STUDENT PAGE</h1>

		<form action="StudentServlet" method="post">

			<input type="hidden" name="action" value="addstudent">

			<table cellspacing="10px" cellpadding="10px" border="4">


				<tr>
					<th>Name</th>
					<td><input type="text" name="name"></td>
				</tr>


				<tr>
					<th>RollNo</th>
					<td><input type="text" name="rollno"></td>
				<tr>
				
				<tr>
					<th>Grade</th>
					<td><input type="text" name="grade"></td>
				<tr>
				
				<tr>
					<th>College</th>
					<td><input type="text" name="college"></td>
				<tr>
				
				
					<th><input type="submit" value="Save"></th>
					<th><input type="reset" value="Reset"></th>

				</tr>
			</table>

			<h2>

				<a href="index.jsp">Home</a>

			</h2>


		</form>
	</div>

</body>
</html>