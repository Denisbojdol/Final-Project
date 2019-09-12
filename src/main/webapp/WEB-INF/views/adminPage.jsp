<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.09.2019
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator</title>
</head>
<body>
<p>Witaj ${admin.id}</p>
${admin.username}
<a href="/admin/edit">Dane Administratora</a><br>
<a href="/admin/addPhy">Dodaj fizjoterapeute</a><br>
<a href="/admin/workTime">Ustal godziny pracy</a><br>




</body>
</html>
