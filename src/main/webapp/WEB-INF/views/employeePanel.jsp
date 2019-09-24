<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 12.09.2019
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fizjoterapeuta</title>
</head>
<body>

<h1>Pracownik: ${employee.name}</h1>
<c:forEach items="${visits}" var="item">
    <table>
        <tr><td>Termin wizyty:<c:out value="${item.visitData}"/></td></tr>
        <tr><td>Dane Klienta: <c:out value="${item.client.name} ${item.client.surname}"/></td></tr>
        <tr><td>Metoda leczenia <c:out value="${item.treatment.name}"/></td></tr>

        <tr>
            <td>
            <c:if test="${item.confirm==false}">
                <p>czy potwierdzasz wizyte?</p>
                <form method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" name="id" value="${item.id}" />
                    <label>Potwierdzam wizytę
                    <input type="checkbox" name="confirm" value="true" />
                    </label>
                    <input type="submit" value="Zatwierdź">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </form>
            </c:if>
            <c:if test="${item.confirm==true}">
                <c:out value="Wizyta potwierdzona"/>
                <form method="post" action="/employee/raport" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" name="id" value="${card.id}" />
                    <label>Raport fizjoterapeuty
                        <textarea name="desciption">

                        </textarea>
                    </label>
                    <input type="submit" value="Zatwierdź">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </form>
            </c:if>
            </td>

        </tr>
    </table>
</c:forEach>
<%--<form:form method="post" modelAttribute="visitData">--%>

<%--    Data wizyty: <form:input path="visitData"/>--%>
<%--    <form:errors path="visitData" cssClass="error"/><br/>--%>
<%--    Wybierz fizjoterapeure <form:select path="physiotherapist" items="${physiotherapist}" itemValue="id"--%>
<%--                                        itemLabel="name"/>--%>
<%--    <br>--%>
<%--    Wybierz metode leczenia <form:select path="treatment" items="${treatment}" itemValue="id" itemLabel="name"/>--%>
<%--    <br>--%>
<%--    <input type="submit" value="Save">--%>

</body>
</html>
