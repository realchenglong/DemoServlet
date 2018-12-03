<%--
  Created by IntelliJ IDEA.
  User: ChengLong
  Date: 2018/12/2
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form method="post" action="login" id="from">
    <ul>
        <li>
            <span>请输入Email地址：</span>
            <input type="text" name="email" id="email"  >
        </li>
        <li>
            <span class="blank">密码：</span>
            <input type="password" name="password" id="password" >
        </li>
        <li>
            <input type="submit" value="登录" >
        </li>
    </ul>
</form>
</body>
</html>
