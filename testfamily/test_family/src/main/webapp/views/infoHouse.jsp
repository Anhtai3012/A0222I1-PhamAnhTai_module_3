<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script src="bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
<c:choose>
    <c:when test="${empty list}">
        <h1>Not People Live in Here</h1>
        <a href="/household">
            <button class="btn btn-info" type="button">back</button>
        </a>

    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-md-1 col-lg-1">

            </div>
            <div class="col-md-10 col-lg-10">
                <table class="table table-striped table-dark">
                    <tr>
                        <th>
                            Name people
                        </th>
                        <th>
                            CMND
                        </th>
                        <th>
                            Birthday
                        </th>
                    </tr>
                    <c:forEach items="${list}" var="item">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.cmnd}</td>
                            <td>${item.birthday}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <th>
                            <a href="/household">
                                <button class="btn btn-success" type="button">back</button>
                            </a>
                        </th>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>

    </c:otherwise>
</c:choose>
</body>
</html>
