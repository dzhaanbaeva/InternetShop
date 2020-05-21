<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dto??>
        <h1><@spring.message "Your-personal-data"/></h1>
        <p>${(dto.fullname)!'-- missing --'} - ${(dto.email)!'-- email missing --'}</p>
    <#else>
        <h1><@spring.message "User-is-not-found"/></h1>
    </#if>
    <div class="bottom-box">
        <a href="/"><@spring.message "To-Home-Page"/></a>
    </div>
</@main.renderWith>