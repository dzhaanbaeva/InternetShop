<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith>

<div class="container">
    <h1><@spring.message "Your-cart"/></h1>
        <#if cartItems??>
        <#list cartItems as item>
            <p>${item}</p>
        </#list>
        <form action="/cart/empty" method="post">
            <button><@spring.message "Clean the cart"/></button>
        </form>
    <#else>
        <p><@spring.message "There's-nothing"/></p>
    </#if>

    <div>
        <a href="/"><@spring.message "back"/></a>
    </div>
</div>

</@main.renderWith>