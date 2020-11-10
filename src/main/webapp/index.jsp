<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 27.10.2020
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LB1</title>
    <link href="css/index.css" type="text/css" rel="stylesheet"></link>
</head>
<body>
<div class="outer">
    <div class="inner1">
        <div class="btnbx">
            <form action="${pageContext.request.contextPath}/servlets.toTableServlet" method="post">
                <input type="hidden" name="role" value="${role}">
                <div class="btnd">
                    <button type="submit" name="button" value="buttonClients" class="btn"><span>Clients</span></button>
                </div>
                <div class="btnd">
                    <button type="submit" name="button" value="buttonCars" class="btn"><span>Cars</span></button>
                </div>
                <div class="btnd">
                    <button type="submit" name="button" value="buttonRent" class="btn"><span>Rent</span></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
