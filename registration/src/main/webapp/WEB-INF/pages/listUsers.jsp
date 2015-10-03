<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- TODO Remove this
  Created by IntelliJ IDEA.
  User: madhulal
  Date: 9/9/15
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<c:forEach items="${users}" var="user">
    <div>${user.username}, ${user.password}</div>
</c:forEach>
</body>
</html>
