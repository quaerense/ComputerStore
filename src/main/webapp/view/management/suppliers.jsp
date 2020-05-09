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
            <h1>Поставщики</h1>

            <a href="${pageContext.request.contextPath}/management/supplier_create">Добавить поставщика</a>
            <br/>
            <br/>
            <table class="tableMain">
                <tr>
                    <th>ID</th>
                    <th>Наименование</th>
                    <th>Представитель</th>
                    <th>Адрес</th>
                    <th>Номер телефона</th>
                    <th>Действия</th>
                </tr>
                <c:forEach items="${requestScope.suppliers}" var="supplier">
                    <tr>
                        <td>${supplier.supplierId}</td>
                        <td>${supplier.supplierName}</td>
                        <td>${supplier.supplierRepresentative}</td>
                        <td>${supplier.supplierAddress}</td>
                        <td>${supplier.phoneNumber}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/management/supplier_edit?id=${supplier.supplierId}">Изменить</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
