<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1><%= "Calculator Simple!" %>
</h1>
<br/>
<form action="/calculator" method="post">
    <h3>First operand</h3>
    <label>
        <input type="number" placeholder="Number 1" name="value1">
    </label>
    <h3>Operator</h3>
    <label>
        <select name="selectCalculator">
            <option value="+">addition</option>
            <option value="-">subtraction</option>
            <option value="*">multiplication</option>
            <option value="/">division</option>
        </select>
    </label>
    <h3>Second operand</h3>
    <label>
        <input type="number" placeholder="Number 2" name="value2">
    </label>
    <LABEL>
    <input type="submit" value="calculator">
    </LABEL>
</form>
</body>
</html>