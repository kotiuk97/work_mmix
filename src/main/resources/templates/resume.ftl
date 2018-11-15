<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/rabota/resume" method="post">
        <h3 class="text-center mb-3 alert alert-primary">Create a vacancy</h3>
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Vacancy name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" placeholder="e.g. Manager">
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="15" name="description" id="description" placeholder="education&#10;obligations&#10;conditions"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <label for="showPhoneNumber" class="col-form-label">Show phone number
                <input type="checkbox" class="col-form-label" name="showPhoneNumber" id="showPhoneNumber" >
            </label>
        </div>

        <div class="mt-4 mb-5 text-center">
            <button type="submit" class="btn btn-primary col-3">Publish</button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</@c.page>
