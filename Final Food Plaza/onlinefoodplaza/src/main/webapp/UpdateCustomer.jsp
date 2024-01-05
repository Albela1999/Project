<%@page import="com.foodplaza_ganesh.pojo.*" %>
<%@page import="com.foodplaza_ganesh.dao.*" %>


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

<%
String email=request.getParameter("email");
CustomerDaoImpl cdi=new CustomerDaoImpl();
CustomerList customer=cdi.searchCust(email);
%>
<form action="customer" method="post">
<table>
<tr>
<td>Customer name</td>
<td><input type="text" name="name" value="<%= customer.getName() %>"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email" value="<%= customer.getEmail()%>"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="text" name="password" value="<%= customer.getPassword()%>"></td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" value="<%= customer.getAddress()%>"></td>
</tr>

<tr>
<td>Contact No</td>
<td><input type="text" name="contact" value="<%= customer.getContact()%>"></td>
</tr>
</table>

<input type="submit" name="action" value="UpdateCustomer">
<input type="reset" value="clear">

</form>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>