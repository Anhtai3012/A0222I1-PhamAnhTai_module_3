<%@ page import="product.mvc.models.Produce" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/13/2022
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
    <style>
        .card {
            position: fixed;
            left: 40%;
        }

        .backButton {
            position: relative;
            left: 5%;
        }

    </style>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<% Produce produce = (Produce) request.getAttribute("produce");%>

<div class="card" style="width: 18rem;">
    <form method="post">
        <h1>Info <%=produce.getNameProduce()%>
        </h1>
        <div class="card-body">
            <h5 class="card-title"><%=produce.getNameProduce()%>
            </h5>
            <p class="card-text"><%=produce.getNameProduce()%> in manufacturer is <%=produce.getManufacturer()%> is very
                good in school
                life.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">ID <input name="id" value="<%=produce.getId()%>" readonly>
            </li>
            <li class="list-group-item">Price <%=produce.getPrice()%>
            </li>
            <li class="list-group-item">Other <%=produce.getOther()%>
            </li>
        </ul>
        <div class="card-body">
            <a href="/list" style="text-decoration: none">
                <button class="btn btn-danger"> Delete</button>
            </a>
        </div>
    </form>
    <a href="/list" class="backButton">
        <button class="btn btn-warning">Back list</button>
    </a>
</div>
</body>
</html>
