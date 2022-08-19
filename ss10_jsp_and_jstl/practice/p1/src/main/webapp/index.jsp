<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 19/08/2022
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="converter.jsp" method="post">
    <label> Rate:</label>
    <br>
    <input type="text" name="rate" placeholder="Rate" value="22000">
    <br>
    <label> USD:</label>
    <br>
    <input type="text" name="usd" placeholder="USD" value="0">
    <br>
    <input type="submit"  value="converter">
  </form>
  </body>
</html>
