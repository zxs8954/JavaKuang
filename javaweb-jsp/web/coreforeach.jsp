<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 89546
  Date: 2020-04-27
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    ArrayList<String> people=new ArrayList<String>();
    people.add(0,"zxs");
    people.add(1,"lisi");
    request.setAttribute("list",people);
%>

<c:forEach var="people" items="${list}">
    <c:out value="${people}"/>
</c:forEach>

</body>
</html>
