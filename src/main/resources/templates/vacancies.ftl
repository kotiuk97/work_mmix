<#import "parts/common.ftl" as c>

<@c.page>

    <div class="card-columns">
        <#list vacancies as vacancy>
            <div class="card my-3" style="width: 18rem;">
                <div>
                 <#if vacancy.employer.imageName??>
                     <img src="/img/users/${vacancy.employer.imageName}" class="card-img-top" alt="${vacancy.employer.imageName}">
                 </#if>
                </div>
                <span class="m-2">${vacancy.name}</span>
                <div class="card-footer text-muted">
                    <i>${vacancy.employer.companyName}, ${vacancy.city}</i>
                    <strong>${vacancy.salary}</strong>
                </div>
                <div class="card-footer text-muted">
                    <a class="nav-link alert-primary px-1 rounded ml-2 text-center" href="/rabota/vacancy/${vacancy.id}">Details</a>
                </div>
            </div>
        <#else>
        No vacancies available
        </#list>
    </div>

</@c.page>