<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.09.2019
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj Fizjoterapeute</title>
</head>
<body>
<form:form method="post" modelAttribute="physiotherapistData">
    Physiotherapist Name: <form:input path="name" />
    <form:errors path="name" cssClass="error" /><br/>
    Physiotherapist Surname: <form:input path="surname" />
    <form:errors path="surname" cssClass="error" /><br/>
    Physiotherapist Email: <form:input path="email" />
    <form:errors path="email" cssClass="error" /><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
