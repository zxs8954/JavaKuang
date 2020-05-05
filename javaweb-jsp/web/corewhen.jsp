<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-27
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="score" value="85"/>
<c:choose>
    <c:when test="${score>=90}">
        优秀1
    </c:when>
    <c:when test="${score>=85}">
        优秀2
    </c:when>
    <c:when test="${score>=60}">
        优秀24
    </c:when>
    <c:when test="${score==90}">
        优秀3
    </c:when>
</c:choose>


</body>
</html>
