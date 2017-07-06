<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Sklep ogrodniczy</title>
</head>
<body>
<h1><s:message code="index.title"/></h1>
<ul>
    <li>
        <a href="show-products.html">
            <s:message code="index.showProducts"/>
        </a>
    </li>
    <li>
        <a href="product.html">
            Dodaj produkt
        </a>
    </li>
</ul>
</body>
</html>