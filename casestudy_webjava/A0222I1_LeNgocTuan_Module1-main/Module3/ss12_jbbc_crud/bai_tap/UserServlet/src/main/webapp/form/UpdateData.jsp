<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/26/2022
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="/form/Form.css">
</head>
<body>
<header>Update User</header>
<nav>
    <form method="post">
        <table>
            <tr class="data">
                <% User user = (User) request.getAttribute("user"); %>
                <td>
                    Id
                </td>
                <td>
                    <input type="text" name="id" value="<%=user.getId()%>" readonly>
                </td>
            </tr>
            <tr class="data">
                <td>
                    Name
                </td>
                <td>
                    <input type="text" name="name" value="<%=user.getName()%>" required>
                </td>
            </tr>
            <tr class="data">
                <td>
                    Email
                </td>
                <td>
                    <input type="email" name="email" value="<%=user.getEmail()%>" required>
                </td>
            </tr>
            <tr class="data">
                <td>
                    Country
                </td>
                <td>
                    <input type="text" name="country" value="<%=user.getCountry()%>" required>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update">
                </td>
                <td>
                    <input type="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form>
</nav>
<aside>
    <c:if test="${requestScope[message] != null}">
        <span>${requestScope["message"]}</span>
    </c:if>
</aside>
<footer>
    <div>
        <a href="/list">
            <button class="btn btn-secondary"> Back List</button>
        </a>
    </div>
</footer>
</body>
</html>