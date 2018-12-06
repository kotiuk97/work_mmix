<#import "parts/common.ftl" as c>

<@c.page>

    <div class="card-columns">
        <#list resumes as resume>
            <div class="card my-3" style="width: 18rem;">
                <div>
                 <#if resume.user.imageName??>
                     <img src="/img/users/${resume.user.imageName}" class="card-img-top" alt="${resume.user.imageName}">
                 </#if>
                </div>
                <span class="m-2">${resume.name}</span>
                <div class="card-footer text-muted">
                    <i>${resume.user.lastName} ${resume.user.firstName}</i>
                    <a class="nav-link alert-primary px-1 rounded text-center" href="/rabota/resumes/${resume.id}">See details</a>
                </div>
            </div>
        <#else>
        No vacancies available
        </#list>
    </div>

</@c.page>