<%-- 
    Document   : index
    Created on : Mar 28, 2024, 9:39:26 AM
    Author     : kitj3
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">KIET'S SYSTEM</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Home</a>
                        </li>
                        <c:forEach items="${categories}" var="c">
                            <li class="nav-item">
                                <c:url value="/" var="myUrl">
                                    <c:param name="cateId" value="${c.id}" />
                                </c:url>
                                <a class="nav-link" href="${myUrl}">${c.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <form action="<c:url value="/" />" class="d-flex">
                        <input class="form-control me-2" name="kw" type="text" placeholder="Search . . .">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>

        <section class="container">
            <div style="padding-top: 1rem;">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="?page=1">1</a></li>
                    <li class="page-item"><a class="page-link" href="?page=2">2</a></li>
                    <li class="page-item"><a class="page-link" href="?page=3">3</a></li>
                </ul>
            </div>
            <div class="row">
                <c:forEach items="${products}" var="p">
                    <div class="col-md-3 col-12" style="padding: 0.7rem;">
                        <div class="card">
                            <img class="card-img-top" src="${p.image}" alt="${p.name}">
                            <div class="card-body">
                                <h4 class="card-title">${p.name}</h4>
                                <p class="card-text">${p.price} VND</p>
                                <a href="#" class="btn btn-primary">Details</a>
                                <a href="#" class="btn btn-primary">Booking</a>
                            </div>
                        </div>    
                    </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>
