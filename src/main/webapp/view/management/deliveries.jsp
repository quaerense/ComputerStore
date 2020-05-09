<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Поставщики</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Поставки</h1>

            <form action="${pageContext.request.contextPath}/management/delivery_info">
                <label><input type="number" name="id" placeholder="Поиск поставки по ID" required></label>
                <input type="submit" value="Поиск">
            </form>

            <a href="${pageContext.request.contextPath}/management/delivery_create">Добавить поставку</a>
            <br/>
            <br/>
            <table class="tableMain">
                <tr>
                    <th>ID поставки</th>
                    <th>ID поставщика</th>
                    <th>Дата поставки</th>
                    <th>Действия</th>
                </tr>
                <c:forEach items="${requestScope.deliveries}" var="delivery">
                    <tr>
                        <td>${delivery.deliveryId}</td>
                        <td>${delivery.supplierId}</td>
                        <td>${delivery.deliveryDate}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/management/delivery_info?id=${delivery.deliveryId}">Подробнее</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
