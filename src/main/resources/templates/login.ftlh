<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2><@spring.message "Please-sign-in"/></h2>
    <form action="/login" method="post">

        <div>
            <#if error!false >
                <p style="color:red"><@spring.message "Invalid-username-or-password!" /></p>
            </#if>
        </div>

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center ">
                <span class="label-input-text"><@spring.message "Mail-address"/></span>
                <input type="text" name="username" placeholder="ваш адрес почты"  value="${(dto.email)!''}" autofocus >
            </label>
        </div>
        <div>
            <label class="flex flex-v-center label-input-text">
                <span class="label-input-text"><@spring.message "Password" /></span>
                <input type="text" name="password" placeholder="пароль" value="">
            </label>
        </div>
        <div>
            <button type="submit"><@spring.message "Enter!"/></button>
        </div>
    </form>
    <div class="bottom-box">
        <a href="/"><@spring.message "To-Home-Page"/></a>
    </div>
</@main.renderWith>
