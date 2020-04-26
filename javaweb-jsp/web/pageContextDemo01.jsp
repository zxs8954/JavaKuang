<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-26
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
pageContext.setAttribute("name1","zxs1");//保存的数据只在一个页面有效
request.setAttribute("name2","zxs2");//保存的数据只在一次请求中有效，请求转发会携带这个数据
session.setAttribute("name3","zxs3");//保存的数据只在一次会话中有效
application.setAttribute("name4","zxs4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%
//通过pageContext取出我们保存的值
    String name1= (String) pageContext.findAttribute("name1");
    String name2= (String) pageContext.findAttribute("name2");
    String name3= (String) pageContext.findAttribute("name3");
    String name4= (String) pageContext.findAttribute("name4");
    String name5= (String) pageContext.findAttribute("name5");//不存在
%>
<%--使用el表达式输出--%>
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
</body>
</html>
