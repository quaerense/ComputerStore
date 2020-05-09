<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Добавить товар</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Добавить товар</h1>

            <form action="${pageContext.request.contextPath}/management/product_create" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="delivery_id">Поставка</label></th>
                        <td><input type="number" id="delivery_id" name="delivery_id" min="1" required></td>
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
                        <td><input type="text" id="name" name="name" required></td>
                    </tr>
                    <tr>
                        <th><label for="description">Описание</label></th>
                        <td><textarea id="description" name="description" required></textarea></td>
                    </tr>
                    <tr>
                        <th><label for="quantity">Количество</label></th>
                        <td><input type="number" id="quantity" name="quantity" required></td>
                    </tr>
                    <tr>
                        <th><label for="purchase_price">Цена закупки</label></th>
                        <td><input type="number" id="purchase_price" name="purchase_price" min="0" required></td>
                    </tr>
                    <tr>
                        <th><label for="selling_price">Цена продажи</label></th>
                        <td><input type="number" id="selling_price" name="selling_price" min="0" required></td>
                    </tr>
                    <tr class="noBorder">
                        <td class="noBorder" colspan="2"><input type="submit" value="Сохранить"></td>
                    </tr>
                </table>
            </form>
            <a href="${pageContext.request.contextPath}/selling">Отмена</a>
        </div>
    </body>
</html>
