<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <th>Open</th>
    <th>begin</th>
    <th>end</th>
</tr>
<c:forEach items="${plan}" var="item">
    <tr>
        <td><c:out value="${item.open}"/></td>
        <td><c:out value="${item.begin}"/></td>
        <td><c:out value="${item.end}"/></td>
        <td><a href="selectvisit/${item.id}"/>zapisz wizyte</td>
    </tr>
</c:forEach>
</table>




</body>
</html>
