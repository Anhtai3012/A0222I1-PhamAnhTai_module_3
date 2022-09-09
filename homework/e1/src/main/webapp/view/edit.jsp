<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 03/09/2022
  Time: 3:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<center>
    <c:if test="${create!=null}">
        <h3>
                ${create}
        </h3>
    </c:if>
    <h4>
        <a href="/products">Back ListProduct</a>
    </h4>
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${listEdit!= null}">
                <input type="hidden" name="id" value="${listEdit.getId()}" />
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${listEdit.getName()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="${listEdit.getPrice()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Colour:</th>
                <td>
                    <input type="text" name="color" size="45"
                           value="${listEdit.getColor()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="45" value="${listEdit.quantity}">
                </td>
            </tr>
            <tr>
                <th>Category</th>
                <td>
                    <select name="category" >
                        <c:forEach var="cate" items="${category}">
                            <option value="${cate.id}">${cate.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><button type="submit">Save</button></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
