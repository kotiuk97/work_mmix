<#import "parts/common.ftl" as c>

<@c.page>

    <div class="card-columns">
        <#list vacancies as vacancy>
            <div class="card my-3" style="width: 18rem;">
                <div>
                 <#if vacancy.employe.imageName??>
                     <img src="/img/${vacancy.employe.imageName}" class="card-img-top" alt="">
                 </#if>
                </div>
                <span class="m-2">${vacancy.name}</span>
                <div class="card-footer text-muted">
                    <i>${vacancy.employe.companyName}, ${vacancy.city}</i>
                    <strong>${vacancy.salary}</strong>
                </div>
            </div>
        <#else>
        No vacancies available
        </#list>
    </div>

</@c.page>