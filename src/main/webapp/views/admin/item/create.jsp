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
    <h1 class="text-center mt-4">Create item</h1>
    <form class="" method="post" action="${pageContext.request.contextPath}/admin/item/create" enctype="multipart/form-data">
        <div class="form-group">
            <label for="category">Category</label>
            <select name="categories_id" id="category" required class="form-control">
                <c:forEach items="${categories}" var="category">
                    <option value="<c:out value="${category.id}"></c:out>">
                        <c:out value="${category.name}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Title</label>
            <input type="text" name="title" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter title" required minlength="3" maxlength="60">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" name="price" class="form-control" id="price" aria-describedby="emailHelp"
                   placeholder="Enter price" required minlength="3" maxlength="60">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea name="description" id="description" class="form-control" cols="30" rows="10" required></textarea>
        </div>
        <div class="form-group">
            <label for="img">Img</label>
            <input type="file" class="form-control" name="img" id="img">
        </div>
        <button type="submit" class="btn btn-outline-primary mt-3">create</button>
    </form>
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
