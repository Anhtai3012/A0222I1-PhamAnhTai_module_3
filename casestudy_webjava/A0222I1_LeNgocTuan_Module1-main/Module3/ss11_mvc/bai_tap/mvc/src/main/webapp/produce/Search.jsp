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
    <title>Search</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .main{
            position: fixed;
            left: 40%;
        }
    </style>
</head>
<body>
<div class="main">
    <h1>Search By Name</h1>
    <a href="/list">
        <button class="btn btn-light">Back list</button>
    </a>

    <div class="search">
        <form method="post">
            <table>
                <tr>
                    <td>
                        Name
                    </td>
                    <td>
                        <label>
                            <input type="text" name="nameSearch" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Search"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
        </form>
    </div>
    <% if ("true".equalsIgnoreCase((String) request.getAttribute("find"))) {%>
    <div class="result">
        <% Produce produce = (Produce) request.getAttribute("result"); %>
        <% if (produce == null) { %>
        <p>Not Found by name is <%=request.getAttribute("name")%>
        </p>
        <% } else {%>
        <table class="table table-primary">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name Produce</th>
                <th scope="col">Price</th>
                <th scope="col">Other</th>
                <th scope="col">Manufacturer</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%= produce.getId()%>
                </td>
                <td><%= produce.getNameProduce()%>
                </td>
                <td><%= produce.getPrice()%>
                </td>
                <td><%= produce.getOther()%>
                </td>
                <td><%= produce.getManufacturer()%>
                </td>
            </tr>
            </tbody>
        </table>
        <%}%>
        <%}%>
    </div>
</div>
</body>
</html>
