<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 12.09.2019
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmien czas</title>
</head>
<body>

<form:form method="post" modelAttribute="time">
    Open: <form:checkbox path="open" />
    <form:errors path="open" cssClass="error" /><br/>
    Begin: <input type="time" name="">
    End: <form:input path="end" />
    <form:errors path="end" cssClass="error" /><br/>
    <input type="submit" value="Save">
</form:form>


</body>
</html>
