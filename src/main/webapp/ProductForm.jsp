<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VotePage</title>
    <style> p {
        size: 20px;
        text-align: center; /*text alignment*/
    }

    .select {
        background-color: snow
    }

    /*set class properties, higher priority than p{}*/
    </style>
<body>

<p class="select"> <!--declaring classes to group properties-->
    Product list <br> <br> <br>
    Data foreach product </p>
<table>
    <tr>
        <th>Product id,#</th>
        <th>Product name</th>
        <th>Product price,$</th>
        <th>Product discount,$</th>
        <th>Product description</th>
    </tr>
    <c:forEach items="${productData}" var="product">
        <tr>
            <td>
                <c:out value="${product.getId()}"/>
            </td>
            <td>
                <c:out value="${product.getName()}"/>
            </td>
            <td>
                <c:out value="${product.getPrice()}"/>
            </td>
            <td>
                <c:out value="${product.getDiscount()}"/>
            </td>
            <td>
                <c:out value="${product.getDescription()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<p class="select">
    <button onclick="location.href='${pageContext.request.contextPath}/ui/product_form'"
            type="button">Add new products
    </button>
</p>
</body>
</html>