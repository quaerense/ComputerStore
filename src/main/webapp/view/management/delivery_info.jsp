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
