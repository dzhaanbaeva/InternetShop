<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith>

<h1><@spring.message "Product"/></h1>

<div class="flex flex-wrap" id="itemList">
     <#if items??>
    <#list items as listItem>
        <div class="card-info">
         <img class="food-icon" src="/images/${listItem.image}" alt="${listItem.name}" width="350" height="250">
            <p><@spring.message "Name"/> ${listItem.name}  </p>
            <p><@spring.message "Brand"/> ${listItem.brand.brand}  </p>
            <p><@spring.message "Category"/> ${listItem.category.category}  </p>
            <p><@spring.message "Price"/> ${listItem.price}$  </p>
            <p><@spring.message "Description"/> ${listItem.description}</p>
            <form action="/cart/add" method="post">
                <input name="productId" type="hidden" value="${listItem.id}">
                <input name="qty" type="hidden" value="${listItem.quantity}">
                <button type="submit" class="back flex align-center"><@spring.message "Add-to-cart"/></button>
            </form>
            <form action="/cart" method="get">
                <button type="submit" class="back flex align-center"><@spring.message "Show-cart"/></button>
            </form>
        </div>
    </#list>
    </#if>
</div>



</@main.renderWith>
