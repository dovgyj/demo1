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

    <form class="login-form" method="post" action="/login">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck1">
            <label class="custom-control-label mt-1" for="customCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-outline-primary mt-3">Submit</button>
    </form>

  <script src="static/js/app.js"></script>
  <script src="https://kit.fontawesome.com/1b4c0b7880.js"></script>
</body>
</html>
