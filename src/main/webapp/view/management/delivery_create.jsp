<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Добавить поставку</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Добавить поставку</h1>

            <form action="${pageContext.request.contextPath}/management/delivery_create" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="supplier_id">ID <a href="${pageContext.request.contextPath}/management/suppliers">поставщика</a></label></th>
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
            <a href="${pageContext.request.contextPath}/management/deliveries">Отмена</a>
        </div>
    </body>
</html>
