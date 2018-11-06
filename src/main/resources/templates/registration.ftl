<#import "parts/common.ftl" as c>

<@c.page>
    <#if message??>
        <div class="alert alert-${message}" role="alert">
            ${message}
        </div>
    </#if>
     <form action="/rabota/registration" method="post">
         <h5 class="text-center mb-5 px-5 alert alert-primary">Registration</h5>
         <div class="form-group row">
             <label class="col-sm-2 col-form-label"> First name : </label>
             <div class="col-sm-6">
                 <input class="form-control  ${(firstNameError??)?string('is-invalid','')}"
                        value="<#if user??>${user.firstName}</#if>" type="text" name="firstName" placeholder="first name"/>
                 <#if firstNameError??>
                        <div class="invalid-feedback">
                            ${firstNameError}
                        </div>
                 </#if>
             </div>
         </div>
         <div class="form-group row">
             <label class="col-sm-2 col-form-label"> Last name : </label>
             <div class="col-sm-6">
                 <input class="form-control  ${(lastNameError??)?string('is-invalid','')}"
                        value="<#if user??>${user.lastName}</#if>" type="text" name="lastName" placeholder="last name"/>
                 <#if lastNameError??>
                        <div class="invalid-feedback">
                            ${lastNameError}
                        </div>
                 </#if>
             </div>
         </div>
         <div class="form-group row">
             <label class="col-sm-2 col-form-label">Email : </label>
             <div class="col-sm-6">
                 <input class="form-control ${(emailError??)?string('is-invalid','')}"
                        value="<#if user??>${user.email}</#if>" type="email" name="email" placeholder="some@some.com"/>
                     <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                     </#if>
             </div>
         </div>
         <div class="form-group row">
             <label class="col-sm-2 col-form-label">Phone number : </label>
             <div class="col-sm-6">
                 <input class="form-control ${(emailError??)?string('is-invalid','')}"
                        value="<#if user??>${user.phoneNumber}</#if>" type="text" name="phoneNumber" placeholder="phone number"/>
                     <#if phoneNumberError??>
                        <div class="invalid-feedback">
                            ${phoneNumberError}
                        </div>
                     </#if>
             </div>
         </div>
         <div class="form-group row">
             <label class="col-sm-2 col-form-label">Password : </label>
             <div class="col-sm-6">
                 <input class="form-control  ${(passwordError??)?string('is-invalid','')}" type="password" name="password" placeholder="password"/>
                 <#if passwordError??>
                        <div class="invalid-feedback">
                            ${passwordError}
                        </div>
                 </#if>
             </div>
         </div>
         <div class="form-group row">
             <label class="col-sm-2 col-form-label">Re-type password : </label>
             <div class="col-sm-6">
                 <input class="form-control ${(password2Error??)?string('is-invalid','')}" type="password" name="password2" placeholder="re-type password"/>
                 <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                 </#if>

                 <div class="mt-5 text-center">
                     <button type="submit" class="btn btn-primary col-3">Sign up</button>
                     <a href="/rabota/employer/registration" class="btn btn-primary ml-3 col-4">Employer registration</a>
                 </div>

             </div>
         </div>
         <input type="hidden" name="_csrf" value="${_csrf.token}">

     </form>

</@c.page>


