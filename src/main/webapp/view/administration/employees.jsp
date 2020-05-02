<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Работники</title>
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
            <h1>Работники</h1>

            <a href="${pageContext.request.contextPath}/administration/employee_create">Добавить работника</a>
            <br/>
            <br/>
            <table class="tableMain">
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Дата Рождения</th>
                    <th>Позиция</th>
                    <th>Адрес</th>
                    <th>Номер телефона</th>
                    <th>Зарплата (руб.)</th>
                    <th>Действия</th>
                </tr>
                <c:forEach items="${requestScope.employees}" var="employee">

                    <tr>
                        <td>${employee.employeeId}</td>
                        <c:choose>
                            <c:when test="${sessionScope.employee.employeeId == employee.employeeId}">
                                <td>${employee.employeeName} <b>(Это Вы)</b></td>
                            </c:when>
                            <c:otherwise>
                                <td>${employee.employeeName}</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${employee.employeeBirth}</td>
                        <td>${employee.employeePosition}</td>
                        <td>${employee.employeeAddress}</td>
                        <td>${employee.phoneNumber}</td>
                        <td>${employee.employeeSalary}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/administration/employee_orders?id=${employee.employeeId}">Продажи</a><br/>
                            <a href="${pageContext.request.contextPath}/administration/employee_edit?id=${employee.employeeId}">Изменить</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
