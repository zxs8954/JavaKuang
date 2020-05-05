<%@ page import="com.kuang.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-27
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="People" class="com.kuang.pojo.People" scope="page"/>
<jsp:setProperty name="People" property="address" value="杭州"/>
<jsp:setProperty name="People" property="name" value="张雪松"/>
<jsp:setProperty name="People" property="id" value="1"/>
<jsp:setProperty name="People" property="age" value="28"/>
姓名：<jsp:getProperty name="People" property="name"/>
年龄：<jsp:getProperty name="People" property="age"/>
地址：<jsp:getProperty name="People" property="address"/>
ID：<jsp:getProperty name="People" property="id"/>


</body>
</html>
