<%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-27
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$


  <h1>当前有<span style="color: red"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>人在线</h1>
  </body>
</html>
