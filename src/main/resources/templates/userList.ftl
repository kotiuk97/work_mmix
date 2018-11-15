<#import "parts/common.ftl" as c>

<@c.page>
    <h5 class="text-center mb-3 alert alert-primary">List of users</h5>
      <#--<h5>List of users</h5>-->
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">User id</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">Registration date</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <th scope="row">${user.id}</th>
            <td>${(user.firstName)!""}</td>
            <td>${(user.lastName)!""}</td>
            <td>${(user.registrationDate)!""}</td>
            <td><a class="nav-link alert-primary px-2 rounded ml-2 text-center" href="/rabota/user/${user.id}">edit</a></td>
            <td><a class="nav-link alert-warning px-2 rounded ml-2 text-center" href="#">block</a></td>
        </tr>
        </#list>
    </tbody>
</table>

    <h5 class="text-center mb-3 alert alert-primary">List of companies</h5>
<#--<h5>List of users</h5>-->
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Company</th>
        <th scope="col">Registration date</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
        <#list employers as user>
        <tr>
            <th scope="row">${user.id}</th>
            <td>${(user.companyName)!""}</td>
            <td>${(user.registrationDate)!""}</td>
            <td><a class="nav-link alert-primary px-2 rounded ml-2 text-center" href="/rabota/employer/${user.id}">edit</a></td>
            <td><a class="nav-link alert-warning px-2 rounded ml-2 text-center" href="#">block</a></td>
        </tr>
        </#list>
    </tbody>
</table>
</@c.page>
