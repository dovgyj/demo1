<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrej
  Date: 10/06/2019
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error occured</title>
</head>
<body>
<h2>Error occured</h2>
<h4>
    <c:out value="${error}">
</h4>
</body>
</html>