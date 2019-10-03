<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 01.10.2019
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
<form:form method="post" modelAttribute="doctorDTO">
    <div><label> User Email : <form:input path="email" type="text" name="email"/> </label></div>
    <form:errors path="email" cssClass="error" />
    <div><label> User Name : <form:input path="name" type="text" name="name"/> </label></div>
    <form:errors path="name" cssClass="error" />
    <div><label> User Surname : <form:input path="surname" type="text" name="surname"/> </label></div>
    <form:errors path="surname" cssClass="error" />
    <input type="submit" value="Save">
</form:form>
</div>
<table>
    <tr>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${doctorList}" var="doctor">

        <tr>
            <td><c:out value="${doctor.name}"/></td>
            <td><c:out value="${doctor.surname}"/></td>
            <td><c:out value="${doctor.email}"/></td>
            <td><a href="/admin/doctorDelete/${doctor.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
