<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit produkt</h1>
<f:form method="post" modelAttribute="product" action="product.html">
    <f:hidden path="id"/>
    <p>
        Nazwa:<f:input path="name"/>
         <p>
            <f:errors path="name"/>
        </p>
    </p>
    <p>
        Cena:<f:input path="price"/>
        <p>
            <f:errors path="price"/>
        </p>
    </p>
    <button type="submit">Dodaj</button>
</f:form>
</body>
</html>
