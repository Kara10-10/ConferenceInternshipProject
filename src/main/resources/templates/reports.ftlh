<!DOCTYPE html>
<head>
    <title>Conference</title>
</head>
<body>
<h1>Conference</h1><hr>
<#if user.email??>
    <h3> Username: <i> ${user.name} </i></h3>
    <form action = "/logout" method="post">
        <input type="hidden" name = "_csrf" value="${_csrf.token}">
        <input type = "submit" value = "Log out"/>
    </form>
    <#else>
    <a href="/login"> Sign in </a></h1>
</#if>
<hr>
<h4> All reports </h4>
<form action = "/" method="get">
    Search by title: <input type = "text" name="title"><br>
    <input type = "submit" value="Search"/>
</form>
<#list reports as report>
    <div>
        <p>
            <b> ${report.title} </b>
            ${report.room} | <a href = "/report/ ${report.id}">More...</a>
        </p>
    </div>
    <#else >
    <h3>No reports</h3>
</#list>
<#if user.email??>
<hr>
<h3>Create new report</h3>
<form action="/report/create" method="post">
    Report name: <input type = "text" name="title"/><br><br>
    Report description: <input type = "text" name="description"/><br><br>
    Reporting room: <input type = "number" name="room"/><br><br>
    Time: <input type = "number" name="time"/><br><br>
    <input type = "hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value = "Add report"/>
</form>
</#if>
</body>
</html>