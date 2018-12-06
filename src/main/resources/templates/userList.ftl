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
        <th scope="col">Modified date</th>
        <th scope="col">Image</th>
        <th scope="col"></th>
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
            <td>${(user.lastModifiedDate)!""}</td>
            <td> <img src="/img/users/${user.imageName!""}" style="max-width: 110px; max-height: 110px;" class="img-fluid" alt="no photo"></td>
            <td><a class="nav-link alert-primary px-2 rounded ml-2 text-center" href="/rabota/user/${user.id}">edit</a></td>
            <td><a class="nav-link alert-warning px-2 rounded ml-2 text-center" href="/rabota/user/activation/${user.id}">
                <#if user.isActive()>block<#else >activate</#if></a></td>
            <td><a class="nav-link alert-danger px-2 rounded ml-2 text-center" href="/rabota/user/delete/${user.id}">delete</a></td>
        </tr>
        </#list>
    </tbody>
</table>

    <h5 class="text-center mt-5 mb-3 alert alert-primary">List of companies</h5>
<#--<h5>List of users</h5>-->
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Company</th>
        <th scope="col">Registration date</th>
        <th scope="col">Modified date</th>
        <th scope="col">Image</th>
        <th scope="col"></th>
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
            <td>${(user.lastModifiedDate)!""}</td>
            <td> <img src="/img/users/${user.imageName!""}" style="max-width: 110px; max-height: 110px;" class="img-fluid" alt="no photo"></td>
            <td><a class="nav-link alert-primary px-2 rounded ml-2 text-center" href="/rabota/employer/${user.id}">edit</a></td>
            <td><a class="nav-link alert-warning px-2 rounded ml-2 text-center" href="/rabota/user/activation/${user.id}">
                <#if user.isActive()>block<#else >activate</#if></a></td>
            <td><a class="nav-link alert-danger px-2 rounded ml-2 text-center" href="/rabota/user/delete/${user.id}">delete</a></td>
        </tr>
        </#list>
    </tbody>
</table>
</@c.page>
