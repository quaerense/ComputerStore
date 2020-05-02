<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Поставщики</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a>
            (${sessionScope.employee.employeePosition})
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
            <h1>Поставки</h1>

            <a href="${pageContext.request.contextPath}/administration/delivery_create">Добавить поставку</a>
            <br/>
            <br/>
            <table class="tableMain">
                <tr>
                    <th>ID поставки</th>
                    <th>ID поставщика</th>
                    <th>Дата поставки</th>
                    <th>Действия</th>
                </tr>
                <c:forEach items="${requestScope.deliveries}" var="delivery">
                    <tr>
                        <td>${delivery.deliveryId}</td>
                        <td>${delivery.supplierId}</td>
                        <td>${delivery.deliveryDate}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/administration/delivery_info?id=${delivery.deliveryId}">Подробнее</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
