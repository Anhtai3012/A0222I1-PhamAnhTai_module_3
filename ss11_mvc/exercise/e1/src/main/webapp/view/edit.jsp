<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 23/08/2022
  Time: 11:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit ProductList</h1>
<p>
    <a href="/products">Back to Product List</a>
</p>
<p>
    <c:if test="${message!=null}">
        <span>${message}</span>
    </c:if>
</p>
<form action="" method="post">
    <pre>ID:       <input type="text" name="id" value="${product.getId()}"/></pre>
    <pre>Name:     <input type="text" name="name" value="${product.getName()}"></pre>
    <pre>Price :  <input type="text" name="price" value="${product.getPrice()}"></pre>
    <pre>Describe: <input type="text" name="describe" value="${prodcut.getDescribe()}"></pre>
    <pre>Brand:    <input type="text" name="brand" value="${product.getBrand()}"></pre>
    <pre>Submit: <input type="submit" value="Update"></pre>
</form>
</body>
</html>
