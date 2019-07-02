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
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
</head>
<body class="bg-light-gray">
<jsp:include page="components/navbar.jsp"/>

<div class="mt-2">
    <div class="container-fluid content">
        <div class="row">
            <div class="col-lg-2 col-md-4 mt-1">
                <div class="list-group">
                    <c:forEach var="category" items="${categories}">
                        <c:if test="${category == item.category}">
                            <a href="/category/${category.alias}" class="list-group-item list-group-item-action active">
                                <c:out value="${category.name}"></c:out>
                            </a>
                        </c:if>
                        <c:if test="${category != item.category}">
                            <a href="/category/${category.alias}" class="list-group-item list-group-item-action categories__item">
                                <c:out value="${category.name}"></c:out>
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="col-lg-10 col-md-8">
                <div class="row mt-2">
                    <div class="col-lg-4">
                        <c:if test="${item.img != null}">
                            <img class="img-thumbnail item-img m-auto" src="<c:out value="data:image/jpg;base64,${item.img}"></c:out>" alt="Card image cap" >
                        </c:if>
                        <c:if test="${item.img == null}">
                            <img class="img-thumbnail item-img m-auto" src="${pageContext.request.contextPath}/static/img/default.jpg" alt="Card image cap" >
                        </c:if>
                    </div>
                    <div class="col-lg-8">
                        <div class="item">
                            <div class="item__title"><c:out value="${item.title}"></c:out></div>
                            <div class="item__description mt-2">
                                <c:out value="${item.description}"></c:out>
                            </div>
                            <div class="item__price mt-3">
                                <c:out value="${item.price}"></c:out> UAH
                            </div>
                            <div class="item__controls mt-3">
                                <button type="button" class="btn btn-raised btn-primary">
                                    <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                                </button>
                                <a href="/bin/add/<c:out value="${item.id}"></c:out>" class="btn btn-raised btn-danger ml-1" >Buy</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
</body>
</html>