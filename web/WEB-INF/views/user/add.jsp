<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huangzixiao
  Date: 23/7/2022
  Time: 11:08 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/user" method="post">
  <p>
    id:<input type="text" name="id" value="${user.id}">${errors.id}
  </p>
  <p>
    username:<input type="text" name="username" value="${user.username}">${errors.username}
  </p>
  <p>
    birthday:<input type="text" name="birthday" value="${user.birthday}">${errors.birthday}
  </p>
  <p>
    balance:<input type="text" name="balance" value="${user.balance}">${errors.balance}
  </p>
  <p>
    salary:<input type="text" name="salary" value="${user.salary}">${errors.salary}
  </p>
  <p>
    taskCount:<input type="text" name="taskCount" value="${user.taskCount}">${errors.taskCount}
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

<form:form action="${pageContext.request.contextPath}/form/user" method="post" modelAttribute="user">
  <p>
    id:<form:input path="id"></form:input><form:errors path="id"></form:errors>
  </p>
  <p>
    username:<form:input path="username"></form:input><form:errors path="username"></form:errors>
  </p>
  <p>
    birthday:<form:input path="birthday"></form:input><form:errors path="birthday"></form:errors>
  </p>
  <p>
    balance:<form:input path="balance"></form:input><form:errors path="balance"></form:errors>
  </p>
  <p>
    salary:<form:input path="salary"></form:input><form:errors path="salary"></form:errors>
  </p>
  <p>
    taskCount:<form:input path="taskCount"></form:input><form:errors path="taskCount"></form:errors>
  </p>
  <p>
    hobbies:
    <!--静态数据源-->
    <form:checkbox path="hobbies" value="唱歌"></form:checkbox>
    <form:label path="hobbies">唱歌</form:label>
    <form:checkbox path="hobbies" value="跳舞"></form:checkbox>
    <form:label path="hobbies">跳舞</form:label>

    <!--动态数据源-->
    <form:checkboxes path="hobbies" items="${list}"></form:checkboxes>
  </p>
  <p>
    <form:button>提交</form:button>
<%--    <input type="submit" name="提交">--%>
  </p>
</form:form>



</body>
</html>
