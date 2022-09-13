<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 06/09/2022
  Time: 10:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>
        <a href="/household">
            <button type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-home"></span> Home
            </button>
        </a>
    </h1>
<c:if test="${messenger != null}">
    <h3 style="color: red">${messenger}</h3>
</c:if>
    <form action="" method="post">
<table border="1" style="border-radius: 10px">
    <tr>
        <th>
            <label >ID</label>
            <input disabled name="id" value="${houseHold.getId()}">
        </th>
    </tr>
    <tr>
        <th>
            <label >Name:</label>
            <input type="text" name="name" value="${houseHold.getName()}" size="35">
        </th>
    </tr>
    <tr>
        <th>
            <label >Quantity:</label>
            <input type="text" disabled name="quantity" value="${houseHold.getQuantity()}" size="35">
        </th>
    </tr>
    <tr>
        <th>
            <label >Start Day Household</label>
            <input type="text" name="date" value="${houseHold.getStartDayHouseHold()}" size="35">
        </th>
    </tr>
    <tr>
        <th>
            <label>Address</label>
            <input type="text" name="address" value="${houseHold.getAddress()}" size="35">
        </th>
    </tr>
    <tr>
        <th>
            <input type="submit" value="Save">
        </th>
    </tr>
</table>
    </form>
</center>
</body>
</html>
