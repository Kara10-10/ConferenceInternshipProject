<!DOCTYPE html>
<html>
<head>
    <title>Conference</title>
</head>
<body>
<h1>Conference</h1>
<hr>
<h4>Admin panel</h4>
<table>
    <tr>
        <th>Email</th>
        <th>Activity</th>
        <th>Role</th>
        <th>Ban</th>
        <th>Edit</th>
        <th>More information</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Editing</a></th>
            <th><a href="/user/${user.id}">More information</a></th>
        </tr>
    <#else>
        <h3>No user</h3>
    </#list>
</table>
</body>
</html>