<#import "parts/common.ftl" as c>

<@c.page>

<#--<form action="/login" method="post">-->
    <#--<input type="text" name="username">-->
    <#--<input type="password" name="password">-->
    <#--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
    <#--<button type="submit" class="btn btn-primary col-4">Log in</button>-->

<#--</form>-->
        <form action="/login" method="post">
            <h5 class="text-center mb-5 px-5 alert alert-primary text-center">Log in</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email : </label>
                <div class="col-sm-4">
                    <input class="form-control ${(emailError??)?string('is-invalid','')}"
                           value="<#if user??>${user.email}</#if>" type="text" name="username" placeholder="some@some.com"/>
                     <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                     </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password : </label>
                <div class="col-sm-4 text-center">
                    <input class="form-control  ${(passwordError??)?string('is-invalid','')}" type="password" name="password" placeholder="password"/>
                    <a href="#">Forgot a password</a>
                    <#if passwordError??>
                        <div class="invalid-feedback">
                            ${passwordError}
                        </div>
                    </#if>
                    <div class="mt-4 ">
                        <button type="submit" class="btn btn-primary col-4">Log in</button>
                        <a href="/rabota/registration" class="btn btn-primary ml-4 col-4">Sign up</a>
                    </div>
                </div>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
</@c.page>