<%--
  Created by IntelliJ IDEA.
  User: huangzixiao
  Date: 23/7/2022
  Time: 9:45 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--spring mvc标签库-->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    id:${user.id}<br/>
</p>
<p>
    username:${user.username}<br/>
</p>
<p>
    birthday:
<%--    ${user.birthday}<br/>--%>
    <spring:eval expression="user.birthday"></spring:eval>
</p>
<p>
    balance:
<%--    ${user.balance}<br/>--%>
    <spring:eval expression="user.balance"></spring:eval>
</p>
<p>
    salary:
<%--    ${user.salary}<br/>--%>
    <spring:eval expression="user.salary"></spring:eval>
</p>
<p>
    taskCount:
<%--    ${user.taskCount}<br/>--%>
    <spring:eval expression="user.taskCount"></spring:eval>
</p>
<p>
    hobbies:<spring:eval expression="user.hobbies"></spring:eval>
</p>
</body>
</html>
