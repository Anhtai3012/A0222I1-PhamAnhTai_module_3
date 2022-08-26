<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 22/08/2022
  Time: 6:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List Product</h1>
<p><a href="/products?action=create">Create new Product</a></p>
<table border="1" style="border-radius: 10px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Describe</th>
        <th>Brand</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="product" items="${products}" varStatus="status">
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}}">${product.getId()}</a></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.describe}</td>
            <td>${product.brand}</td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
