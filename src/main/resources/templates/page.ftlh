<#import "partials/main.ftlh" as main />

<@main.renderWith>

<h1>Product</h1>

<div class="flex flex-wrap" id="itemList">
    <#list items as listItem>
        <div class="card-info">
         <img class="food-icon" src="/images/${listItem.image}" alt="${listItem.name}" width="350" height="250">
            <p>Name: ${listItem.name}  </p>
            <p>Brand: ${listItem.brand.brand}  </p>
            <p>Category: ${listItem.category.category}  </p>
            <p>Price: ${listItem.price}  </p>
            <p>Description: ${listItem.description}</p>
            <form action="/cart/add" method="post">
                <input name="productId" type="hidden" value="${listItem.id}">
                <button type="submit" class="back flex align-center">Add to cart</button>
            </form>
            <form action="/cart" method="get">
                <button type="submit" class="back flex align-center">Show cart</button>
            </form>
        </div>
    </#list>
</div>



</@main.renderWith>
