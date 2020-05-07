<#import "partials/main.ftlh" as main />

<@main.renderWith>

<h1>Our products</h1>

    <form>
        Search:
        <input type="search" name="name" id="searchForm" placeholder="search" aria-controls="example">
        <button type="button" class="" id="searchId">Search</button>
    </form>

<div class="images">
        <#list items as p>
        <div class="flex flex-column flex-v-center box-128">
            <a href="/page/${p.id}">
            <img src="/images/${p.image}" width="150" height="150">
            <p>${p.id} - ${p.name} </p>
            </a>
        </div>
    </#list>

</div>
<#include "partials/pagination.ftlh">

</@main.renderWith>
