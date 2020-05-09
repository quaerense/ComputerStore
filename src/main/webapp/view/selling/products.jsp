<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="position" scope="session" value="${sessionScope.employee.employeePosition}"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Товары</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Товары</h1>

            <form action="${pageContext.request.contextPath}/selling/product_info">
                <label><input type="number" name="id" placeholder="Поиск товара по ID" required></label>
                <input type="submit" value="Поиск">
            </form>
            <c:if test="${position == 'MANAGER' || position == 'DIRECTOR' || position == 'ADMINISTRATOR'}">
                <a href="${pageContext.request.contextPath}/management/product_create">Добавить товар</a>
                <br/>
                <br/>
            </c:if>
            <table class="tableMain">
                <tr>
                    <th>Артикул</th>
                    <th>Номер поставки</th>
                    <th>Тип</th>
                    <th>Наименование</th>
                    <th>Описание</th>
                    <th>Количество</th>
                    <th>Стоимость закупки (руб.)</th>
                    <th>Стоимость продажи (руб.)</th>
                    <th>Действия</th>
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
                        <td>
                            <a href="${pageContext.request.contextPath}/selling/product_info?id=${product.productId}">Подробнее</a>
                            <br/>
                            <a href="${pageContext.request.contextPath}/selling/order_create?id=${product.productId}">Оформить заказ</a>
                            <c:if test="${position == 'MANAGER' || position == 'DIRECTOR' || position == 'ADMINISTRATOR'}">
                                <br/>
                                <a href="${pageContext.request.contextPath}/management/product_edit?id=${product.productId}">Изменить</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>