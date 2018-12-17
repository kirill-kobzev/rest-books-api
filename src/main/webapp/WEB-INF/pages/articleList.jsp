<%--
  Created by IntelliJ IDEA.
  User: Кирилл
  Date: 16.12.2018
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Привет1111
<table>
    <c:forEach var="article" items="${articles}">
        <TR>
            <TD>${article.id}</TD>
            <TD>${article.name}</TD>
        </TR>
    </c:forEach>
</table>
</body>
</html>
