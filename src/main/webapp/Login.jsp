<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<table>
    <h1>Login.</h1>
    <form method="get" action="LoginServlet">
        <tr>Для выполнения входа введите логин и пароль:</tr>
        <tr>
            <td><p align="right">Логин:</p></td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td><p align="right">Пароль:</p></td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Войти"></td>
        </tr>
    </form>
</table>
${textA}<br>
</body>
</html>