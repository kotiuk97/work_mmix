<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/rabota/resume" method="post">
        <h3 class="text-center mb-3 alert alert-primary">Edit resume</h3>
        <input type="hidden" name="id">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Resume name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" value="${resume.name}">
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="15" name="description" id="description">${resume.description}"</textarea>
            </div>
        </div>
        <#if resume.showPhoneNumber>
            <div class="form-group row">
                <label for="showPhoneNumber" class="col-form-label">Show phone number
                    <input type="checkbox" class="col-form-label" name="showPhoneNumber" id="showPhoneNumber" >
                </label>
            </div>
        </#if>
        <div class="mt-4 mb-5 text-center">
            <button type="submit" class="btn btn-primary col-3">Publish</button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</@c.page>
