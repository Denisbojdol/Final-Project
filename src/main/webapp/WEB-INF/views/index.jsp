<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 10.09.2019
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gabinet Fizjoterapi</h1>

<a href="/login">Logowanie</a><br>
<a href="/register">Rejestracja</a><br>

<sec:authorize access="hasRole('USER')">
    <a href="user/panel">Panel Klienta</a><br>
    <a href="user/edit">Dane Klienta</a><br>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a href="/admin/page">Panel Administratora</a><br>
</sec:authorize>




<%--<form>--%>
<%--    Enter a date before 1980-01-01:--%>
<%--    <input type="date" name="bday" max="1979-12-31"><br>--%>
<%--    Enter a date after 2000-01-01:--%>
<%--    <input type="date" name="bday" min="2000-01-02"><br>--%>
<%--</form>--%>
</body>
</html>
