<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lesson 65. JPA & ORM</title>
</head>
<body>
<h1>Содержимое страницы</h1>

<ul>
    <#list products as p>
    <li>
        <p>${p.id} - ${p.name} - ${p.image}</p>
    </li>
</#list>
</ul>

</body>
</html>