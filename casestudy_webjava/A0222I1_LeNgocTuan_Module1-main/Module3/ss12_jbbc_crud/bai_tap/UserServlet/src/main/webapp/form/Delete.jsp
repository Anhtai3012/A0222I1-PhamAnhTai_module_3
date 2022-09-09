<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/26/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="/form/Form.css">
</head>
<body>
<header>Info User</header>

<div class="user-info-delete">
    <% User user = (User) request.getAttribute("user"); %>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Id User : <%=user.getId()%>
        </li>
        <li class="list-group-item">Name User : <%=user.getName()%>
        </li>
        <li class="list-group-item">Email User : <%=user.getEmail()%>
        </li>
        <li class="list-group-item">Country User : <%=user.getCountry()%>
        </li>
    </ul>
</div>

<div class="d-flex justify-content-center flex-column mt-5">
    <h5 class="text-center">
        Delete this USER
    </h5>
    <p>
    <div class="d-flex justify-content-center">
        <form method="POST" action="/list" class="me-3">
            <input type="hidden" name="id" value="<%=user.getId()%>"/>
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="choice" value="yes"/>
            <button class="btn btn-danger">Yes</button>
        </form>

        <form method="POST" action="/list">
            <input type="hidden" name="id" value="<%=user.getId()%>"/>
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="choice" value="no"/>
            <button class="btn btn-danger">No</button>
        </form>

    </div>

</div>
<footer>
    <div>
        <a href="/list">
            <button class="btn btn-secondary">Back List</button>
        </a>
    </div>
</footer>
</body>
</html>
