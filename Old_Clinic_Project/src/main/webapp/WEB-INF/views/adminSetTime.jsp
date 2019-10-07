<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.09.2019
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Time</title>
</head>
<body>

<form:form method="post" modelAttribute="officeData">
    Open: <form:checkbox path="open" />
    <form:errors path="open" cssClass="error" /><br/>
    Begin: <form:input path="begin" />
    <form:errors path="begin" cssClass="error" /><br/>
    End: <form:input path="end" />
    <form:errors path="end" cssClass="error" /><br/>
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
        <td><a href="/admin/workTime/${item.id}">Edytuj</a> </td>
        <td><a href="/admin/workTimeDelete/${item.id}">Usun</a> </td>
    </tr>
</c:forEach>
</table>

</body>
</html>
