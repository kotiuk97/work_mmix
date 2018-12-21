<#import "parts/common.ftl" as c>

<@c.page>
    <h3 class="text-center mb-4 alert alert-primary">Resumes</h3>
    <#if resume.user.imageName??>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Image : </label>
                <div class="col-sm-6">
                    <img src="/img/users/${resume.user.imageName}" style="max-height: 500px; max-width: 500px;" class="rounded" alt="no photo available">
                </div>
            </div>
    </#if>
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">Resume name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name" id="name" value="${resume.name}" readonly>
        </div>
    </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Name : </label>
            <div class="col-sm-6">
                <input class="form-control "
                       value="${resume.user.lastName} ${resume.user.firstName}" type="text" name="username" readonly/>

            </div>
        </div>
    <#if resume.showPhoneNumber>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Phone number</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${resume.user.phoneNumber}" readonly>
                </div>
            </div>
    </#if>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email : </label>
            <div class="col-sm-6">
                <input class="form-control"
                       value="${resume.user.email}" type="email" name="email" readonly/>
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10 mb-5">
                <textarea class="form-control" rows="15" name="description" id="description" readonly>${resume.description}</textarea>
            </div>
        </div>

</@c.page>
