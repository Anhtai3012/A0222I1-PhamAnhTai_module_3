<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/21/2022
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/insert-sandwich" name="condiment">
    <fieldset>
        <legend>Sandwich</legend>
        <table>
            <tr>
                <td><input type="checkbox" name="lettuce">Lettuce</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="tomato">Tomato</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="mustard">Mustard</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="sprouts">Sprouts</td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
<c:if test="${message!=null}">
    <h1>${message}</h1>
</c:if>
</body>
</html>
