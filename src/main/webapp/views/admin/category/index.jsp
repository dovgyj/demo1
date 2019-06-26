<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 16/06/2019
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DashBoard</title>
    <link rel="stylesheet"
          href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"
          integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
</head>
<body>
<jsp:include page="../../components/admin/navbar.jsp"/>
<div class="container">
    <h1>Categories</h1>
    <a href="${pageContext.request.contextPath}/admin/category/create" class="btn btn-success">add new category</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}"  var="category">
            <tr>
                <td><c:out value="${category.id}"></c:out></td>
                <td><c:out value="${category.name}"></c:out></td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/category/update/<c:out value="${category.id}"></c:out>" class="btn btn-primary btn-sm">edit</a>
                    <a href="${pageContext.request.contextPath}/admin/category/delete/<c:out value="${category.id}"></c:out>" class="btn btn-danger btn-sm">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
        integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
        integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
        crossorigin="anonymous"></script>
<script>$(document).ready(function () {
    $('body').bootstrapMaterialDesign();
});</script>
<script src="https://kit.fontawesome.com/1b4c0b7880.js"></script>
</body>
</html>
