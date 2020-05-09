<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Подробно</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Заказ №<c:out value="${requestScope.orderDetails['order_id']}"/></h1>

            <table class="tableInfo">
                <tr>
                    <th>Артикул товара</th>
                    <td><c:out value="${requestScope.orderDetails['product_id']}"/></td>
                </tr>
                <tr>
                    <th>Наименование товара</th>
                    <td><c:out value="${requestScope.orderDetails['product_name']}"/></td>
                </tr>
                <tr>
                    <th>Количество товара</th>
                    <td><c:out value="${requestScope.orderDetails['product_quantity']}"/></td>
                </tr>
                <tr>
                    <th>Имя продавца</th>
                    <td><c:out value="${requestScope.orderDetails['employee_name']}"/></td>
                </tr>
                <tr>
                    <th>Позиция</th>
                    <td><c:out value="${requestScope.orderDetails['employee_position']}"/></td>
                </tr>
                <tr>
                    <th>Сумма к оплате</th>
                    <td><c:out value="${requestScope.orderDetails['total_amount']}"/></td>
                </tr>
                <tr>
                    <th>Дата заказа</th>
                    <td><c:out value="${requestScope.orderDetails['order_date']}"/></td>
                </tr>
            </table>
            <a href="#" onclick="history.back();">Назад</a>
        </div>
    </body>
</html>
