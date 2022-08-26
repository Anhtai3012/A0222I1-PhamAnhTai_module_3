<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 23/08/2022
  Time: 9:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new Product</h1>
<%--<p>--%>
<%--    <c:if test="${message}!=null">--%>
<%--        <span>${message}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<p><a href="/products">Back to ProductList</a></p>
<form action="" method="post">
    <pre>ID:       <input type="text" name="id"/></pre>
    <pre>Name:     <input type="text" name="name"></pre>
    <pre>Price :  <input type="text" name="price"></pre>
    <pre>Describe: <input type="text" name="describe"></pre>
    <pre>Brand:    <input type="text" name="brand"></pre>
    <pre>Submit: <input type="submit" value="Create Product"></pre>
</form>
</body>
</html>
