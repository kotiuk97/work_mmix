<#include "security.ftl">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand alert-primary px-3 rounded" href="/rabota">Jobs CV</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <#if isAdmin>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/rabota/userList">Users list</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rabota/slides">Slides list</a>
                </li>
            </ul>
        </#if>
        <#if isUser>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/rabota/user/editUser">Edit account</a>
            </li>
        </ul>
        </#if>
        <#if isEmployer>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/rabota/user/editEmployer">Edit employer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rabota/user/vacancyList">My vacancies</a>
                </li>
            </ul>
        </#if>

    </div>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" href="/rabota/vacancies">Find a job</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/rabota/resumes">Find an employer</a>
            </li>
            <#if isUser>
                <li class="nav-item">
                    <a class="nav-link" href="/rabota/resume">My resume</a>
                </li>
            </#if>
            <#if isEmployer>
                <li class="nav-item">
                    <a class="nav-link" href="/rabota/vacancy">Publish a vacancy</a>
                </li>
            </#if>

            <li class="nav-item">
                <#if known>
                    <form action="/logout" method="post">
                        <button type="submit" class="nav-link alert-primary px-2 rounded ml-2">Log
                            out, ${username}</button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                <#else>
                        <a class="nav-link alert-primary px-2 rounded ml-2" href="/login">Log in</a>
                </#if>
            </li>
        <#--<li class="nav-item">-->
        <#--<a class="nav-link" href="/rabota/employer/login">For employers</a>-->
        <#--</li>-->
        </ul>
    </div>
</nav>