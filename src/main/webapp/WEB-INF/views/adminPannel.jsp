<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.09.2019
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin pannel</title>
</head>
<body>
<h1>admin</h1>

<form:form method="post" modelAttribute="adminData">
    Admin Name: <form:input path="name" />
    <form:errors path="name" cssClass="error" /><br/>
    Admin Surname: <form:input path="surname" />
    <form:errors path="surname" cssClass="error" /><br/>
    Admin Email: <form:input path="email" />
    <form:errors path="email" cssClass="error" /><br/>
    <input type="submit" value="Save">
</form:form>

<a href="/admin/pannel">Dane Administratora</a><br>




</body>
</html>
