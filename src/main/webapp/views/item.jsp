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
    <link rel="stylesheet" href="http://localhost:9090/css/app.css">
</head>
<body class="bg-light-gray">
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
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
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
            <a href="" class="nav-link nav-link-shopping-basket">
                <i class="fas fa-shopping-basket"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="http://localhost:9090/login">Sign in <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link sign-up-link" href="http://localhost:9090/register">Sign up</a>
        </li>
    </ul>
</nav>
<div class="mt-2">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-md-4 mt-1">
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action active">
                        Headphones
                    </a>
                    <a href="#" class="list-group-item list-group-item-action categories__item">Tablets</a>
                    <a href="#" class="list-group-item list-group-item-action categories__item">Mobile phones</a>
                    <a href="#" class="list-group-item list-group-item-action categories__item">Laptops</a>
                </div>
            </div>
            <div class="col-lg-10 col-md-8">
                <div class="row mt-2">
                    <div class="col-lg-5">
                        <img src="http://localhost:9090/img/example.jpg" class="img-thumbnail item-img m-auto" alt="">
                    </div>
                    <div class="col-lg-7">
                        <div class="item">
                            <div class="item__title">Headphone X</div>
                            <div class="item__description mt-2">
                                Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers, headphones contain transducers that convert an audio signal into sound waves. Headphones that connect to an analog audio port (such as a 3.5 mm audio jack) process analog audio.
                            </div>
                            <div class="item__price mt-3">
                                900grn
                            </div>
                            <div class="item__controls mt-3">

    <%--                            <button type="button" class="btn btn-primary bmd-btn-fab bmd-btn-fab-sm">--%>
    <%--                                <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>--%>
    <%--                            </button>--%>
                                <button type="button" class="btn btn-raised btn-primary">
                                    <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                                </button>
                                <button class="btn btn-raised btn-danger ml-1">Buy</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="footer__contacts">
               <span class="footer__heading mb-2">
                 Contacts
               </span>
        <div class="footer__contact">
            <i class="fas fa-phone footer__icon"></i>
            <a href="tel:+380666264915" class="footer__contact-link ml-1">+380666264915</a>
        </div>
        <div class="footer__contact">
            <i class="fas fa-envelope footer__icon"></i>
            <a href="mailto:a.dovgyj@gmail.com" class="footer__contact-link ml-1">a.dovgyj@gmail.com</a>
        </div>
    </div>
</div>
<script src="http://localhost:9090/js/app.js"></script>
<script src="https://kit.fontawesome.com/1b4c0b7880.js"></script>
</body>
</html>