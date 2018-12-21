<#import "parts/common.ftl" as c>

<@c.page>
    <h3 class="text-center mb-3 alert alert-primary">Vacancy</h3>
    <#if vacancy.employer.imageName??>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Logo : </label>
                <div class="col-sm-6">
                    <img src="/img/users/${vacancy.employer.imageName}" style="max-height: 500px; max-width: 500px;" class="rounded" alt="no photo available">
                </div>
            </div>
    </#if>

        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Vacancy name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" value="${vacancy.name}" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="15" name="description" id="description" readonly>${vacancy.description}</textarea>
            </div>
        </div>

        <div class="form-group row">
            <label for="contactPerson" class="col-sm-2 col-form-label">Contact person</label>
            <div class="col-sm-10" id="contactPerson">
                <input type="text" class="form-control" name="contactPerson"
                       value="${vacancy.contactPerson}" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${vacancy.phoneNumber}" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label for="city" class="col-sm-2 col-form-label">City</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="city" id="city" value="${vacancy.city}" readonly>
            </div>
        </div>

        <div class="form-group row">
            <label for="salary" class="col-sm-2 col-form-label">Salary</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="salary" id="salary" value="${vacancy.salary}" readonly>
            </div>
        </div>

        <div class="form-group row mb-5">
            <label for="email" class="col-sm-2 col-form-label">Send resume on</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email" id="email" value="${vacancy.email}" readonly>
            </div>
        </div>

</@c.page>