<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/18
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<style>
    h2 {
        color: red;
    }
</style>
<body>
<h1><%=request.getSession().getAttribute("name") + ",欢迎你！"%>
</h1>
<h2>加载中...</h2>
</body>
</html>
