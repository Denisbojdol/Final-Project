<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 12.09.2019
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="visitData">

    Data wizyty: <form:input path="visitData" />
    <form:errors path="visitData" cssClass="error" /><br/>
    <form:select path="physiotherapist" items="${physiotherapist}" itemValue="id" itemLabel="name"/>
    <form:select path="treatment" items="${treatment}" itemValue="id" itemLabel="name"/>

    <input type="submit" value="Save">



</form:form>




<%--<form:form method="post" modelAttribute="officeData">--%>
<%--    Open: <form:checkbox path="open" />--%>
<%--    <form:errors path="open" cssClass="error" /><br/>--%>
<%--    Begin: <form:input path="begin" />--%>
<%--    <form:errors path="begin" cssClass="error" /><br/>--%>
<%--    End: <form:input path="end" />--%>
<%--    <form:errors path="end" cssClass="error" /><br/>--%>
<%--    <input type="submit" value="Save">--%>
<%--</form:form>--%>

<%--<c:forEach items="${plan}" var="item">--%>
<%--    <tr>--%>
<%--        <td><c:out value="${item.open}"/></td>--%>
<%--        <td><c:out value="${item.begin}"/></td>--%>
<%--        <td><c:out value="${item.end}"/></td>--%>
<%--        <td><a href="selectvisit/${item.id}"/>zapisz wizyte</td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>

</body>
</html>
