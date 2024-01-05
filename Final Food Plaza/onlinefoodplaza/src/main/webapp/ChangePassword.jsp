<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
    <form action="login" method="post">
        <table>
            <caption>Change Password</caption>
            <tr>
                <td>Choose</td>
                <td>
                    <select name="type">
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
                <td>Old Password</td>
                <td><input type="text" name="OPass"></td>
            </tr>
            <tr>
                <td>New Password</td>
                <td><input type="text" name="newpass"></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="text" name="cpass"></td>
            </tr>
        </table>
        <input type="submit" name="action" value="changepassword">
        <input type="reset" value="clear">
    </form>
    <jsp:include page="Footer.jsp"></jsp:include>
    
</body>
</html>
