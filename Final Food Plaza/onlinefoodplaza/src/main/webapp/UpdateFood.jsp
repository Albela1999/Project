<%@page import="com.foodplaza_ganesh.pojo.FoodPlaza"%>
<%@page import="com.foodplaza_ganesh.dao.FoodPlazaDaoImpl"%>
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


<form action="food" method="post">
<table>

<tr>
<td>Image</td>
<td><input type="text" name="Image"></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="Name"></td>
</tr>

<tr>
<td>Category</td>
<td><input type="text" name="Category"></td>
</tr>

<tr>
<td>Description</td>
<td><input type="text" name="Description"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" name="Price"></td>
</tr>

<tr>
<td>Id</td>
<td><input type="text" name="Id"></td>
</tr>



</table>
<input type="submit" name="action" value="updateFood"> 
<input type="reset" value="clear"> 


</form>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>