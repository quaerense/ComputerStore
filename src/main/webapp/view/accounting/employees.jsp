<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Работники</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Работники</h1>

            <a href="${pageContext.request.contextPath}/accounting/employee_create">Добавить работника</a>
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
                            <a href="${pageContext.request.contextPath}/accounting/employee_orders?id=${employee.employeeId}">Продажи</a><br/>
                            <a href="${pageContext.request.contextPath}/accounting/employee_edit?id=${employee.employeeId}">Изменить</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
