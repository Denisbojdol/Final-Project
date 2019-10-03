<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 02.10.2019
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="officeDTO">
    Open: <form:checkbox path="open"/>
    <p>Otwarcie</p>
    <form:input type="time" path="begin"/>
    <br>
    <p>Zamkniecie</p>
    <form:input type="time"  path="end" />
    <br>
    <form:select path="day" items="${days}"/>

    <input type="submit" value="Save">
</form:form>
<table>

    <c:forEach items="${plan}" var="item">
        <tr>
            <td>
                <c:if test="${item.open==true}">
                    <c:out value="Otwarte"/>
                </c:if>
                <c:if test="${item.open!=true}">
                    <c:out value="Zamkniete"/>
                </c:if>

            </td>
            <td><c:out value="${item.begin}"/></td>
            <td><c:out value="${item.end}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
