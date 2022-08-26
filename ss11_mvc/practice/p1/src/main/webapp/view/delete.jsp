<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 22/08/2022
  Time: 6:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/customers">BACK TO CUSTOMER list</a>
</p>
<form action="" method="post">
    <h3>Aer you sure?</h3>
    <fieldset>
        <legend>Customer infomation</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${customer.getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${customer.getEmail()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${customer.getAddress()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customers">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
