<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>store</title>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
    </head>
    <body>
    <jsp:include page="components/navbar.jsp" />


        <div class="mt-2 content">
            <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2 col-md-4 mt-3">
                    <div class="list-group">
                        <c:forEach var="category" items="${categories}">
                            <a href="/category/${category.alias}" class="list-group-item list-group-item-action categories__item ">
                                <c:out value="${category.name}"/>
                            </a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-10 col-md-8">
                    <div class="row">
                        <c:forEach var="item" items="${items}">
                            <div class="col-lg-3 home-card-container">
                                <div class="card" style="width: 18rem;">
                                    <c:if test="${item.img != null}">
                                        <img class="card-img-top home-card__img" src="<c:out value="data:image/jpg;base64,${item.img}"></c:out>" alt="Card image cap" height="200px" width="50px">
                                    </c:if>
                                    <c:if test="${item.img == null}">
                                        <img class="card-img-top home-card__img" src="${pageContext.request.contextPath}/static/img/default.jpg" alt="Card image cap" height="200px" width="50px">
                                    </c:if>
                                    <div class="card-body">
                                        <h5 class="card-title">
                                            <c:out value="${item.title}"></c:out>
                                        </h5>
                                        <h6 class="item-preview__price">
                                            <c:out value="${item.price}"></c:out>grn
                                        </h6>
                                        <p class="card-text">
                                            <c:out value="${item.description}"></c:out>
                                        </p>
                                        <a href="/item/<c:out value="${item.id}"></c:out>" class="btn btn-primary mr-2">See more</a>
                                        <c:if test="${orderBin.contains(item)}">
                                            <button type="button" class="btn btn-raised btn-success ml-5 add-shoping-basket-button" data-item-id="<c:out value="${item.id}"></c:out>" data-in-bin="true">
                                                <i class="fas fa-check-circle item__shopping-basket-icon"></i>
                                            </button>
                                        </c:if>
                                        <c:if test="${!orderBin.contains(item)}">
                                            <button type="button" class="btn btn-raised btn-primary ml-5 add-shoping-basket-button" data-item-id="<c:out value="${item.id}"></c:out>">
                                                <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                                            </button>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
<%--            <nav class="mt-4">--%>
<%--                <ul class="pagination justify-content-center">--%>
<%--                    <li class="page-item disabled">--%>
<%--                        <a class="page-link" href="#" tabindex="-1">Previous</a>--%>
<%--                    </li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                    <li class="page-item active">--%>
<%--                        <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>--%>
<%--                    </li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                    <li class="page-item">--%>
<%--                        <a class="page-link" href="#">Next</a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </nav>--%>
        </div>

        <%@ include file="components/footer.jsp" %>
    <script src="${pageContext.request.contextPath}/static/js/bin.js"></script>
    </body>
</html>
