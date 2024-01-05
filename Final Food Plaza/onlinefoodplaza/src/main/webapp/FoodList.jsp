<%@page import="java.util.List,com.foodplaza_ganesh.pojo.*"%>
<%@page import="java.util.Iterator"%>
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
<% String customerEmailId=(String)session.getAttribute("custEmailId");
String adminEmailId=(String)session.getAttribute("adminEmailId");
%>

<% List<FoodPlaza> foodlist=(List)session.getAttribute("flist"); %>
<table border="2">
<caption>Menu</caption>
<tr>
<th>Id</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Description</th>
<th>Image</th>
<%
			if (adminEmailId != null && customerEmailId == null) {
%>
<th colspan="2">action</th>
<%} %>
<%
   if (adminEmailId == null && customerEmailId != null) {
%>
			<th>action</th>
			<%
			}
			%>
		</tr>
	


<% Iterator<FoodPlaza> it=foodlist.iterator();
while(it.hasNext())
{
	FoodPlaza foodplaza=it.next();
%>
<tr>
<td><%= foodplaza.getId() %></td>
<td><%= foodplaza.getName() %></td>
<td><%= foodplaza.getCategory() %></td>
<td><%= foodplaza.getPrice() %></td>
<td><%= foodplaza.getDescription() %></td>
<td><%= foodplaza.getImage() %></td>
<% if(adminEmailId != null && customerEmailId == null) {%>
<td><a href="UpdateFood.jsp?id=<%=foodplaza.getId()%>">edit</a></td>
<td><a href="food?action=delete&id=<%=foodplaza.getId()%>">Delete</a></td>

<%} %>
<%if (adminEmailId==null && customerEmailId!=null){ %>
<td><a href="AddCart.jsp?id=<%=foodplaza.getId()%>">AddTOCart</a></td>
<%} %>

</tr>
<%} %>
</table>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>