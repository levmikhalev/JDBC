<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<table>
    <form method="get" action="AddServlet">
        <tr>Введите данные:</tr>
        <tr>
            <td><p align="right">Имя:</p></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><p align="right">Возраст:</p></td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td><p align="right">E-mail:</p></td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td><input type="submit" value="отправить"></td>
        </tr>
    </form>
</table>

<table>
    <form method="get" action="ShowServlet">
    <c:forEach var="person" items="${users.users}">
        <tr>
            <td>${person.id1}</td>
            <td>${person.name1}</td>
            <td>${person.age1}</td>
            <td>${person.email1}</td>
        </tr>
    </c:forEach>
    </form>
</table>
</body>
</html>