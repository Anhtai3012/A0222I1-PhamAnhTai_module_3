<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.call_sp.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/1/2022
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table>
    <% List<User> list = (List<User>) request.getAttribute("list");%>
    <c:forEach items="<%=list%>" var="item">
        <tr>
            <td><c:out value="${item.id}">${item.id}</c:out></td>
            <td><c:out value="${item.name}">${item.name}</c:out></td>
            <td><c:out value="${item.email}">${item.email}</c:out></td>
            <td><c:out value="${item.country}">${item.country}</c:out></td>
            <td><a href="#" onclick="function checkDelete() {
                let choice = confirm('Delete User');
                if (choice===true){
                    window.location.href = '/hello-servlet?action=delete&&id=${item.id}';
                }
            }
            checkDelete()">Delete</a></td>
            <td><a href="/hello-servlet?action=update&&id=${item.id}">update</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
