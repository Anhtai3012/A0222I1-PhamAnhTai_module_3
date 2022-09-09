<%@ page import="models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/26/2022
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="/form/Form.css">
</head>
<body>
<header>
    List User
</header>
<% List<User> lists = (List<User>) request.getAttribute("list"); %>
<table class="table table-borderless">
    <tr>
        <td colspan="2">
            <a href="/list?action=insert">
                <button class="btn btn-primary">Insert new User</button>
            </a>
        </td>
        <td>
            <form method="get" action="/list">
                <input type="hidden" name="action" value="searchByCountry" />
                <label>
                    <input type="Text" id="country" name="country" placeholder="Country want search">
                </label>
                <button type="submit" class="btn btn-success">Search</button>
            </form>
        </td>
        <td>
            <a href="/list?action=display">
                <button class="btn btn-dark">Sort by Id</button>
            </a>
        </td>
        <td>
            <a href="/list?action=orderByName">
                <button class="btn btn-dark">Sort by Name</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Country</td>
        <td>Action</td>
    </tr>
    <c:forEach items="<%= lists %>" var="item">
        <tr>
            <td><c:out value="${item.id}"></c:out></td>
            <td><c:out value="${item.name}"></c:out></td>
            <td><c:out value="${item.email}"></c:out></td>
            <td><c:out value="${item.country}"></c:out></td>
            <td>
                <a href="/list?action=delete&&id=${item.id}" style="text-decoration: none">
                    <button class="btn btn-danger">delete</button>
                </a>
                <a href="/list?action=update&&id=${item.id}" style="text-decoration: none">
                    <button class="btn btn-warning">update</button>
                </a>
                <a href="/list?action=showInfo&&id=${item.id}" style="text-decoration: none">
                    <button class="btn btn-info">Info</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
