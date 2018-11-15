<#assign
    known = Session.SPRING_SECURITY_CONTEXT??

>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        username = user.getEmail()
        <#--isAdmin = user.getAuthorities()?seq_contains('ADMIN')-->
        isAdmin = user.isAdmin()
        isEmployer = user.isEmployer()
        isEmployer =  user.getAuthorities()?seq_contains('EMPLOYER')
        isUser = user.isUser() isEmployer = user.isEmployer()
        <#--isUser =  user.getAuthorities()?seq_contains('USER')-->

    >
<#else >
    <#assign
    isAdmin = false
    isEmployer = false
    isUser = false
    >

</#if>