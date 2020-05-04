<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Lesson 66. JPA & ORM</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>registration form</h1>-->
<form action="/register" method="post">
    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">email: </p>
            <input type="email" name="email" placeholder="Your email" value="${(form.email)}">
        </label>
    </div>

<#--    <div>-->
<#--        <label class="flex flex-v-center">-->
<#--            <p class="label-input-text">password: </p>-->
<#--            <input type="password" name="password" placeholder="Your password" value="${(form.password)}">-->

<#--        </label>-->
<#--    </div>-->

    <div>
          <label class="flex flex-v-center">
              <p class="label-input-text">Name: </p>
             <input type="text" name="name" placeholder="Your name" value="${(form.name)}">

            </label>
    </div>
    <div>
        <button type="submit">Registration</button>
    </div>
    <div>
        <#if errors?? >
        <p>Enter data with errors</p>
             <#list errors as fieldErrors>
             <p>${fieldErrors.field} - ${fieldErrors.defaultMessage!'--------no mesage!-------'} </p>
            </#list>
        </#if>
    </div>
</form>

<#--</body>-->
<#--</html>-->