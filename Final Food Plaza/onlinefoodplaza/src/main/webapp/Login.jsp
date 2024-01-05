<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.foodplaza_ganesh.pojo.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<h2>Login</h2>

<form action="login" method="post">
<table>
<tr>
<td>Choose</td>
<td><Select name="type">
<option>-----Choose-----</option>
<option value="User">User</option>
<option value="Admin">Admin</option>
</select>
</td>
</tr>


<tr>
<td>Email</td>
<td><input type="text" name="EmailId"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="text" name="Password"></td>
</tr>
</table>

<input type="submit" name="action" value="login">
<input type="Reset" value="cancel">




</form>


<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>