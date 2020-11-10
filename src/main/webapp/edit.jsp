<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 09.11.2020
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/edit.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="edit-area">
    <table class="edit-table">
        <thead>
        <tr>
            <c:forEach var="columnName" items="${columnNames}">
                <th>${columnName}</th>
            </c:forEach>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <form action="${pageContext.request.contextPath}/servlets.editServlet" method="post">
            <input type="hidden" name="tableName" value="${chosenTable}">
            <input type="hidden" name="idToEdit" value="${idToEdit}">
            <tr>
                <c:forEach var="placeHolderName" items="${placeHolderNames}" varStatus="row">
                    <td><input type="text" class="myInputEdit" name="myInput${row.count}"
                               placeholder="${placeHolderName}"></td>
                </c:forEach>
                <th>
                    <button type="submit" class="btnEdit"></button>
                </th>
            </tr>
        </form>
        </tbody>
    </table>
</div>
</body>
</html>
