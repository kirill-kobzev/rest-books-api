<%--
  Created by IntelliJ IDEA.
  User: m.biryukov
  Date: 22.10.2018
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="book" items="${books}">
    <TR>
        <TD>${book.id}</TD>
        <TD>${book.name}</TD>
        <TD>${book.author.fio}</TD>
    </TR>
    </c:forEach>
</body>
</html>