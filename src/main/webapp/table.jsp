<%@ page import="services.DaoService" %><%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 02.11.2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>LB1</title>
    <link href="css/table.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="outer">
    <div class="area-under-table">
        <form action="${pageContext.request.contextPath}/servlets.searchServlet" method="post">
            <div class="select-area">
                <select name="searchOption">
                    <c:forEach var="columnName" items="${columnNames}">
                        <option class="other" value="${columnName}">${columnName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="search-area">
                <input type="text" name="searchInput" class="myInput" placeholder="Search ...">
            </div>

            <div class="search-icon">
                <input type="hidden" name="tableName" value="${chosenTable}">
                <button type="submit" class="btnSearch"></button>
            </div>
        </form>
    </div>
    <table class="content-table">
        <thead>
        <tr>
            <c:forEach var="columnName" items="${columnNames}">
                <th>${columnName}</th>
            </c:forEach>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${chosenTable.equals('Client')}">
            <c:forEach var="client" items="${DaoService.clientDAO.currentObjects}" varStatus="row">
                <tr>
                    <td><c:out value="${client.firstName}"/></td>
                    <td><c:out value="${client.secondName}"/></td>
                    <td><c:out value="${client.phoneNumber}"/></td>
                    <th>
                        <form action="${pageContext.request.contextPath}/servlets.deleteServlet" method="post">
                            <input type="hidden" name="tableName" value="${chosenTable}">
                            <c:if test="${row.count % 2 != 0}">
                                <button type="submit" name="remove" value="${client.id}" class="btnRemove"></button>
                            </c:if>
                            <c:if test="${row.count % 2 == 0}">
                                <button type="submit" name="remove" value="${client.id}" class="btnRemoveG"></button>
                            </c:if>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/servlets.toEditServlet" method="post">
                            <input type="hidden" name="tableName" value="${chosenTable}">
                            <c:if test="${row.count % 2 != 0}">
                                <button type="submit" name="edit" value="${client.id}" class="btnEdit"></button>
                            </c:if>
                            <c:if test="${row.count % 2 == 0}">
                                <button type="submit" name="edit" value="${client.id}" class="btnEditG"></button>
                            </c:if>
                        </form>
                    </th>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${chosenTable.equals('Car')}">
            <c:forEach var="car" items="${DaoService.carDAO.currentObjects}" varStatus="row">
                <tr>
                    <td><c:out value="${car.carModel}"/></td>
                    <td><c:out value="${car.seats}"/></td>
                    <td><c:out value="${car.costPerDay}"/></td>
                    <th>
                        <form action="${pageContext.request.contextPath}/servlets.deleteServlet" method="post">
                            <input type="hidden" name="tableName" value="${chosenTable}">
                            <c:if test="${row.count % 2 != 0}">
                                <button type="submit" name="remove" value="${car.id}" class="btnRemove"></button>
                            </c:if>
                            <c:if test="${row.count % 2 == 0}">
                                <button type="submit" name="remove" value="${car.id}" class="btnRemoveG"></button>
                            </c:if>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/servlets.toEditServlet" method="post">
                            <input type="hidden" name="tableName" value="${chosenTable}">
                            <c:if test="${row.count % 2 != 0}">
                                <button type="submit" name="edit" value="${car.id}" class="btnEdit"></button>
                            </c:if>
                            <c:if test="${row.count % 2 == 0}">
                                <button type="submit" name="edit" value="${car.id}" class="btnEditG"></button>
                            </c:if>
                        </form>
                    </th>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${chosenTable.equals('Rent')}">
            <c:forEach var="rent" items="${DaoService.rentDAO.currentObjects}" varStatus="row">
                <tr>
                    <td><c:out value="${rent.clientId}"/></td>
                    <td><c:out value="${rent.rentCost}"/></td>
                    <td><c:out value="${rent.rentLength}"/></td>
                    <td><c:out value="${rent.rentTotal}"/></td>
                    <th>
                        <form action="${pageContext.request.contextPath}/servlets.deleteServlet" method="post">
                            <input type="hidden" name="tableName" value="${chosenTable}">
                            <c:if test="${row.count % 2 != 0}">
                                <button type="submit" name="remove" value="${rent.carId}" class="btnRemove"></button>
                            </c:if>
                            <c:if test="${row.count % 2 == 0}">
                                <button type="submit" name="remove" value="${rent.carId}" class="btnRemoveG"></button>
                            </c:if>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/servlets.toEditServlet" method="post">
                            <input type="hidden" name="tableName" value="${chosenTable}">
                            <c:if test="${row.count % 2 != 0}">
                                <button type="submit" name="edit" value="${rent.carId}" class="btnEdit"></button>
                            </c:if>
                            <c:if test="${row.count % 2 == 0}">
                                <button type="submit" name="edit" value="${rent.carId}" class="btnEditG"></button>
                            </c:if>
                        </form>
                    </th>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <c:if test="${role==1}">
        <div class="add-area">
            <table class="add-table">
                <thead>
                <tr>
                    <c:forEach var="columnName" items="${columnNames}">
                        <th>${columnName}</th>
                    </c:forEach>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <form action="${pageContext.request.contextPath}/servlets.insertServlet" method="post">
                    <input type="hidden" name="tableName" value="${chosenTable}">
                    <tr>
                        <c:forEach var="placeHolderName" items="${placeHolderNames}" varStatus="row">
                            <td><input type="text" class="myInputAdd" name="myInput${row.count}"
                                       placeholder="${placeHolderName}"></td>
                        </c:forEach>
                        <th>
                            <button type="submit" class="btnAdd"></button>
                        </th>
                    </tr>
                </form>
                </tbody>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
