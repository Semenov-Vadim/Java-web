<%@ page language="java" contentType = "text / html; charset = UTF-8"
pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title> Login </title>
	</head>
	<body>
		<h3> Login Page </h3>
		<p style="color:red;"> ${errorString} </p>
		
		<form method = "POST" action = "login">
			<table>
				<tr>
					<td> Email address:</td>
					<td> <input type = "text" name = "email" value = "${user.email}" /> </td>
				</tr>
				<tr>
					<td> Password </td>
					<td> <input type = "password" name = "password" value = "${user.password}" /> </td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value= "login" /></td>
				</tr>
			</table>
		</form>
		<form action= "register.jsp" method= "get">
			<input type="submit" value= "Register" />
		</form>
	</body>
</html>