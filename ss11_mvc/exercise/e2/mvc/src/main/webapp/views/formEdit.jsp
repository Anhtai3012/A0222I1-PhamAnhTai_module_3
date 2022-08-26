<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 8/19/2022
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> ${link}</h1>
<a href="/produces">Quay lai trang list</a>
<c:if test="${mess!=null}">
    <p style="color: red">${mess}</p>
</c:if>
<form action="/produces?action=${link}" method="post">
    <pre>ID:              <input type="number" name="id" value="${product.id}"></pre>
    <pre>Name:            <input type="text" name="name" value="${product.name}"> </pre>
    <pre>Price :          <input type="number" name="price" min="0" value="${product.price}" ></pre>
    <pre>Status:          <input type="text" name="status" value="${product.status}"> </pre>
    <pre>Manufacturer:    <input type="text" name="manufacturer" value="${product.manufacturer}"> </pre>
    <pre>                 <button type="submit">Save</button>       <button type="reset">Reset</button></pre>
</form>
</body>
</html>
