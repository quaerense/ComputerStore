<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Подробно</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a>  (${sessionScope.employee.employeePosition})
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

            <h1>Поставка №${requestScope.delivery.deliveryId}</h1>

            <table class="tableInfo">
                <tr>
                    <th>Номер поставщика</th>
                    <td>${requestScope.delivery.supplierId}</td>
                </tr>
                <tr>
                    <th>Наименование поставщика</th>
                    <td>${requestScope.supplierName}</td>
                </tr>
                <tr>
                    <th>Дата поставки</th>
                    <td>${requestScope.delivery.deliveryDate}</td>
                </tr>
            </table>
            <a href="#" onclick="history.back();">Назад</a>
        </div>
    </body>
</html>
