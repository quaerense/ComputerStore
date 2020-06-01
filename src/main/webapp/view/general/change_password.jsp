<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Изменить пароль</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
    <c:import url="/resource/top_bar.jsp" />
        <div class="center">

            <h1>Изменить пароль</h1>

            <form action="${pageContext.request.contextPath}/change_password" method="post">
                <table class="tableInfo">
                    <tr>
                        <th><label for="oldPassword">Старый пароль</label></th>
                        <td><input type="password" id="oldPassword" name="oldPassword"></td>
                    </tr>
                    <tr>
                        <th><label for="newPassword1">Новый пароль</label></th>
                        <td><input type="password" id="newPassword1" name="newPassword1"></td>
                    </tr>
                    <tr>
                        <th><label for="newPassword2">Подтвердите пароль</label></th>
                        <td><input type="password" id="newPassword2" name="newPassword2"></td>
                    </tr>
                    <tr class="noBorder">
                        <td class="noBorder" colspan="2"><input type="submit" value="Сохранить"></td>
                    </tr>
                </table>
            </form>
            <a href="${pageContext.request.contextPath}/my_info">Отмена</a>
        </div>
    </body>
</html>
