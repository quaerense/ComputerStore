<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Обо мне</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>${sessionScope.employee.employeeName}</h1>

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
            <a href="${pageContext.request.contextPath}/change_password">Изменить пароль</a>
            <br />
            <a href="#" onclick="history.back();">Назад</a>
        </div>
    </body>
</html>
