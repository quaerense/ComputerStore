<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Изменить информацию о товаре</title>
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
            <h1>${requestScope.product.productName}</h1>

            <form action="${pageContext.request.contextPath}/administration/product_edit" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="product_id">Артикул</label></th>
                        <td><input type="number" id="product_id" name="product_id" value="${requestScope.product.productId}" readonly></td>
                    </tr>
                    <tr>
                        <th><label for="delivery_id">Поставка</label></th>
                        <td><input type="number" id="delivery_id" name="delivery_id" min="1" value="${requestScope.product.deliveryId}" required></td>
                    </tr>
                    <tr>
                        <th><label for="type">Тип</label></th>
                        <td>
                            <select id="type" name="type" size="1">
                                <option value="PC">PC</option>
                                <option selected value="LAPTOP">LAPTOP</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="name">Наименование</label></th>
                        <td><input type="text" id="name" name="name" value="${requestScope.product.productName}" required></td>
                    </tr>
                    <tr>
                        <th><label for="description">Описание</label></th>
                        <td><textarea id="description" name="description" required>${requestScope.product.productDescription}</textarea></td>
                    </tr>
                    <tr>
                        <th><label for="quantity">Количество</label></th>
                        <td><input type="number" id="quantity" name="quantity" value="${requestScope.product.productQuantity}" required></td>
                    </tr>
                    <tr>
                        <th><label for="purchase_price">Цена закупки</label></th>
                        <td><input type="number" id="purchase_price" name="purchase_price" min="0" value="${requestScope.product.purchasePrice}" required></td>
                    </tr>
                    <tr>
                        <th><label for="selling_price">Цена продажи</label></th>
                        <td><input type="number" id="selling_price" name="selling_price" min="0" value="${requestScope.product.sellingPrice}" required></td>
                    </tr>
                    <tr class="noBorder">
                        <td class="noBorder" colspan="2"><input type="submit" value="Сохранить"></td>
                    </tr>

                </table>
            </form>

            <p><a href="${pageContext.request.contextPath}/products">Отмена</a></p>
        </div>
    </body>
</html>
