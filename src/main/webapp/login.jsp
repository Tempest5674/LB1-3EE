<%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 08.11.2020
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LB1</title>
    <link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="outer">
    <div class="inner1">
        <form action="${pageContext.request.contextPath}/servlets.loginServlet" method="post">
            <div class="container">
                <label><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
            </div>
            <div class="btnbox">
                <button type="submit" class="btnLogin"><span>Login</span></button>
                <button type="submit" class="btnRegister"><span>Register</span></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
