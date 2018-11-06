<#import "parts/common.ftl" as c>

<@c.page>
      <h5>List of users</h5>
<table>
    <thead>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Company</th>
        <th>Role</th>
        <th>registrationDate</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td>${(user.firstName)!""}</td>
            <td>${(user.lastName)!""}</td>
            <td>${(user.companyName)!""}</td>
            <td>${(user.role)!""}</td>
            <td>${(user.registrationDate)!""}</td>
            <#--<td><a href="/user/${user.id}">edit</a></td>-->
        </tr>
        </#list>
    </tbody>
</table>
</@c.page>
