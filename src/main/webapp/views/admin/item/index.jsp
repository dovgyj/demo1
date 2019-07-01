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
    <h1 class="text-center mt-4">Items</h1>
    <a href="${pageContext.request.contextPath}/admin/item/create" class="btn btn-outline-success">add new item</a>
    <table class="table table-bordered mt-3">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Title</th>
            <th>Description</th>
            <th>Price</th>
            <th>Img</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="item">
            <tr>
                <td><c:out value="${item.id}"></c:out></td>
                <td><c:out value="${item.category.name}"></c:out></td>
                <td><c:out value="${item.title}"></c:out></td>
                <td><c:out value="${item.description}"></c:out></td>
                <td><c:out value="${item.price}"></c:out></td>
                <td>
                    <c:if test="${item.img != null}">
                        <img src="data:image/jpg;base64,${item.img}" width="100px">
                    </c:if>
                    <c:if test="${item.img == null}">
                        <img src="${pageContext.request.contextPath}/static/img/default.jpg" width="100px">
                    </c:if>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/item/update/<c:out value="${item.id}"></c:out>"
                       class="btn btn-outline-primary btn-sm mr-3">edit</a>
                    <a href="${pageContext.request.contextPath}/admin/item/delete/<c:out value="${item.id}"></c:out>"
                       class="btn btn-outline-danger btn-sm">delete</a>
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
