<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 05/09/2022
  Time: 8:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<center>
    <h1>Create</h1>
    <h3>
        <a href="/household">
            <button type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-home"></span> Home
            </button>
        </a>
    </h3>
    <c:if test="${messenger !=null}">
        <h3 style="color: red">${messenger}</h3>
    </c:if>
    <form method="post" onsubmit="validRoom(event)">
        <table border="1" style="border-radius: 10px">
            <tr>
                <th>ID</th>
                <td><input type="text" name="id" size="35"></td>
            </tr>
            <tr>
                <th>NAME</th>
                <td>
                    <input type="text" id="name" name="name" size="35">
                    <p id="errorName" style="color: red;display: none ">Name is not empty</p>
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td><input type="text" name="quantity" size="35"></td>
            </tr>
            <tr>
                <th>Start day household</th>
                <td><input type="text" name="date" size="35"></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" size="35"></td>
            </tr>
            <tr>
                <th><button type="submit">Add</button></th>
            </tr>
        </table>
    </form>
</center>


<script>
    <c:if test="${listError.size() >0}">
    document.getElementById('errorName').style.display = "block";
  <%--//  alert('${listError.get('name')}');--%>
    document.getElementById('errorName').innerHTML = '${listError.get('name')}';
    </c:if>
    function validRoom(event) {
        // let hasError = false;
        // const name = document.getElementById('name').value;
        // if(name === ''){
        //     document.getElementById('errorName').style.display = "block";
        //     hasError = true
        // }
        //
        // if(hasError === true){
        //     event.preventDefault();
        // }
    }
</script>
</body>
</html>
