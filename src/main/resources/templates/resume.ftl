<#import "parts/common.ftl" as c>

<@c.page>
    <h3 class="text-center mb-3 alert alert-primary">Resumes</h3>

    <#if resume.user.imageName??>
    <div style="width: 100px">
        <img src="/img/users/${resume.user.imageName}" style="max-height: 300px; max-width: 300px; padding-right: 50px; padding-top: 70px" class="rounded float-right fixed-top ml-auto" alt="no photo available">

    </div>

            <#--<div class="form-group row">-->
                <#--<label for="name" class="col-sm-2 col-form-label">Employer</label>-->
                <#--<img src="/img/users/${resume.user.imageName}" alt="no photo">-->
            <#--</div>-->
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
                <div class="col-sm-10">
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
            <div class="col-sm-10">
                <textarea class="form-control" rows="15" name="description" id="description" readonly>${resume.description}</textarea>
            </div>
        </div>

</@c.page>
