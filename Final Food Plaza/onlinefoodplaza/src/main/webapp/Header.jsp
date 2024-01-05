

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%

String customerEmailId=(String)session.getAttribute("custEmailId");

String adminEmailId=(String)session.getAttribute("adminEmailId");

%>
<!--  Free CSS Template by TemplateMo.com  --> 
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
    <ul>
    <%  if(customerEmailId==null && adminEmailId==null) {   %>
            <li class="current"><a href="index.jsp"><b>Home</b></a></li>
            <li><a href="food"><b>Food Menu</b></a></li>
            <li><a href="AddCustomer.jsp"><b>Registration</b></a></li>
            <li><a href="Login.jsp"><b>Login</b></a></li>
            <li ><a href="#"><b>Contact</b></a></li>
            <%} %>
            
     <%  if(customerEmailId!=null && adminEmailId==null) {   %>
     
             <li><a href="food"><b>Food Menu</b></a></li>
             <li ><a href="cart"><b>CartList</b></a></li>
             <li><a href="ChangePassword.jsp"><b>ChangePassword</b></a></li>
             <li ><a href="login"><b>Logout</b></a></li>
              <li ><a href="#"><b>Update Profile</b></a></li>
            <%} %>
            
      
     <%  if(customerEmailId==null && adminEmailId!=null) {   %>
            <li><a href="food"><b>Food Menu</b></a></li>
            <li ><a href="Addfood.jsp"><b>AddFood</b></a></li>
            <li><a href="ChangePassword.jsp"><b>ChangePassword</b></a></li>
           <li ><a href="customer"><b>Customer List</b></a></li>
           <li ><a href="#"><b>Logout</b></a></li>
           <%} %>
        </ul>
    </div> <!-- end of menu -->


</body>
</html>