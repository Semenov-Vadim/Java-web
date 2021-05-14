<%@ page language="java" contentType = "text / html; charset = UTF-8"
pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title> User page </title>
	</head>
	<body>
		<h3> User Page </h3>
		
		<form action= "ShowStuff" method= "POST">
			<input type="submit" value= "Show stuff" />
		</form>
        
		<p style="color:red;"> ${errorString} </p>
		
		<form method = "POST" action = "UpdateUser">
			<table>
				<tr>
					<td> Email address:</td>
					<input type = "hidden" name = "email" value = "${user.email}"/>
					<td> <input type = "text" name = "email" value = "${user.email}"disabled/> </td>
				</tr>
				<tr>
					<td> Password </td>
					<td> <input type = "text" name = "password" value = "${user.password}" /> </td>
				</tr>
                <tr>
					<td> Name </td>
					<td> <input type = "text" name = "name" value = "${user.name}" /> </td>
				</tr>
                <tr>
					<td> Surname </td>
					<td> <input type = "text" name = "surname" value = "${user.surname}"/> </td>
				</tr>
                <tr>
					<td> Phone </td>
					<td> <input type = "text" name = "phone" value = "${user.phone}" /> </td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value= "Update" /></td>
				</tr>
			</table>
		</form>
		
        <form action= "login.html" method= "get">
			<input type="submit" value= "Exit" />
		</form>
	</body>
</html>