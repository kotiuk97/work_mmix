<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/rabota/vacancy" method="post">
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
                <textarea class="form-control" rows="15" name="description" id="description" placeholder="requirements&#10;obligations&#10;conditions"></textarea>
            </div>
        </div>

        <div class="form-group row">
            <label for="contactPerson" class="col-sm-2 col-form-label">Contact person</label>
            <div class="col-sm-10" id="contactPerson">
                <input type="text" class="form-control" name="contactPerson" placeholder="Name Surname">
            </div>
        </div>

        <div class="form-group row">
            <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="+380501234567">
            </div>
        </div>

        <div class="form-group row">
            <label for="city" class="col-sm-2 col-form-label">City</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="city" id="city" placeholder="e.g. Chernivtsi">
            </div>
        </div>

        <div class="form-group row">
            <label for="salary" class="col-sm-2 col-form-label">Salary</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="salary" id="salary" >
            </div>
        </div>

        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Send resume on</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
            </div>
        </div>

        <div class="mt-4 mb-5 text-center">
            <button type="submit" class="btn btn-primary col-3">Publish</button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

</@c.page>