<%@ page import="product.mvc.models.Produce" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/13/2022
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .div{
            position: fixed;
            left: 40%;
        }
    </style>
</head>
<body>
<div class="div">
    <h1>Edit Produce</h1>
    <a href="/list">
        <button class="btn btn-light">Back list</button>
    </a>

<% if (request.getAttribute("message") != null) { %>
<h3>Success edit</h3>
<%}%>
<% Produce produce = (Produce) request.getAttribute("produce");%>
<form method="post">
    <table>
        <tr>
            <td>
                ID Produce
            </td>
            <td>
                <input type="number" name="id" value="<%=produce.getId()%>" readonly>
            </td>
        </tr>
        <tr>
            <td>
                Name Produce
            </td>
            <td>
                <input type="text" name="nameProduce" value="<%=produce.getNameProduce()%>">
            </td>
        </tr>
        <tr>
            <td>
                Price
            </td>
            <td>
                <input type="number" name="price" value="<%= produce.getPrice()%>">
            </td>
        </tr>
        <tr>
            <td>
                Other
            </td>
            <td>
                <input type="text" name="other" value="<%= produce.getOther()%>">
            </td>
        </tr>
        <tr>
            <td>
                Manufacturer
            </td>
            <td>
                <input type="text" name="manufacturer" value="<%=produce.getManufacturer()%>">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Edit">
            </td>
            <td>
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>
</div>

</body>
</html>
