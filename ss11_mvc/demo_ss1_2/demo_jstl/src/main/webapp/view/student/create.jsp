<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 8/19/2022
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Thêm mới</h1>
<a href="/student">Quay lai trang list</a>
<c:if test="${mess!=null}">
    <p style="color: red">${mess}</p>
</c:if>
<form action="/student?action=create" method="post">
    <pre>ID:       <input type="text" name="id"/></pre>
    <pre>Name:     <input type="text" name="name"> </pre>
    <pre>Gender :  <input type="radio" name="gender" value="true">Nam <input type="radio" value="false" name="gender"> Nữ </pre>
    <pre>Birthday: <input type="date" name="birthday"> </pre>
    <pre>Point:    <input type="number" name="point"> </pre>
     <c:if test="${error!=null}">
         <span style="color: red">${error.get("point")}</span>
     </c:if>
    <pre>Account:  <input type="text" name="account"> </pre>
    <pre>Email:    <input type="text" name="email"> </pre>
    <c:if test="${error!=null}">
        <span style="color: red">${error.get("email")}</span>
    </c:if>
    <pre>ClassId:  <input type="number" name="classId"></pre>
    <pre>           <button>Save</button></pre>
</form>
</body>
</html>
