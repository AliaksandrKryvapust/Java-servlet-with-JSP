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
<form method="post" name="add" action="${pageContext.request.contextPath}/api/product_form">
<p class="select"> <!--declaring classes to group properties-->
    Product list <br> <br> <br>
    Data foreach product
<table>
    <tr>
        <th>Product name</th>
        <th>Product price,$</th>
        <th>Product discount,$</th>
        <th>Product description</th>
    </tr>
    <tr>
            <td>
                <label>
                    <textarea name="name"></textarea>
                </label>
            </td>
            <td>
                <label>
                    <textarea name="price"></textarea>
                </label>
            </td>
            <td>
                <label>
                    <textarea name="discount"></textarea>
                </label>
            </td>
            <td>
                <label>
                    <textarea name="description"></textarea>
                </label>
            </td>
    </tr>

</table>

    <p><input type="submit" name="submit_btn" value="Submit"></p>
</form>
</body>
</html>