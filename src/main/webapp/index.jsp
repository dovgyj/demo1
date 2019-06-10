<html>
    <head>
        <title>store</title>
        <link rel="stylesheet" href="css/app.css">
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="http://localhost:9090/">Demo1.com</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:9090/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
            </form>
            <%--                <div class="dropdown">--%>
            <%--                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
            <%--                        Dropdown button--%>
            <%--                    </button>--%>
            <%--                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">--%>
            <%--                        <a class="dropdown-item" href="#">Action</a>--%>
            <%--                        <a class="dropdown-item" href="#">Another action</a>--%>
            <%--                        <a class="dropdown-item" href="#">Something else here</a>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
        </div>
        <ul class="navbar-nav nav-login-links">
            <li class="nav-item">
                <a href="" class="nav-link nav-link-shopping-basket">
                    <i class="fas fa-shopping-basket"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:9090/login">Sign in <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link sign-up-link" href="http://localhost:9090/register">Sign up</a>
            </li>
        </ul>
    </nav>
        <div class="mt-2">
            <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2 col-md-4 mt-3">
                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action active">
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
                                <img class="card-img-top home-card__img" src="img/example.jpg" alt="Card image cap" height="200px" width="50px">
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
                                <img class="card-img-top home-card__img" src="img/example.jpg" alt="Card image cap" height="200px" width="50px">
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
                                <img class="card-img-top home-card__img" src="img/example.jpg" alt="Card image cap" height="200px" width="50px">
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
                                <img class="card-img-top home-card__img" src="img/example.jpg" alt="Card image cap" height="200px" width="50px">
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
                                <img class="card-img-top home-card__img" src="img/example.jpg" alt="Card image cap" height="200px" width="50px">
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
                                <img class="card-img-top home-card__img" src="img/example.jpg" alt="Card image cap" height="200px" width="50px">
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
        <div class="footer">
            <div class="footer__contacts">
               <span class="footer__heading mb-2">
                 Contacts
               </span>
                <div class="footer__contact">
                    <i class="fas fa-phone footer__icon"></i>
                    <a href="tel:+380666264915" class="footer__contact-link ml-1">+380666264915</a>
                </div>
                <div class="footer__contact">
                    <i class="fas fa-envelope footer__icon"></i>
                    <a href="mailto:a.dovgyj@gmail.com" class="footer__contact-link ml-1">a.dovgyj@gmail.com</a>
                </div>
            </div>
        </div>
        <script src="js/app.js"></script>
        <script src="https://kit.fontawesome.com/1b4c0b7880.js"></script>
    </body>
</html>
