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
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
<center>
    <h1>List Household</h1>
    <h1>
        <a href="/household?action=create" class="btn btn-info btn-lg">
            <span class="glyphicon glyphicon-plus"></span> Add New
        </a>
    </h1>
    <h6>
        <form action="/household" method="get">
            <label>Search Name</label>
            <input hidden name="action" value="search">
            <input type="search" name="search" size="10">
            <input type="submit">
        </form>
    </h6>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width: 100%" >
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>id</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Start Day Household</th>
                        <th>Address</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
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
                    </tbody>
                </table>

            </div>
        </div>
    </div>
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#tableStudent').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            } );
        } );
    </script>
</center>
</body>
</html>
