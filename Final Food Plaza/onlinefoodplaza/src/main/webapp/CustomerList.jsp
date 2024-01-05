<%@page import="com.foodplaza_ganesh.pojo.CustomerList"%>
<%@page import="java.util.List,com.foodplaza_ganesh.dao.*" %>
<%@page import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
</head>
<body>
   <jsp:include page="Header.jsp"></jsp:include> 

    <% List<CustomerList> customerList = (List)session.getAttribute("clist"); %>
    <table border="2">
        <caption>Customers</caption>
        <tr>
            <th>Customer Name</th>
            <th>EmailId</th>
            <th>Password</th>
            <th>Address</th>
            <th>Contact NO</th>
            <th colspan="2">Action</th>
        </tr>

        <% Iterator<CustomerList> it = customerList.iterator(); 
        while (it.hasNext()) {
            CustomerList customer = it.next();
        %>
        <tr>
            <td><%= customer.getName() %></td>
            <td><%= customer.getEmail() %></td>
            <td><%= customer.getPassword() %></td>
            <td><%= customer.getAddress() %></td>
            <td><%= customer.getContact() %></td>
            <!-- Add buttons or links for actions (edit, delete, etc.) here -->
            <td><a href="UpdateCustomer.jsp?email=<%=customer.getEmail() %>">Edit</a></td>
            <td><a href="customer?action=delete&email=<%=customer.getEmail() %>">delete</a></td>
        </tr>
        <% } %>

    </table>

 <jsp:include page="Footer.jsp"></jsp:include>  

</body>
</html>
