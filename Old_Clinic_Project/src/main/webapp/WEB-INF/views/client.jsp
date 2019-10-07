<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 12.09.2019
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.username}</title>
</head>
<body>

<table>
    <tr>
        <th>Dni Pracujace</th>
        <th>Pracujemy Od</th>
        <th>Do</th>
    </tr>
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

    <form:form method="post" modelAttribute="visitData">

        Data wizyty: <form:input path="visitData"/>
        <form:errors path="visitData" cssClass="error"/><br/>
        Wybierz fizjoterapeure <form:select path="physiotherapist" items="${physiotherapist}" itemValue="id"
                                            itemLabel="name"/>
        <br>
        Wybierz metode leczenia <form:select path="treatment" items="${treatment}" itemValue="id" itemLabel="name"/>
        <br>
        <input type="submit" value="Save">

    </form:form>
</table>


</body>
</html>
