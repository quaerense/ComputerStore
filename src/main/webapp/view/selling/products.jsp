<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Товары</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a> (${sessionScope.employee.employeePosition})
            <a class="right" href="${pageContext.request.contextPath}/logout">Выйти</a>
        </div>

        <div class="center">
            <h1>Товары</h1>

            <table class="tableMain">
                <tr>
                    <th>Артикул</th>
                    <th>Номер поставки</th>
                    <th>Тип</th>
                    <th>Название</th>
                    <th>Описание</th>
                    <th>Количество</th>
                    <th>Стоимость закупки (руб.)</th>
                    <th>Стоимость продажи (руб.)</th>
                    <th>Продать</th>
                </tr>
                <c:forEach items="${requestScope.products}" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.deliveryId}</td>
                        <td>${product.productType}</td>
                        <td>${product.productName}</td>
                        <td>${product.productDescription}</td>
                        <td>${product.productQuantity}</td>
                        <td>${product.purchasePrice}</td>
                        <td>${product.sellingPrice}</td>
                        <td><a href="${pageContext.request.contextPath}/order_create?id=${product.productId}">Оформить заказ</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
