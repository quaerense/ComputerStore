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
            <h1>Товары</h1>
            <form action="${pageContext.request.contextPath}/product_search">
                <label><input type="number" name="id" placeholder="Поиск товара по ID"></label>
                <input type="submit" value="Поиск">
            </form>

            <a href="${pageContext.request.contextPath}/administration/product_create">Добавить товар</a>
            <br/>
            <br/>
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
                            <a href="${pageContext.request.contextPath}/order_create?id=${product.productId}">Оформить заказ</a>
                            <br/>
                            <a href="${pageContext.request.contextPath}/administration/product_edit?id=${product.productId}">Изменить</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>