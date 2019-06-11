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
    <link rel="stylesheet" href="http://localhost:9090/css/app.css">
</head>
<body class="bg-light-gray">
<jsp:include page="components/navbar.jsp"/>

<div class="mt-2">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-md-4 mt-1">
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
                <div class="row mt-2">
                    <div class="col-lg-4">
                        <img src="http://localhost:9090/img/example.jpg" class="img-thumbnail item-img m-auto" alt="">
                    </div>
                    <div class="col-lg-8">
                        <div class="item">
                            <div class="item__title">Headphone X</div>
                            <div class="item__description mt-2">
                                Smaller headphones, often called earbuds or earphones, are placed inside the outer part of your ear canal. Like speakers, headphones contain transducers that convert an audio signal into sound waves. Headphones that connect to an analog audio port (such as a 3.5 mm audio jack) process analog audio.
                            </div>
                            <div class="item__price mt-3">
                                900grn
                            </div>
                            <div class="item__controls mt-3">
                                <button type="button" class="btn btn-raised btn-primary">
                                    <i class="fas fa-shopping-basket item__shopping-basket-icon"></i>
                                </button>
                                <button class="btn btn-raised btn-danger ml-1" data-toggle="modal" data-target="#exampleModal">Buy</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">
                     <b>Headphone X</b> - 900grn
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="" class="mb-0">
                    <div class="form-group">
                        <label for="send_address_input">Address to send</label>
                        <input type="text" class="form-control" placeholder="Address to send" name="send_address" id="send_address_input" required minlength="5" maxlength="200">
                    </div>
                    <div class="form-group">
                        <label for="additional_information_input">Additional information</label>
                        <textarea name="additional_information" class="form-control" id="additional_information_input" cols="10" rows="10" placeholder="Additional information"></textarea>
                    </div>
                    <button type="submit" class="btn btn-raised btn-danger">Make order</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
            </div>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>--%>
<%--                <button type="button" class="btn btn-primary">Make order</button>--%>
<%--            </div>--%>
        </div>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
</body>
</html>