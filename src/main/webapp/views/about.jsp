<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 10/06/2019
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>About</title>
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
</head>
<body class="bg-light-gray">
<jsp:include page="components/navbar.jsp"/>

<div class="container mt-3 content">
    <div class="about">
        <h1 class="about__heading mb-0">About Us</h1>
        <img src="${pageContext.request.contextPath}/static/img/team.png" class="about__img mt-0 mb-3" alt="">
        <h3 class="about__heading about__heading--small">How it works</h3>
        <p class="about__text">We do not use the phrase "documentation comments", instead using the common term ... That is, while the examples are in Google Style, they may not illustrate the only .... No line break before the opening brace. ... (Note that this is not the same practice used in Google style for other languages, such as C++ and JavaScript.).</p>
        <h3 class="about__heading about__heading--small">How it works</h3>
        <p class="about__text">We do not use the phrase "documentation comments", instead using the common term ... That is, while the examples are in Google Style, they may not illustrate the only .... No line break before the opening brace. ... (Note that this is not the same practice used in Google style for other languages, such as C++ and JavaScript.).</p>
        <h3 class="about__heading about__heading--small">How it works</h3>
        <p class="about__text">We do not use the phrase "documentation comments", instead using the common term ... That is, while the examples are in Google Style, they may not illustrate the only .... No line break before the opening brace. ... (Note that this is not the same practice used in Google style for other languages, such as C++ and JavaScript.).</p>
    </div>
</div>

<%@ include file="components/footer.jsp"%>
</body>
</html>
