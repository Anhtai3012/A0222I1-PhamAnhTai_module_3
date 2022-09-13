<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>List</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="row">
    <div class="col-md-1 col-lg-1">

    </div>
    <div class="col-md-10 col-lg-10">
        <table class="table table-striped table-dark">
            <tr>
                <th>No.</th>
                <th>ID House</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Date</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.number}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.dateCreate}"/></td>
                    <td>${item.address}</td>
                    <td>
                        <a href="/household?action=edit&&id=${item.id}"><i class="fa-solid fa-wrench"></i></a>
                        <a href="/household?action=info&&id=${item.id}"><i class="fa-solid fa-circle-info"></i></a>

                        <!-- Button trigger modal -->
                        <a type="button" class="btn btn-danger" onclick="listName('${item.listNamePeople}')"
                           data-bs-toggle="modal" data-bs-target="#exampleModalCenter">
                            <i class="fa-solid fa-info"></i>
                        </a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
    <div class="col-md-1 col-lg-1">

    </div>
</div>

<c:if test="${max_page != null}">
    <div>
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${max_page}" var="item">
                <li class="page-item"><a class="page-link"
                                         href="household?action=display&&offset=${item-1}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">List People</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
               <span>List Customer live: </span> <span id="name_list"></span>
            </div>
        </div>
    </div>
</div>
<script>
    function listName(name) {
        console.log(name);
        if(name === ""){
            document.getElementById("name_list").innerText = "No People live in here"
            return;
        }
        document.getElementById("name_list").innerHTML = name;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>
