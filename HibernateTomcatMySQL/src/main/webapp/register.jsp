<%@ page language="java" contentType = "text / html; charset = UTF-8"
pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
</head>
<body>
	<h3> Register a new user </h3>
	<p style="color:red;"> ${errorString} </p>
	
	<form action= "Register" method= "post">
		<table>
			<tr>
				<td>Email address*</td>
				<td><input type="text" name= "email" value = "${user.email}"/></td>
			<tr>
				<td>Password*</td>
				<td><input type="password" name= "password" value = "${user.password}"/></td>
			<tr>
				<td> Name </td>
				<td><input type="text" name= "name" value = "${user.name}"/></td>
			</tr>
            <tr>
				<td> Surname </td>
				<td><input type="text" name= "surname" value = "${user.surname}"/></td>
			</tr>
            <tr>
				<td> Phone </td>
				<td><input type="text" name= "phone" value = "${user.phone}"/></td>
			</tr>
            <tr>
				<td> <!--empty place --> </td>
				<td><input type="submit" value= "Create new account" /></td>
			</tr> 
		</table>
	</form>
	<form action= "login.html" method= "get">
		<input type="submit" value= "Back" />
	</form>
</body>
</html>