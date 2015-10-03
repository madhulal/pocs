<%--
  Created by IntelliJ IDEA.
  User: madhulal
  Date: 12/9/15
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/users/add" var="userActionUrl"/>

<form:form method="post" modelAttribute="userForm" action="${userActionUrl}">

    <spring:bind path="username">
        <form:input path="username" type="text" class="form-control"
                    id="username" placeholder="User-Name"/>
    </spring:bind>

    <spring:bind path="password1">
        <form:input path="password1" type="password" class="form-control"
                    id="password1"/>
    </spring:bind>

    <spring:bind path="password2">
        <form:input path="password2" type="password" class="form-control"
                    id="password2"/>
    </spring:bind>


    <button type="submit">Add</button>

</form:form>
