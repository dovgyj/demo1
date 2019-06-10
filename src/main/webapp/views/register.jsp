<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 09/06/2019
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/app.css">
</head>
<body class="bg-green">
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

<form class="login-form">
    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" placeholder="Enter name" required minlength="2">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" class="form-control" id="password1" placeholder="Password" required minlength="6">
    </div>
    <div class="form-group">
        <label for="password2">Confirm password</label>
        <input type="password" class="form-control" id="password2" placeholder="Password confirmation" required minlength="6">
    </div>

    <button type="submit" class="btn btn-outline-primary mt-3">Register</button>
</form>
<script src="js/app.js"></script>
<script src="https://kit.fontawesome.com/1b4c0b7880.js"></script>
</body>
</html>
