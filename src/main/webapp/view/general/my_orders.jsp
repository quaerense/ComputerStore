<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Завершенные заказы</title>
</head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a>  (${sessionScope.employee.employeePosition})
            <a class="right" href="${pageContext.request.contextPath}/logout">Выйти</a>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        </div>

        <div class="center">
            <h1>Мои заказы</h1>

            <table class="tableMain">
                <tr>
                    <th>Номер заказа</th>
                    <th>Артикул товара</th>
                    <th>Количество товаров</th>
                    <th>Сумма (руб.)</th>
                    <th>Дата</th>
                    <th>Действия</th>
                </tr>
                <c:forEach items="${requestScope.orders}" var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.productId}</td>
                        <td>${order.productQuantity}</td>
                        <td>${order.totalAmount}</td>
                        <td>${order.orderDate}</td>
                        <td><a href="${pageContext.request.contextPath}/my_order_info?id=${order.orderId}">Подробнее</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="#" onclick="history.back();">Назад</a>
        </div>
    </body>
</html>
