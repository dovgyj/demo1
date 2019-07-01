<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 11/06/2019
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"
          integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
</head>
<body>
<jsp:include page="components/navbar.jsp"/>
<div class="content">
    <div class="container bin-container">
        <c:if test="${orderBin.isEmpty()}">
            <h1 class="text-center mt-4">Empty bin</h1>
            <div class="container justify-content-center" style="display: flex;">
                <img src="${pageContext.request.contextPath}/static/img/emptybin.png" style="width: 60%;"
                     class="text-center mt-5">
            </div>
        </c:if>

        <c:if test="${orderBin.isNotEmpty()}">
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
                            <a href="/bin/remove/<c:out value="${item.id}"></c:out>" type="button" class="btn btn-raised btn-danger ml-5">
                                <i class="fas fa-trash-alt item__shopping-basket-icon"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="container bin-container justify-content-center mt-4">
        <div class="totoal-price">
            Total price of order is <c:out value="${orderBin.getTotalprice()}"></c:out>grn
        </div>
    </div>
    <div class="container bin-container mt-4">
        <form action="<c:out value="${pageContext.request.contextPath}/order/make"></c:out>" method="post" class="payment-form">
            <div class="row">
                <div class="form-group col-lg-6">
                    <label for="cardNumber" class="ml-3">Card number</label>
                    <input id="cardNumber" type="text" class="form-control" name="card_number" required minlength="16"
                           maxlength="16" placeholder="Card number">
                </div>
                <div class="form-group col-lg-6">
                    <label for="cardHolderName" class="ml-3">Card Holder Name</label>
                    <input id="cardHolderName" type="text" class="form-control" name="card_holder_name"
                           placeholder="Example: John Doe" minlength="3" maxlength="50" required>
                </div>
                <div class="form-group col-lg-6">
                    <label for="cvv" class="ml-3">CVV</label>
                    <input id="cvv" type="text" class="form-control" name="cvv" required maxlength="3" minlength="3"
                           placeholder="123">
                </div>
                <div class="form-group col-lg-3">
                    <label for="expiry_year" class="ml-3">Expiry year</label>
                    <input id="expiry_year" type="text" class="form-control" name="expiry_year" required maxlength="4"
                           minlength="4" placeholder="Expiry year">
                </div>
                <div class="form-group col-lg-3">
                    <label for="Expiry_mounth" class="ml-3">Expiry mounth</label>
                    <input id="Expiry_mounth" type="text" class="form-control" name="Expiry_mounth" required maxlength="3"
                           minlength="3" placeholder="Expiry mounth">
                </div>
            </div>

            <button class="btn btn-raised btn-danger text-center" type="submit">Pay now</button>
        </form>
        </c:if>
    </div>
</div>



<%@ include file="components/footer.jsp" %>
</body>
</html>
