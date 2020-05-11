<#import "partials/main.ftlh" as main />

<@main.renderWith>

<h1>Product</h1>

<div class="flex flex-wrap" id="itemList">
    <#list items as listItem>
        <ul class="card-info">
           <li><img class="food-icon" src="/images/${listItem.image}" alt="${listItem.name}" width="350" height="250"></li>
            <li>Name: ${listItem.name}  </li>
            <li>Brand: ${listItem.brand.brand}  </li>
            <li>Category: ${listItem.category.category}  </li>
            <li>Price: ${listItem.price}  </li>
            <li>Description: ${listItem.description}</li>
        </ul>
    </#list>
</div>



</@main.renderWith>
