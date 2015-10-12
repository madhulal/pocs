<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="org.mare.pos.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
    </#if>
    <#if currentUser?? && currentUser.role.value == 0>
        <li><a href="/store/daily/sales">Sale</a></li>
        <li><a href="/store/daily/purchase">Purchase</a></li>
        <li><a href="/store/daily/reports">Purchase</a></li>
        <li><a href="/store/daily/products">Products</a></li>
    </#if>

    <#if currentUser?? && currentUser.role.value == 1 >
        <li><a href="/store/admin/users">View all users in store</a></li>
        <li><a href="/store/admin/user/create">Create a new user</a></li>
    </#if>

    <#if currentUser?? && currentUser.role.value == 2 >
        <li><a href="/organization/admin/users">View all users in organization</a></li>
        <li><a href="/organization/admin/user/create">Create a new user</a></li>
        <li><a href="/organization/admin/stores">View all stores</a></li>
        <li><a href="/organization/admin/store/create">Create a new store</a></li>
    </#if>

    <#if currentUser?? && currentUser.role.value == 3 >
        <li><a href="/application/admin/users">View all users in organization</a></li>
        <li><a href="/application/admin/user/create">Create a new user</a></li>
        <li><a href="/application/admin/organizations">View organizations</a></li>
        <li><a href="/application/admin/organization/create">Create a new organization</a></li>
    </#if>
    </ul>
</nav>
</body>
</html>