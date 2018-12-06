<#assign
    known = Session.SPRING_SECURITY_CONTEXT??

>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        <#--isAdmin = user.getAuthorities()?seq_contains('ADMIN')-->
        isAdmin = user.isAdmin()
        isEmployer = user.isEmployer()
        <#--isEmployer =  user.getAuthorities()?seq_contains('EMPLOYER')-->
        isUser = user.isUser()
        <#--isUser =  user.getAuthorities()?seq_contains('USER')-->
    >
    <#if isUser>
        <#assign
            username = user.getLastName() + " " + user.getFirstName()
        >
    <#elseif isEmployer>
        <#assign
        username = user.getCompanyName()
        >
    <#else >
        <#assign
            username = "admin"
        >
    </#if>

<#else >
    <#assign
    isAdmin = false
    isEmployer = false
    isUser = false
    >

</#if>
