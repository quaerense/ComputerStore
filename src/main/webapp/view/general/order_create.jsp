<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Оформление заказа</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a> (${sessionScope.employee.employeePosition})
            <a class="right" href="${pageContext.request.contextPath}/logout">Выйти</a>
        </div>

        <div class="center">
            <h1>Оформление заказа</h1>

            <form action="${pageContext.request.contextPath}/order_create" method="post">
                <table class="tableForm">
                    <tr>
                        <th>Наименование</th>
                        <td>${requestScope.product.productName}</td>
                    </tr>
                    <tr>
                        <th>Артикул</th>
                        <td>${requestScope.product.productId}</td>
                    <tr>
                        <th>Стоимость одного товара (руб.)</th>
                        <td>${requestScope.product.sellingPrice}</td>
                    <tr>
                        <th>Товаров на складе</th>
                        <td>${requestScope.product.productQuantity}</td>
                    <tr>
                        <th><label for="quantity">Введите количество товаров</label></th>
                        <td><input type="number" value="1" id="quantity" name="quantity" min="1" max="${requestScope.product.productQuantity}"></td>
                    </tr>
                    <tr class="noBorder">
                        <td colspan="2" class="noBorder"><input type="submit" value="Создать"></td>
                    </tr>
                </table>
            </form>
            <br/>
            <a href="${pageContext.request.contextPath}/products">Отмена</a>
        </div>
    </body>
</html>
