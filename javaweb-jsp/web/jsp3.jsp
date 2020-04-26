<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-26
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@include会将2个页面合二为一--%>
<%@include file="common/header.jsp" %>
<h1>网页主体</h1>
<%@include file="common/footer.jsp" %>
<hr>
<%--        jsp标签--%>
<jsp:include page="common/header.jsp">


</body>
</html>