<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2><@spring.message "Please-enter-email-to-reset-password"/></h2>
    <div>
    <form action="/forgot-password" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text"><@spring.message "Mail-address"/></p>
                <input type="text" name="email" placeholder="ваш адрес почты" >
            </label>
        </div>
        <div>
            <button type="submit"><@spring.message "Sent"/></button>
        </div>
        <div>
            <#if errors?? >
                <p><@spring.message "Input-data-with-errors"/></p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
            </#if>
        </div>
    </form>
    </div>
    <div class="bottom-box">
        <a href="/"><@spring.message "To-Home-Page"/></a>
    </div>
</@main.renderWith>