<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script src="bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-1 col-lg-1">

    </div>
    <div class="col-md-10 col-lg-10">
        <section class="vh-100 bg-image"
                 style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <h2 class="text-uppercase text-center mb-5">Form Control</h2>
                                    <c:if test="${message != null}">
                                        <h3 style="color:red;">${message}</h3>
                                    </c:if>
                                    <form method="post">
                                        <div class="form-outline mb-4">
                                            <input type="text" id="form2Example1cg" value="${produce.id}" name="id"
                                                   class="form-control form-control-lg" readonly/>
                                            <label class="form-label" for="form2Example1cg">Name</label>
                                        </div>                                        <div class="form-outline mb-4">
                                            <input type="text" id="form3Example1cg" value="${produce.name}" name="name"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example1cg">Name</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('name')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="number" id="form3Example3cg" value="${produce.number}"
                                                   name="number" readonly
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example3cg">Number</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('number')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="date" id="form3Example4cg" value="${produce.dateCreate}"
                                                   name="dateCreate"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example4cg">dateCreate</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('dateCreate')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="text" id="form3Example5cdg" value="${produce.address}"
                                                   name="address"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example5cdg">address</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('address')}</h5>
                                            </c:if>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                                                Submit
                                            </button>
                                            <button type="reset"
                                                    class="btn btn-warning btn-block btn-lg gradient-custom-4 text-body">
                                                Reset
                                            </button>
                                            <a href="/household">
                                                <button type="button"
                                                        class="btn btn-info btn-block btn-lg gradient-custom-4 text-body">
                                                    Back List
                                                </button>
                                            </a>
                                        </div>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <div class="col-md-1 col-lg-1">

    </div>
</div>
</body>
</html>
