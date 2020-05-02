<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Изменить информацию о работнике</title>
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
            <h1>${requestScope.employee.employeeName}</h1>

            <form action="${pageContext.request.contextPath}/administration/employee_edit" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="id">ID</label></th>
                        <td><input type="number" id="id" name="id" value="${requestScope.employee.employeeId}" readonly></td>
                    </tr>
                    <tr>
                        <th><label for="name">Имя</label></th>
                        <td><input type="text" id="name" name="name" value="${requestScope.employee.employeeName}" required></td>
                    </tr>
                    <tr>
                        <th><label for="birth">Дата рождения</label></th>
                        <td><input type="date" id="birth" name="birth" value="${requestScope.employee.employeeBirth}" required></td>
                    </tr>
                    <tr>
                        <th><label for="position">Позиция</label></th>
                        <td>
                            <select id="position" name="position" size="1">
                                <option value="ADMINISTRATOR">ADMINISTRATOR</option>
                                <option selected value="SELLER">SELLER</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="address">Адрес</label></th>
                        <td><input type="text" id="address" name="address" value="${requestScope.employee.employeeAddress}" required></td>
                    </tr>
                    <tr>
                        <th><label for="phone_number">Номер телефона</label></th>
                        <td><input type="text" id="phone_number" name="phone_number" value="${requestScope.employee.phoneNumber}" required></td>
                    </tr>
                    <tr>
                        <th><label for="salary">Зарплата (руб.)</label></th>
                        <td><input type="number" id="salary" name="salary" value="${requestScope.employee.employeeSalary}" required></td>
                    </tr>
                    <tr class="noBorder">
                        <td class="noBorder" colspan="2"><input type="submit" value="Сохранить"></td>
                    </tr>
                </table>
            </form>

            <p><a href="${pageContext.request.contextPath}/administration">Отмена</a></p>
        </div>
    </body>
</html>
