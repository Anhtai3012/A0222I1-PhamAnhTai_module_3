<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/22/2022
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator">
    <fieldset>
      <legend>Calculator</legend>
      <input type="number" name="var1" placeholder="value1">
      <select name="calculator">
        <option value="+">Plus</option>
        <option value="-">Minus</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
      </select>
      <input type="number" name="var2" placeholder="value2">
      <button type="submit">Result</button>
    </fieldset>
  </form>
<c:if test="${message != null}">
  <h1>${message}</h1>
</c:if>
  </body>
</html>

