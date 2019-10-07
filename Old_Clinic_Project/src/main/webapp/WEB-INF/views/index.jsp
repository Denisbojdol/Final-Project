<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 10.09.2019
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gabinet Fizjoterapi</h1>

<a href="/login">Logowanie</a><br>
<a href="/register">Rejestracja</a><br>
<br>

<br>
<sec:authorize access="hasRole('USER')">
    <a href="user/panel">Panel Wizyt</a><br>
    <a href="user/edit">Dane Klienta</a><br>
    <a href="user/history">Historia Klienta</a><br>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a href="/admin/page">Panel Administratora</a><br>
</sec:authorize>
<sec:authorize access="hasRole('PHYSIOTHERAPIST')">
    <a href="/employee/panel">Panel Fizjoterapeuty</a><br>
</sec:authorize>
<br>
<sec:authorize access="hasAnyRole('USER','ADMIN','PHYSIOTHERAPIST')">
    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>



<%--<form>--%>
<%--    Enter a date before 1980-01-01:--%>
<%--    <input type="date" name="bday" max="1979-12-31"><br>--%>
<%--    Enter a date after 2000-01-01:--%>
<%--    <input type="date" name="bday" min="2000-01-02"><br>--%>
<%--</form>--%>
</body>
</html>
