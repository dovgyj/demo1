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
    <h1 class="text-center mt-5">Order successfully done!</h1>
    <div class="row mt-4 justify-content-center">
        <c:forEach var="item" items="${order.itemList}">
            <div class="col-lg-3 home-card-container m-4">
                <div class="card" style="width: 18rem;">
                    <c:if test="${item.img != null}">
                        <img class="card-img-top home-card__img" src="<c:out value="data:image/jpg;base64,${item.img}"></c:out>" alt="Card image cap" height="200px" width="50px">
                    </c:if>
                    <c:if test="${item.img == null}">
                        <img class="card-img-top home-card__img" src="${pageContext.request.contextPath}/static/img/default.jpg" alt="Card image cap" height="200px" width="50px">
                    </c:if>
                    <div class="card-body">
                        <h5 class="card-title home-card__title">
                            <c:out value="${item.title}"></c:out>
                        </h5>
                        <h6 class="item-preview__price">
                            <c:out value="${item.price}"></c:out> UAN
                        </h6>
                        <p class="card-text home-card__text">
                            <c:out value="${item.description}"></c:out>
                        </p>
                        <a href="/item/<c:out value="${item.id}"></c:out>" class="btn btn-primary mr-2">See more</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@ include file="components/footer.jsp"%>
</body>
</html>
