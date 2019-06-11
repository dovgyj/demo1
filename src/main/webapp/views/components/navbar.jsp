<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Demo1.com</a>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/login">Sign in <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link sign-up-link" href="${pageContext.request.contextPath}/register">Sign up</a>
        </li>
    </ul>
</nav>
