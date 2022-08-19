<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 19/08/2022
  Time: 6:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple calculator</h1>
  <form action="/calculator" method="post">
    <fieldset>
      <legend>Calculator</legend>
      <label>First operand:</label>
      <input type="text" width="100px" name="first">
      <br>
      <label>Operator:</label>
      <select name="operator" id="">
        <option value="Addition">Addition</option>
        <option value="Subtraction">Subtraction</option>
        <option value="Multiplication">Multiplication</option>
        <option value="Division">Division</option>
      </select>
      <br>
      <label>Second operand:</label>
      <input type="text" width="100px" name="second">
      <br>
     <button>Click</button>
    </fieldset>
  </form>
  </body>
</html>
