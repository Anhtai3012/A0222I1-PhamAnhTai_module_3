<%@ page import="com.call_sp.User" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/1/2022
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <% User user = (User) request.getAttribute("user");%>
    <table>
        <tr>
            <td>ID</td>
            <td><input type="number" name="id" value="<%=user.getId()%>" readonly>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<%=user.getName()%>" required>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" value="<%=user.getEmail()%>" required>
            </td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country" value="<%=user.getCountry()%>" required>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
              <a href="/hello-servlet?action=all"><button type="button">Back List</button></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
