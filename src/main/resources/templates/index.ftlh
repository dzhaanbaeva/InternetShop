<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lesson 65. JPA & ORM</title>
</head>
<body>
<h1>New products</h1>

<ul>
    <#list products as p>
        <img src="/images/${p.image}" width="150" height="150">
    <li>
        <p>${p.id} - ${p.name} </p>
    </li>
</#list>
</ul>

</body>
</html>