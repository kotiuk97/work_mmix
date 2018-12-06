<#import "parts/common.ftl" as c>

<@c.page>
 <h5 class="text-center mb-5 px-5 alert alert-primary">Wellcome!</h5>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <#list 0..slides?size as x>
                <#if x == 0>
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <#else>
                    <li data-target="#carouselExampleIndicators" data-slide-to="${x}"></li>
                </#if>
            <#else >
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            </#list>
        </ol>
        <div class="carousel-inner">
            <#assign  x = 0>
            <#list slides as slide>
                <#if x == 0>
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="/img/slider/${slide.imageName}" alt="${slide.imageName}">
                                </div>
                <#else>
                                <div class="carousel-item ">
                                    <img class="d-block w-100" src="/img/slider/${slide.imageName}" alt="${slide.imageName}">
                                </div>
                </#if>
            <#assign x++>
            <#else >
                <div class="carousel-item active">
                    <img class="d-block w-100" src="..." alt="slide">
                </div>
            </#list>

        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

</@c.page>