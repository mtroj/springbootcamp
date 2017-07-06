<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Lp.</th>
            <th>Id</th>
            <th>Nazwa</th>
            <th>Cena</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><f:formatNumber type="currency" value="${product.price}"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/">Menu głowne</a>
</body>
</html>
