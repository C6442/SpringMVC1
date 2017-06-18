<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaogan
  Date: 6/10
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allUser</title>
</head>
<body>
<div>

    <div class="message-header"><span></span>&nbsp;所有用户</div>
    request:${requestScope.message}
    <p>${user.uid}:${user.uname}</p>
    <c:forEach items="${requestScope.userList}" var="item">
        <li><span>${item.uid}</span>:${item.uname}:${item.uage}<a href="/user/delete?uid=${item.uid}">删除</a></li>
    </c:forEach>

    <div>
        <form action="login" method="post">
            <div class="">
                uid&nbsp;
                <input type="text" name="uid" value="${user.uid}" required>
            </div>
            <div class="">
                姓名&nbsp;
                <input type="text" name="uname" required>
            </div>
            <div class="">
                年龄&nbsp;
                <input type="text" name="uage" required>
            </div>
            <button type="submit">立即登录</button>
        </form>
    </div>
</div>

</body>
</html>
