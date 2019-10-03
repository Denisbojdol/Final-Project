<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.09.2019
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/login">Logowanie</a><br>
<a href="/register">Rejestracja</a><br>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/admin/main">Panel Administratora</a><br>
</sec:authorize>

<sec:authorize access="hasRole('USER')">
    <a href="/user/panel">Panel Użytkownika</a><br>
</sec:authorize>

<sec:authorize access="hasAnyRole('USER','ADMIN','DOCTOR')">
    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>


</body>
</html>
