<#import "parts/common.ftl" as c>

<@c.page>
 <h5 class="text-center mb-5 px-5 alert alert-primary">Add new slide</h5>

    <form action="/rabota/slides" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Photo: </label>
            <div class="col-sm-6">
                <div class="custom-file">
                    <input class="form-control " type="file" name="image" id="image"/>
                    <label class="custom-file-label" for="image">Add new image  : </label>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary col-3">Save</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">

    </form>

 <h5 class="text-center my-5 px-5 alert alert-primary">Slides</h5>
    <div class="card-columns">
        <#list slides as slide>
            <div class="card my-3" style="width: 18rem;">
                <div>
                     <img src="/img/slider/${slide.imageName}" class="card-img-top" alt="no photo">
                </div>
                <span class="m-2">Published: ${slide.publicationDate}</span>
                <div class="card-footer text-muted">
                    <a class="nav-link alert-warning px-1 rounded text-center" href="/rabota/slides/activation/${slide.id}"><#if slide.isActive()>disactivate<#else>activate</#if> </a>
                    <a class="nav-link alert-danger px-1 rounded ml-2 text-center" href="/rabota/slides/delete/${slide.id}">delete</a>
                </div>
            </div>
        <#else>
        No vacancies available
        </#list>
    </div>

</@c.page>