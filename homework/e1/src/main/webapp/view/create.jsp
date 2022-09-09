<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 29/08/2022
  Time: 7:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>Create</h1>
    <c:if test="${create!=null}">
        <h3>
            ${create}
        </h3>
    </c:if>
<h4>
    <a href="/products">Back ListProduct</a>
</h4>
<form action="" method="post">
    <table border="1" cellpadding="5">
        <caption>
            <h2>Add New User</h2>
        </caption>
        <tr>
            <th>Name</th>
            <td>
                <input type="text" name="name" id="name" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Price</th>
            <td>
                <input type="text" name="price" id="price" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Color</th>
            <td>
                <input type="text" name="color" id="color" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Quantity</th>
            <td>
                <input type="text" name="quantity" id="quantity" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Category</th>
            <td><select name="category">
                <c:forEach var="category" items="${category}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
