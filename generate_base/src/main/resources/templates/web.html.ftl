<!DOCTYPE html>
<html>
<head>
    <title>代码生成器</title>
</head>
<body>
<h1>欢迎来到代码生成器</h1>
<ul>
    <#list menuItems as item>
    <li><a href="${item.url}">${item.label}</a> </li>
    </#list>
</ul>

<footer>
    ${currentYear} 代码生成器官网.All rights reserverd.
</footer>
</body>
</html>