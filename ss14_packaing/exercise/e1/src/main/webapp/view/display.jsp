<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 05/09/2022
  Time: 1:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quadratic Equation</h1>
<h1>ax^2+bx+c</h1>
<form action="/display" method="get">
    <table>
        <tr>
            <th>a:</th>
            <td><input type="number" name="a"></td>
        </tr>
        <tr>
            <th>b:</th>
            <td><input type="number" name="b"></td>
        </tr>
        <tr>
            <th>c:</th>
            <td><input type="number" name="c"></td>
        </tr>
        <tr>
            <th>
                <button type="submit">Result</button>
            </th>
        </tr>
    </table>
</form>
<c:if test="${messenger !=null}">
    <h6>${messenger}</h6>
</c:if>
<c:if test="${result !=0}">
    <h6>${result}</h6>
</c:if>
<c:if test="${result1 != 0 && result2 !=0}">
    <span>x1:</span><span>${result1}</span><br>
    <span>x2:</span><span>${result2}</span>
</c:if>
</body>
</html>
