<#import "partials/main.ftlh" as main />

<@main.renderWith>

<h1>Product</h1>

<div class="flex flex-wrap" id="itemList">
    <#list items as listItem>
        <div class="flex flex-column box flex-v-center">
            <img class="food-icon" src="/images/${listItem.image}" alt="${listItem.name}" width="350" height="250">
<
            <p>Name: ${listItem.name}  </p>
            <p>Brand: ${listItem.brand.brand}  </p>
            <p>Category: ${listItem.category.category}  </p>
            <p>Price: ${listItem.price}  </p>
            <p>Description: ${listItem.description}</p>

        </div>
    </#list>
</div>



</@main.renderWith>
