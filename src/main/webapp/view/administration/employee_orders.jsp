<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Продажи</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a> (${sessionScope.employee.employeePosition})
            <a class="right" href="${pageContext.request.contextPath}/logout">Выйти</a>
        </div>
        <br/>
        <div class="center">
            <a href="${pageContext.request.contextPath}/administration">Работники</a>
            <a href="${pageContext.request.contextPath}/products">Товары</a>
            <a href="${pageContext.request.contextPath}/administration/suppliers">Поставщики</a>
            <a href="${pageContext.request.contextPath}/administration/deliveries">Поставки</a>
            <a href="${pageContext.request.contextPath}/administration/orders">Все заказы</a>
        </div>
        <div class="center">
            <h1>${requestScope.employee.employeeName}</h1>

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
                        <td><a href="${pageContext.request.contextPath}/administration/employee_order_info?id=${order.orderId}">Подробнее</a></td>
                    </tr>
                </c:forEach>
            </table>

            <a href="#" onclick="history.back();">Назад</a>
        </div>
    </body>
</html>
