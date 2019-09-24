<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 12.09.2019
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizyty</title>
</head>
<body>
<h1>Historia użytkownika ${user.username}</h1>
<c:forEach items="${visits}" var="item">
<table>
    <tr><td>Termin wizyty:<c:out value="${item.visitData}"/></td></tr>
    <tr><td>Dane Klienta: <c:out value="${item.client.name} ${item.client.surname}"/></td></tr>
    <tr><td>Dane Fizjoterapeuty <c:out value="${item.physiotherapist.name} ${item.physiotherapist.surname}"/></td></tr>
    <tr><td>Metoda leczenia <c:out value="${item.treatment.name}"/></td></tr>
    <tr><td>Cena <c:out value="${item.treatment.price}"/></td></tr>
    <tr><td>Potwierdzenie wizyty <br>
        <c:if test="${item.confirm==true}">
            <c:out value="Wizyta zostala Potwierdzona"/>
        </c:if>
        <c:if test="${item.confirm!=true}">
            <c:out value="WIzyta oczekuje na potiwerdzenie "/>
        </c:if>
        </td></tr>

</table>
    <hr>
</c:forEach>
</body>
</html>
