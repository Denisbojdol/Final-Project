<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 13.09.2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Harmonogram</title>
</head>
<body>
<c:forEach items="${Visits}" var="item">
    <table>
        <tr>
            <td>Termin wizyty:<c:out value="${item.visitData}"/></td>
        </tr>
        <tr>
            <td>Dane Klienta: <c:out value="${item.client.name} ${item.client.surname}"/></td>
        </tr>
        <tr>
            <td>Dane Fizjoterapeuty <c:out value="${item.physiotherapist.name} ${item.physiotherapist.surname}"/></td>
        </tr>
        <tr>
            <td>Metoda leczenia <c:out value="${item.treatment.name}"/></td>
        </tr>

    </table>
</c:forEach>

</body>
</html>
