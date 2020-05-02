<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Добавить поставку</title>
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
            <h1>Добавить поставку</h1>

            <form action="${pageContext.request.contextPath}/administration/delivery_create" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="supplier_id">ID <a href="${pageContext.request.contextPath}/administration/suppliers">поставщика</a></label></th>
                        <td><input type="number" id="supplier_id" name="supplier_id" required></td>
                    </tr>
                    <tr>
                        <th><label for="date">Дата поставки</label></th>
                        <td><input type="date" id="date" name="date" required></td>
                    </tr>
                    <tr class="noBorder">
                        <td class="noBorder" colspan="2"><input type="submit" value="Сохранить"></td>
                    </tr>
                </table>
            </form>

            <p><a href="${pageContext.request.contextPath}/administration/deliveries">Отмена</a></p>
        </div>
    </body>
</html>
