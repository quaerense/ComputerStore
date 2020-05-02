<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Вход</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="center">
            <h1>Вход</h1>

            <form action="${pageContext.request.contextPath}/login" method="post">
                <table class="tableForm">
                    <tr class="noBorder"><td class="noBorder"><label for="id">ID:</label><br/></td></tr>
                    <tr class="noBorder"><td class="noBorder"><input name="id" id="id" type="text" required></td></tr>
                    <tr class="noBorder"><td class="noBorder"><label for="password">Пароль:</label></td></tr>
                    <tr class="noBorder"><td class="noBorder"><input name="password" id="password" type="password" required></td></tr>
                    <tr class="noBorder"><td class="noBorder"><input type="submit" value="Войти"></td></tr>
                </table>
            </form>
        </div>
    </body>
</html>
