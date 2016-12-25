<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<table>
    <h1>Registration.</h1>
    <form method="get" action="RegServlet">
        <tr>Регистрация нового пользователя:</tr>
        <tr>
            <td><p align="right">Имя:</p></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><p align="right">Возраст:</p></td>
            <td><input type="number" name="age"></td>
        </tr>
        <tr>
            <td><p align="right">E-mail:</p></td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Добавить"></td>
        </tr>
    </form>
</table>
</body>
<a href="Login.jsp">Назад</a>
</html>