<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huangzixiao
  Date: 23/7/2022
  Time: 11:08 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/user" method="post">
  <p>
    id:<input type="text" name="id">${errors.id}
  </p>
  <p>
    username:<input type="text" name="username">${errors.username}
  </p>
  <p>
    birthday:<input type="text" name="birthday">
  </p>
  <p>
    balance:<input type="text" name="balance">
  </p>
  <p>
    salary:<input type="text" name="salary">
  </p>
  <p>
    taskCount:<input type="text" name="taskCount">
  </p>
  <p>
    hobbies:
    <input type="checkbox" name="hobbies" value="唱歌">唱歌
    <input type="checkbox" name="hobbies" value="唱歌">跳舞
  </p>
  <p>
    <input type="submit" name="提交">
  </p>
</form>

</body>
</html>
