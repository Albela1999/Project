<%@page import="com.foodplaza_ganesh.pojo.PlaceOrder"%>
<%@page import="com.foodplaza_ganesh.dao.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>

    <%
        PlaceOrder o = (PlaceOrder)request.getAttribute("placeorder");
        if (o != null) {
    %>
            <p>Id: <%= o.getId() %></p>
            <p>EmailId: <%= o.getEmail() %></p>
            <p>Date: <%= o.getDate() %></p>
            <p>Total Price: <%= o.getTotalprice() %></p>
    <%
        }
    %>

    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
