<%@ page language="java" import="com.foodplaza_ganesh.pojo.*,com.foodplaza_ganesh.dao.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function total(){
	quantity=parseInt(document.getElementById("quantity").value)
	price=parseFloat(document.getElementById("price").value)
	totalp=quantity*price
	document.getElementById("totalprice").value=totalp
}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
int id=Integer.parseInt(request.getParameter("id"));
FoodPlazaDaoImpl fdi=new FoodPlazaDaoImpl();
FoodPlaza foodplaza=fdi.searchFoodById(id);
String customerEmailId=(String)session.getAttribute("custEmailId");
%>
<form action="cart" method="post">
<table>

<tr>
<td>FoodId</td>
<td><input type="text" name="id" value="<%=foodplaza.getId()%>"></td>
</tr>

<tr>
<td>FoodName</td>
<td><input type="text" name="name" value="<%=foodplaza.getName()%>"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email" value="<%=customerEmailId%>"></td>
</tr>

<tr>
<td>Price</td>
<td><input type="text" name="price" id="price" value="<%=foodplaza.getPrice()%>" ></td>
</tr>
<tr>
<td>Quantity</td>
<td><input type="text" name="quantity" id="quantity"></td>
</tr>
<tr>
<td>TotalPrice</td>
<td><input type="text" onclick="total()" id="totalprice" name="TotalPrice" ></td>
</tr>
</table>
<input type="submit" value="addCart"> >
<input type="reset" value="clear"> 

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>