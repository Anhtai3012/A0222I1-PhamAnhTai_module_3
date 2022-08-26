<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/22/2022
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table border="1" style="border-radius: 10px">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>status</th>
        <th>manufacturer</th>
        <th>action</th>
    </tr>
    <c:forEach var="product" items="${list}" varStatus="name">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.status}</td>
            <td>${product.manufacturer}</td>
            <td>
                <a href="/produces?action=edit&id=${product.id}"><button>Edit</button></a>
                <a href="/produces?action=delete&id=${product.id}"><button>Delete</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/produces?action=create"><button>Create New</button></a>
</body>
</html>
