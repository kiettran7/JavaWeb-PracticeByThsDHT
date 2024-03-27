<%-- 
    Document   : index
    Created on : Mar 27, 2024, 12:39:14 PM
    Author     : admin
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
        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">E-cormmerce Website</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Home</a>
                            </li>
                            <c:forEach items="${categories}" var="c">
                                <li class="nav-item">
                                    <a class="nav-link" href="#">${c.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class="row justify-content-md" style="padding-top: 12px;">
            <c:forEach items="${products}" var="p"> 
                <div class="card m-2" style="width: 20%;">
                    <img class="card-img-top" src="${p.image}" alt="${p.name}">
                    <div class="card-body">
                        <h4 class="card-title">${p.name}</h4>
                        <p class="card-text">${p.manufacturer}</p>
                        <a href="/" class="btn btn-primary">See Details</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <footer></footer>
    </body>
</html>
