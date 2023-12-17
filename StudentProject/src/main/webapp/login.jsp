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

	<div id="main">

		<h1>WELCOME TO STUDENT MANAGEMENT SYSTEM</h1>


		<form action="LoginServlet" method="post">

			<table cellpadding="10px" cellspacing="10px" border="4">


				<tr>


					<th>UserType</th>
					<td><select name="userType">

							<option>---Select User Type----</option>

							<option value="admin">ADMIN</option>

							<option value="user">USER</option>

					</select></td>
				</tr>


				<tr>
					<th>Email</th>
					<td><input type="text" name="email"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="login"></td>
					<td><input type="reset" value="reset"></td>
				</tr>

			</table>

		</form>
	</div>

</body>
</html>