<#-- @ftlvariable name="organizations" type="java.util.List<org.mare.pos.domain.Organization>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of organizations</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/organization/create">Create a new organizations</a></li>
    </ul>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Notes</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <#list organizations as organization>
    <tr>
        <td><a href="/organization/${organization.id}">${organization.name}</a></td>
        <td>${organization.notes}</td>
        <#if organization.contactInfo ??>
            <td>${organization.contactInfo.address}</td>
        </#if>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>