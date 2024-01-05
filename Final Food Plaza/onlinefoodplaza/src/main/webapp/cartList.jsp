<%@page import="com.foodplaza_ganesh.pojo.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List,com.foodplaza_ganesh.pojo.*"%>
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
<% List<Cart> cartList=(List)session.getAttribute("clist");
%>
<form action="placeorder" method="post">
<table border="2">
<caption>All Cart</caption>
<tr>
<th>Cart Id</th>
<th>Food ID</th>
<th>Food Name</th>
<th>Email</th>
<th>Price</th>
<th>Quantity</th>
<th>Total Price</th>


</tr>
<% Iterator<Cart> it=cartList.iterator();
while(it.hasNext()){
	Cart cart=it.next();

%>
<tr>
<td><%= cart.getId()%></td>
<td><%= cart.getFoodid()%></td>
<td><%= cart.getFoodname()%></td>
<td><%= cart.getEmail()%></td>
<td><%= cart.getPrice()%></td>
<td><%= cart.getQuantity()%></td>
<td><%= cart.getTotalprice()%></td>
<td><a href="cart?action=delete&id=<%=cart.getId() %>">delete</a></td>
</tr>
<%} %>
</table>
<input type="submit" value="placeorder">
</form>
<jsp:include page="Footer.jsp"></jsp:include>

</body>

</html>