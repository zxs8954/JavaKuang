<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-26
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<%--定制错误页面--%>
<%--<%@ page errorPage="error/500.jsp" %>--%>

<head>
    <title>Title</title>
</head>
<body>
<%

    int x=1/1;

%>
<h1>2</h1>
<%--取出参数--%>
名字：<%=request.getParameter("name")%>
年龄：<%=request.getParameter("age")%>



















</body>
</html>
