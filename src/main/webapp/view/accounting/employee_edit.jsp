<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Изменить информацию о работнике</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>${requestScope.employee.employeeName}</h1>

            <form action="${pageContext.request.contextPath}/accounting/employee_edit" method="post">
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
            <a href="${pageContext.request.contextPath}/accounting">Отмена</a>
        </div>
    </body>
</html>
