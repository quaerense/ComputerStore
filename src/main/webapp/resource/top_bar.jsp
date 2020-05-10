<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="employee" scope="session" value="${sessionScope.employee}"/>

<div>
    Вы вошли как: <a href="${pageContext.request.contextPath}/my_info">${employee.employeeName}</a>
    (${employee.employeePosition})
    <a class="right" href="${pageContext.request.contextPath}/logout">Выйти</a>
</div>
<br/>
<div class="center">
    <c:if test="${employee.employeePosition == 'SELLER'}">
        <a href="${pageContext.request.contextPath}/selling">Товары</a>
        <a href="${pageContext.request.contextPath}/selling/my_orders">Мои заказы</a>
    </c:if>
    <c:if test="${employee.employeePosition == 'MANAGER'}">
        <a href="${pageContext.request.contextPath}/management">Поставщики</a>
        <a href="${pageContext.request.contextPath}/management/deliveries">Поставки</a>
        <a href="${pageContext.request.contextPath}/selling">Товары</a>
        <a href="${pageContext.request.contextPath}/selling/my_orders">Мои заказы</a>
    </c:if>
    <c:if test="${employee.employeePosition == 'ACCOUNTANT'}">
        <a href="${pageContext.request.contextPath}/accounting">Работники</a>
        <a href="${pageContext.request.contextPath}/accounting/orders">Все заказы</a>
    </c:if>
    <c:if test="${employee.employeePosition == 'DIRECTOR' || employee.employeePosition == 'ADMINISTRATOR'}">
        <a href="${pageContext.request.contextPath}/accounting">Работники</a>
        <a href="${pageContext.request.contextPath}/management">Поставщики</a>
        <a href="${pageContext.request.contextPath}/management/deliveries">Поставки</a>
        <a href="${pageContext.request.contextPath}/selling">Товары</a>
        <a href="${pageContext.request.contextPath}/selling/my_orders">Мои заказы</a>
        <a href="${pageContext.request.contextPath}/accounting/orders">Все заказы</a>
    </c:if>
</div>
