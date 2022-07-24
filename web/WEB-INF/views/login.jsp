<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huangzixiao
  Date: 24/7/2022
  Time: 9:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("basePath", request.getContextPath()); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:message code="txt_Hello"></spring:message>!
<div class="row">
  <a class="col-md-6" href="${basePath}/i18n/zh_CN">中文</a>
  <a class="col-md-6" href="${basePath}/i18n/en_US">English</a>
</div>
</body>
</html>
