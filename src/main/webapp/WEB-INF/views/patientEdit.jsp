<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 03.10.2019
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="patientDTO">
    Admin Name: <form:input path="name" />
    <form:errors path="name" cssClass="error" /><br/>
    Admin Surname: <form:input path="surname" />
    <form:errors path="surname" cssClass="error" /><br/>
    Admin Email: <form:input path="email" />
    <form:errors path="email" cssClass="error" /><br/>
    <input type="submit" value="Save">
</form:form>


</body>
</html>
