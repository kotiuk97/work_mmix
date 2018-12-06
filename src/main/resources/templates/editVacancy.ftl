<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/rabota/vacancy/update" method="post">
        <h3 class="text-center mb-3 alert alert-primary">Edit a vacancy</h3>
        <input type="hidden" name="id" value="${vacancy.id}">


        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Vacancy name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" value="${vacancy.name}">
            </div>
        </div>

        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="15" name="description" id="description">${vacancy.description}</textarea>
            </div>
        </div>

        <div class="form-group row">
            <label for="contactPerson" class="col-sm-2 col-form-label">Contact person</label>
            <div class="col-sm-10" id="contactPerson">
                <input type="text" class="form-control" name="contactPerson" value="${vacancy.contactPerson}">
            </div>
        </div>

        <div class="form-group row">
            <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${vacancy.phoneNumber}">
            </div>
        </div>

        <div class="form-group row">
            <label for="city" class="col-sm-2 col-form-label">City</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="city" id="city" value="${vacancy.city}">
            </div>
        </div>

        <div class="form-group row">
            <label for="salary" class="col-sm-2 col-form-label">Salary</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="salary" id="salary" value="${vacancy.salary}">
            </div>
        </div>

        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Send resume on</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email" id="email" value="${vacancy.email}">
            </div>
        </div>

        <div class="mt-4 mb-5 text-center">
            <button type="submit" class="btn btn-primary col-3">Publish</button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

</@c.page>