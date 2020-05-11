<#import "partials/main.ftlh" as main />

<@main.renderWith>

<h1>Our products</h1>

    <form id="login-form" name="form" action="/product/name" method="post">
        Search:
        <input type="text" name="text" id="searchForm" placeholder="search" aria-controls="example">
        <button type="button" class="" id="searchId">Search</button>
    </form>

<div class="images">
        <#list items as p>
        <div class="image-card">
            <img class="image-card-img" src="/images/${p.image}" width="150" height="150">
            <a class="card-link" href="/page/${p.id}">
            <p>${p.id} - ${p.name} </p>
            </a>
        </div>
    </#list>

</div>
<#include "partials/pagination.ftlh">

</@main.renderWith>
