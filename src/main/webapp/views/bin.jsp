<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 11/06/2019
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
</head>
<body>
<jsp:include page="components/navbar.jsp" />
<div class="container bin-container">
    <div class="row">
        <div class="col-lg-3 home-card-container">
            <div class="card bin-card" style="width: 18rem;">
                <img class="card-img-top home-card__img" src="static/img/example.jpg" alt="Card image cap" height="200px" width="50px">
                <div class="card-body">
                    <h5 class="card-title">Headphone X</h5>
                    <h6 class="item-preview__price">900grn</h6>
                    <p class="card-text">Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers...</p>
                    <a href="/item/1" class="btn btn-primary mr-2">See more</a>
                    <button type="button" class="btn btn-raised btn-primary ml-5">
                        <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-lg-3 home-card-container">
            <div class="card bin-card" style="width: 18rem;">
                <img class="card-img-top home-card__img" src="static/img/example.jpg" alt="Card image cap" height="200px" width="50px">
                <div class="card-body">
                    <h5 class="card-title">Headphone X</h5>
                    <h6 class="item-preview__price">900grn</h6>
                    <p class="card-text">Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers...</p>
                    <a href="/item/1" class="btn btn-primary mr-2">See more</a>
                    <button type="button" class="btn btn-raised btn-primary ml-5">
                        <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-lg-3 home-card-container">
            <div class="card bin-card" style="width: 18rem;">
                <img class="card-img-top home-card__img" src="static/img/example.jpg" alt="Card image cap" height="200px" width="50px">
                <div class="card-body">
                    <h5 class="card-title">Headphone X</h5>
                    <h6 class="item-preview__price">900grn</h6>
                    <p class="card-text">Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers...</p>
                    <a href="/item/1" class="btn btn-primary mr-2">See more</a>
                    <button type="button" class="btn btn-raised btn-primary ml-5">
                        <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-lg-3 home-card-container">
            <div class="card bin-card" style="width: 18rem;">
                <img class="card-img-top home-card__img" src="static/img/example.jpg" alt="Card image cap" height="200px" width="50px">
                <div class="card-body">
                    <h5 class="card-title">Headphone X</h5>
                    <h6 class="item-preview__price">900grn</h6>
                    <p class="card-text">Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers...</p>
                    <a href="/item/1" class="btn btn-primary mr-2">See more</a>
                    <button type="button" class="btn btn-raised btn-primary ml-5">
                        <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-lg-3 home-card-container">
            <div class="card bin-card" style="width: 18rem;">
                <img class="card-img-top home-card__img" src="static/img/example.jpg" alt="Card image cap" height="200px" width="50px">
                <div class="card-body">
                    <h5 class="card-title">Headphone X</h5>
                    <h6 class="item-preview__price">900grn</h6>
                    <p class="card-text">Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers...</p>
                    <a href="/item/1" class="btn btn-primary mr-2">See more</a>
                    <button type="button" class="btn btn-raised btn-primary ml-5">
                        <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-lg-3 home-card-container">
            <div class="card bin-card" style="width: 18rem;">
                <img class="card-img-top home-card__img" src="static/img/example.jpg" alt="Card image cap" height="200px" width="50px">
                <div class="card-body">
                    <h5 class="card-title">Headphone X</h5>
                    <h6 class="item-preview__price">900grn</h6>
                    <p class="card-text">Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers...</p>
                    <a href="/item/1" class="btn btn-primary mr-2">See more</a>
                    <button type="button" class="btn btn-raised btn-primary ml-5">
                        <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container bin-container justify-content-center mt-4">
    <div class="totoal-price">
        Total price of order is 3000grn
    </div>
</div>
<div class="container bin-container mt-4">
    <form action="" class="payment-form">
        <div class="row">
            <div class="form-group col-lg-6">
                <label for="cardNumber">Card number</label>
                <input id="cardNumber" type="text" class="form-control" name="card_number" required minlength="16" maxlength="16" placeholder="Card number">
            </div>
            <div class="form-group col-lg-6">
                <label for="cardHolderName">Card Holder Name</label>
                <input id="cardHolderName" type="text" class="form-control" name="card_holder_name" placeholder="Example: John Doe" minlength="3" maxlength="50" required>
            </div>
            <div class="form-group col-lg-6">
                <label for="cvv">CVV</label>
                <input id="cvv" type="text" class="form-control" name="cvv" required maxlength="3" minlength="3" placeholder="123">
            </div>
            <div class="form-group col-lg-3">
              <label for="expiry_year">Expiry year</label>
              <input id="expiry_year" type="text" class="form-control" name="expiry_year" required maxlength="4" minlength="4" placeholder="Expiry year">
            </div>
            <div class="form-group col-lg-3">
                <label for="Expiry_mounth">Expiry mounth</label>
                <input id="Expiry_mounth" type="text" class="form-control" name="Expiry_mounth" required maxlength="3" minlength="3" placeholder="Expiry mounth">
            </div>
        </div>

        <button class="btn btn-raised btn-danger text-center" type="submit">Pay now</button>
    </form>
</div>


<%@ include file="components/footer.jsp" %>
</body>
</html>
