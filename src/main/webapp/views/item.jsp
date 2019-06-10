<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 10/06/2019
  Time: 03:02
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="http://localhost:9090/">Demo1.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="http://localhost:9090/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <%--                <div class="dropdown">--%>
        <%--                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
        <%--                        Dropdown button--%>
        <%--                    </button>--%>
        <%--                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">--%>
        <%--                        <a class="dropdown-item" href="#">Action</a>--%>
        <%--                        <a class="dropdown-item" href="#">Another action</a>--%>
        <%--                        <a class="dropdown-item" href="#">Something else here</a>--%>
        <%--                    </div>--%>
        <%--                </div>--%>
    </div>
    <ul class="navbar-nav nav-login-links">
        <li class="nav-item">
            <a class="nav-link" href="http://localhost:9090/login">Sign in <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link sign-up-link" href="http://localhost:9090/register">Sign up</a>
        </li>
    </ul>
</nav>
<div class="mt-2">
    <div class="row">
        <div class="col-lg-2 col-md-4">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action active">
                    Cras justo odio
                </a>
                <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>
                <a href="#" class="list-group-item list-group-item-action">Morbi leo risus</a>
                <a href="#" class="list-group-item list-group-item-action">Porta ac consectetur ac</a>
                <a href="#" class="list-group-item list-group-item-action">Vestibulum at eros</a>
            </div>
        </div>
        <div class="col-lg-10 col-md-8">
            <div class="row">
                <div class="col-lg-5">
                    <img src="${pageContext.request.contextPath}/img/example.jpg" class="img-thumbnail item__img" alt="">
            </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container"></div>
</div>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>