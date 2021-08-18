<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/14
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<style>
    div {
        color: red;
    }

    a {
        color: aqua;
    }

    h1 {
        color: aqua;
    }
</style>
<script>
    window.onload = function () {
        document.getElementById("checkcodeimg").onclick = function () {
            this.src = "/study/checkCode?" + new Date().getTime()
        }
    }
</script>
<body>
<h1 style="">登录</h1>
<form action="/study/login2" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="checkcodeimg" src="/study/checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
    <a href="/study/regist.html">点击此处注册</a>
    <%--如果cc_error为空则展示空字符串--%>
    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error") %>
    </div>
    <div><%=request.getAttribute("password_error") == null ? "" : request.getAttribute("password_error")%>
    </div>

</form>
</body>
</html>
