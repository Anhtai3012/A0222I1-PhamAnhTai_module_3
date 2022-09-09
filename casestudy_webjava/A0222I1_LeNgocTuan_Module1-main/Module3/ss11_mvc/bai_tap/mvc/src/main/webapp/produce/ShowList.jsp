<%@ page import="product.mvc.models.Produce" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/13/2022
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Produce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<h1>Produce manager</h1>
<table class="table table-success table-striped">
    <tr>
        <td colspan="3">
            <i class="fa-solid fa-cart-plus"></i>
            <a href="/list?action=create">
                <button class="btn btn-primary">Create new produce</button>
            </a>
        </td>
        <td colspan="3">
            <i class="fa-solid fa-magnifying-glass-plus"></i>
            <a href="/list?action=search">
                <button class="btn btn-primary">Search produce</button>
            </a>
        </td>
    </tr>
    <tr>
        <th>No.</th>
        <th>Name Produce</th>
        <th>Price</th>
        <th>Other</th>
        <th>Manufacturer</th>
        <th>Action</th>
    </tr>
    <tbody>
    <% List<Produce> list = (List<Produce>) request.getAttribute("list");%>
    <tr>
            <% for (Produce produce : list) {%>
    <tr>
        <td><%=produce.getId()%>
        </td>
        <td><%=produce.getNameProduce()%>
        </td>
        <td><%=produce.getPrice()%>
        </td>
        <td><%=produce.getOther()%>
        </td>
        <td><%=produce.getManufacturer()%>
        </td>
        <td>
            <a href="/list?action=delete&&id=<%=produce.getId()%>" style="text-decoration: none">
                <button class="btn btn-danger">delete</button>
            </a>
            <a href="/list?action=edit&&id=<%=produce.getId()%>" style="text-decoration: none">
                <button class="btn btn-warning">edit</button>
            </a>
            <a href="/list?action=view&&id=<%=produce.getId()%>" style="text-decoration: none">
                <button class="btn btn-info">info</button>
            </a>
        </td>
    </tr>
    <% }
        ;%>
    </tbody>
</table>
</body>
</html>
