<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Digitalstore.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
        <c:if test="${!Auth.guest()}">
            <a href="${pageContext.request.contextPath}/bin" class="nav-link nav-link-shopping-basket" id="nav-basket-link">
                <i class="fas fa-shopping-basket"></i>
                <c:if test="${orderBin.isNotEmpty()}">
                    <span class="badge badge-primary badge-pill shoping-basket-badge" id="shoping-basket-counter">
                        <c:out value="${orderBin.count()}"></c:out>
                    </span>
                </c:if>
            </a>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${Auth.user.name}
                </button>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/logout">Login out</a>
                </div>
            </div>
        </c:if>

    </div>
    <c:if test="${Auth.guest()}">
        <ul class="navbar-nav nav-login-links">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/bin" class="nav-link nav-link-shopping-basket" id="nav-basket-link">
                    <i class="fas fa-shopping-basket"></i>
                    <c:if test="${orderBin.isNotEmpty()}">
                    <span class="badge badge-primary badge-pill shoping-basket-badge" id="shoping-basket-counter">
                        <c:out value="${orderBin.count()}"></c:out>
                    </span>
                    </c:if>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Sign in <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link sign-up-link" href="${pageContext.request.contextPath}/register">Sign up</a>
            </li>
        </ul>
    </c:if>

</nav>
