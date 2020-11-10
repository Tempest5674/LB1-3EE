<%@ page import="java.io.PrintWriter" %>
<%@ page import="dao.ClientDAO" %>
<%@ page import="classes.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 31.10.2020
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    PrintWriter pw = response.getWriter();
    ClientDAO<Client> clientDao = new ClientDAO<>();
    List<Client> clientList = clientDao.findAll();
    for(Client c : clientList){
        pw.println(c.firstName);
    }
%>
</body>
</html>
