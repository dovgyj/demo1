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
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link rel="stylesheet" href="static/css/app.css">
</head>
<body class="bg-green">
<jsp:include page="components/navbar.jsp" />

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
<script src="static/js/app.js"></script>
<script src="https://kit.fontawesome.com/1b4c0b7880.js"></script>
</body>
</html>
