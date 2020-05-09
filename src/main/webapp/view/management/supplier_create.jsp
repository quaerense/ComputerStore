<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Добавить поставщика</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Добавить поставщика</h1>

            <form action="${pageContext.request.contextPath}/management/supplier_create" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="name">Наименование</label></th>
                        <td><input type="text" id="name" name="name" min="1" required></td>
                    </tr>
                    <tr>
                        <th><label for="representative">Представитель</label></th>
                        <td><input type="text" id="representative" name="representative" required></td>
                    </tr>
                    <tr>
                        <th><label for="address">Адрес</label></th>
                        <td><input type="text" id="address" name="address" required></td>
                    </tr>
                    <tr>
                        <th><label for="phone_number">Номер телефона</label></th>
                        <td><input type="text" id="phone_number" name="phone_number" required></td>
                    </tr>
                    <tr class="noBorder">
                        <td class="noBorder" colspan="2"><input type="submit" value="Сохранить"></td>
                    </tr>
                </table>
            </form>
            <a href="${pageContext.request.contextPath}/management/suppliers">Отмена</a>
        </div>
    </body>
</html>
