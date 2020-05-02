<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Информация</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>
            Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${sessionScope.employee.employeeName}</a>  (${sessionScope.employee.employeePosition})
            <a class="right" href="${pageContext.request.contextPath}/logout">Выйти</a>
        </div>

        <div class="center">
            <h1>Мои данные</h1>

            <table class="tableInfo">
                    <tr>
                        <th>ID:</th>
                        <td>${sessionScope.employee.employeeId}</td>
                    </tr>
                    <tr>
                        <th>Имя:</th>
                        <td>${sessionScope.employee.employeeName}</td>
                    </tr>
                    <tr>
                        <th>Дата рождения</th>
                        <td>${sessionScope.employee.employeeBirth}</td>
                    </tr>
                    <tr>
                        <th>Позиция:</th>
                        <td>${sessionScope.employee.employeePosition}</td>
                    </tr>
                    <tr>
                        <th>Адрес:</th>
                        <td>${sessionScope.employee.employeeAddress}</td>
                    </tr>
                    <tr>
                        <th>Номер телефона:</th>
                        <td>${sessionScope.employee.phoneNumber}</td>
                    </tr>
                    <tr>
                        <th>Зарплата (руб.)</th>
                        <td>${sessionScope.employee.employeeSalary}</td>
                    </tr>
                </table>
                <a href="${pageContext.request.contextPath}/my_orders">Завершенные заказы</a><br>
                <a href="#" onclick="history.back();">Назад</a>
            </div>
    </body>
</html>
