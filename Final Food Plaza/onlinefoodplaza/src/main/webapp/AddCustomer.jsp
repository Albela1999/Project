<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action="customer" method="post">
<table>
<tr>
<td>Customer Name<td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>Email<td>
<td><input type="text" name="email"></td>
</tr>

<tr>
<td>Password<td>
<td><input type="text" name="password"></td>
</tr>

<tr>
<td>Address<td>
<td><input type="text" name="address"></td>
</tr>

<tr>
<td>Contact No<td>
<td><input type="text" name="contact"></td>
</tr>
</table>

<input type="submit" name="action" value="addCustomer">
<input type="reset" value="clear">

</form>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>