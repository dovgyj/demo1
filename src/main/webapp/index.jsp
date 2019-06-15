<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>store</title>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
        <link rel="stylesheet" href="/static/css/app.css">
    </head>
    <body>
    <jsp:include page="views/components/navbar.jsp" />


        <div class="mt-2">
            <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2 col-md-4 mt-3">
                    <div class="list-group">
<%--                        <a href="#" class="list-group-item list-group-item-action active">--%>
<%--                            All--%>
<%--                        </a>--%>
                        <a href="#" class="list-group-item list-group-item-action categories__item">
                            Headphones
                        </a>
                        <a href="#" class="list-group-item list-group-item-action categories__item">Tablets</a>
                        <a href="#" class="list-group-item list-group-item-action categories__item">Mobile phones</a>
                        <a href="#" class="list-group-item list-group-item-action categories__item">Laptops</a>
                    </div>
                </div>
                <div class="col-lg-10 col-md-8">
                    <div class="row">
                        <div class="col-lg-3 home-card-container">
                            <div class="card" style="width: 18rem;">
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
                            <div class="card" style="width: 18rem;">
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
                            <div class="card" style="width: 18rem;">
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
                            <div class="card" style="width: 18rem;">
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
                            <div class="card" style="width: 18rem;">
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
                            <div class="card" style="width: 18rem;">
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
            </div>
        </div>
            <nav class="mt-4">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active">
                        <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>

        <%@ include file="views/components/footer.jsp" %>
    </body>
</html>
