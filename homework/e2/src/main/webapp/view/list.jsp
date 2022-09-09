<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 05/09/2022
  Time: 7:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
<style>
    table{
        /*border-radius: 10px;*/
        /*!*background-color: black;*!*/
        /*!*font-size: medium;*!*/
        /*!*font-family: "Times New Roman";*!*/
        /*!*color: white;*!*/
        /*width: 80%;*/
    }
</style>
<body>
<center>
    <h1>List Household</h1>
    <h1>
        <a href="/household?action=create" class="btn btn-info btn-lg">
            <span class="glyphicon glyphicon-plus"></span> Add New
        </a>
    </h1>
<table id="example" class="table table-striped table-bordered" style="border-radius:10px ;width: 80%" >
    <tr>
        <th>STT</th>
        <th>id</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Start Day Household</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="household" items="${list}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${household.id}</td>
            <td>${household.name}</td>
            <td>${household.quantity}</td>
            <td>${household.startDayHouseHold}</td>
            <td>${household.address}</td>
            <td>
                <a href="/household?action=edit&id=${household.id}"><button type="button" class="btn btn-primary">Edit</button></a>
                <a href="/household?action=view&id=${household.id}"><button type="button" class="btn btn-warning">View</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</center>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script src="table.js"></script>
</html>
