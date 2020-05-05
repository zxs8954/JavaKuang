<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-27
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库我们才能使用--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<hr>
<h4>if测试</h4>
<form action="coreif.jsp" method="get">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" name="登录">
</form>




<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="欢迎登录"/>
</c:if>
<c:out value="${isAdmin}"/>
</body>
</html>
