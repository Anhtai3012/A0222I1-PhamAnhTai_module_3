<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 29/08/2022
  Time: 6:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>List Product</h1>
<h4>
    <a href="/products?action=create">Add new</a>
</h4>
    <form action="/products?action=search" method="post">
        <label>Search Name:</label>
        <input type="search" name="searchName">
        <button type="submit">Submit</button>
    </form>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Color</th>
        <th>Quantity</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    <c:forEach var="product" items="${list}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.color}</td>
            <td>${product.quantity}</td>
            <c:forEach var="cate" items="${category}">
                <c:if test="${product.category == cate.id}">
                    <td>${cate.name}</td>
                </c:if>
            </c:forEach>
            <td>
                <a href="/products?action=delete&id=${product.id}"><Button>delete</Button></a>
                <a href="/products?action=edit&id=${product.id}"><button>edit</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</center>
</body>
</html>
