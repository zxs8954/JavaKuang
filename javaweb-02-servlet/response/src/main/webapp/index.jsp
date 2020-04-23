<html>
<body>
<h2>Hello World!</h2>

<%--这里的提交路径需要寻找到项目的路径--%>
<%--pageContext.request.contextPath代表当前项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">

    用户名：<input type="userword" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
