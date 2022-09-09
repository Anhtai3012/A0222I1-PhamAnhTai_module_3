<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/13/2022
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
        div {
            position: fixed;
            left: 40%;
            border: 5px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
<div>
    <h1>Add new produce</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
        </p>
    <a href="/list">
        <button class="btn btn-dark">Back List</button>
    </a>
    <form method="post">
        <table>
            <tr>
                <td>
                    No.
                </td>
                <td>
                    <label>
                        <input type="number" required name="id" placeholder="So thu tu">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Produce name
                </td>
                <td>
                    <label>
                        <input type="text" required name="nameProduce" placeholder="Name Produce">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Price
                </td>
                <td>
                    <label>
                        <input type="number" required name="price" placeholder="Price">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Other
                </td>
                <td>
                    <label>
                        <input type="text" required name="other" placeholder="Status and other">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Manufacturer
                </td>
                <td>
                    <label>
                        <input type="text" required name="manufacturer" placeholder="Manufacturer">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create New">
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
