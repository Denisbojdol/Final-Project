<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 01.10.2019
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator</title>
</head>
<body>
<p>Witaj ${admin.username}</p>

<div>

</div>
<div>
    <table>
        <tr>
            <td><a href="/admin/doctor">Dodaj Lekarza</a><br></td>
        </tr>
        <tr>
            <td><a href="/admin/edit">Edytuj dane Administratora</a></td>
        </tr>
        <tr>
            <td><a href="/admin/workTime">Godziny otwarcia </a></td>
        </tr>

    </table>
</div>

</body>
</html>
