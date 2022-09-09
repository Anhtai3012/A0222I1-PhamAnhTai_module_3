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
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
        .card {
            position: fixed;
            left: 40%;
        }
    </style>
</head>
<body>
<% Produce produce = (Produce) request.getAttribute("produce");%>

<div class="card" style="width: 18rem;">
    <h1>Info <%=produce.getNameProduce()%></h1>
    <a href="/list">
        <button class="btn btn-light">Back list</button>
    </a>
    <div class="card-body">
        <h5 class="card-title"><%=produce.getNameProduce()%>
        </h5>
        <p class="card-text"><%=produce.getNameProduce()%> in manufacturer is <%=produce.getManufacturer()%> is very good in school life.</p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">ID <%=produce.getId()%>
        </li>
        <li class="list-group-item">Price <%=produce.getPrice()%>
        </li>
        <li class="list-group-item">Other <%=produce.getOther()%>
        </li>
    </ul>
</div>
</body>
</html>
