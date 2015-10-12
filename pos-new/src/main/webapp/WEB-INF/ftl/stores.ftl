<#-- @ftlvariable name="stores" type="java.util.List<org.mare.pos.domain.Organization>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of stores</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/store/create">Create a new stores</a></li>
    </ul>
</nav>

<h1>List of Stores</h1>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Notes</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <#list stores as store>
    <tr>
        <td><a href="/store/${store.id}">${store.name}</a></td>
        <td>${store.notes}</td>
        <#if store.contactInfo??>
            <td>${store.contactInfo.address}</td>
        </#if>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>