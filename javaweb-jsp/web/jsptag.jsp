<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-27
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1</h1>
<jsp:forward page="/jsp2.jsp">
    <jsp:param name="name" value="zxs"></jsp:param>
    <jsp:param name="age" value="28"></jsp:param>
</jsp:forward>



</body>
</html>
