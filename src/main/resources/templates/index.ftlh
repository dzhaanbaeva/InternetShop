<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith>

    <div class="nameBrand">
        <h1>Internet Shop Euphoria Parfums</h1>
    </div>

    <div class="flex flex-justify-content-center">
        <a class="flex box-128" href="/forgot-password"><@spring.message "Forgot-password"/></a>
        <a class="flex box-128" href="/register"><@spring.message "Registration"/></a>
        <a class="flex box-128" href="/login"><@spring.message "Enter"/></a>
        <form class="flex box-128" action="/logout" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <button class="flex box-128 logout-button"><@spring.message "logout"/></button>
        </form>

    </div>
    </div>
</@main.renderWith>