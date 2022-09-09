<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 26/08/2022
  Time: 6:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Country</th>
    <th>Actions</th>
</tr>
    <tr>
    <td>${search.id}</td>
    <td>${search.getName()}</td>
    <td>${search.getEmail()}</td>
    <td>${search.getCountry()}</td>
    </tr>
</table>
</body>
</html>
