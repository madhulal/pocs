<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="org.mare.pos.form.StoreCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new user</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new Organization</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${form.name}" required autofocus/>
    </div>
    <div>
        <label for="notes">notes</label>
        <input type="text" name="notes" id="notes" value="${form.notes}"/>
    </div>

    <div>
        <label for="address">Address</label>
        <input type="text" name="address" id="address" value="${form.contactInfo.address}"/>
    </div>

    <div>
        <label for="city">City</label>
        <input type="text" name="city" id="city" value="${form.contactInfo.city}"/>
    </div>

    <div>
        <label for="state">State</label>
        <input type="text" name="state" id="state" value="${form.contactInfo.state}"/>
    </div>

    <div>
        <label for="country">Country</label>
        <input type="text" name="country" id="country" value="${form.contactInfo.country}"/>
    </div>

    <div>
        <label for="phoneNumber1">phoneNumber1</label>
        <input type="text" name="phoneNumber1" id="phoneNumber1" value="${form.contactInfo.contactNumber}"/>
    </div>

    <div>
        <label for="phoneNumber2">phoneNumber2</label>
        <input type="text" name="phoneNumber2" id="phoneNumber2" value="${form.contactInfo.mobileNumber}"/>
    </div>

    <div>
        <label for="email">Email</label>
        <input type="text" name="email" id="email" value="${form.contactInfo.email}"/>
    </div>

    <div>
        <label for="web">Web</label>
        <input type="text" name="web" id="web" value="${form.contactInfo.web}"/>
    </div>

    <button type="submit">Save</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>