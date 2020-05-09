<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="position" scope="session" value="${sessionScope.employee.employeePosition}"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Информация о товаре</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Информация о товаре</h1>

                <table class="tableForm">
                    <tr>
                        <th>Артикул</th>
                        <td>${requestScope.product.productId}</td>
                    </tr>
                    <tr>
                        <th>Номер поставки</th>
                        <td>${requestScope.product.deliveryId}</td>
                    </tr>
                    <tr>
                        <th>Тип</th>
                        <td>${requestScope.product.productType}</td>
                    </tr>
                    <tr>
                        <th>Наименование</th>
                        <td>${requestScope.product.productName}</td>
                    </tr>
                    <tr>
                        <th>Описание</th>
                        <td>${requestScope.product.productDescription}</td>
                    </tr>
                    <tr>
                        <th>Количество</th>
                        <td>${requestScope.product.productQuantity}</td>
                    </tr>
                    <tr>
                        <th>Стоимость закупки (руб.)</th>
                        <td>${requestScope.product.purchasePrice}</td>
                    </tr>
                    <tr>
                        <th>Стоимость продажи (руб.)</th>
                        <td>${requestScope.product.sellingPrice}</td>
                    </tr>
                </table>
            <a href="${pageContext.request.contextPath}/selling/order_create?id=${requestScope.product.productId}">Оформить заказ</a>
            <c:if test="${position == 'MANAGER' || position == 'DIRECTOR' || position == 'ADMINISTRATOR'}">
                <br/>
                <a href="${pageContext.request.contextPath}/management/product_edit?id=${requestScope.product.productId}">Изменить</a>
            </c:if>
            <br/>
            <a href="#" onclick="history.back();">Назад</a>
        </div>
    </body>
</html>
