<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../resources/styles/styles.css">
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
    </div>
</div>
<hr>
<div class="content-box">
    <h1>Регистрация</h1>
    <form action="/registration" method="post">
        <table>
            <tr>
                <td>Напишите Ваше имя</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>Напишите Вашу фамилию</td>
                <td><input width="200px" type="text" name="lastName"></td>
            </tr>
            <tr>
                <td>Выберите роль</td>
                <td>
                    <select name="roleId">
                        <c:forEach items="${allRole}" var="t">
                            <option value="${t.id}">
                                    ${t.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Придумайте логин</td>
                <td><input type="text" name="login"></td>
            </tr>

            <tr>
                <td>Придумайте пароль</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <input type="submit" value="Регистрация" class="gradient-button">
    </form>
    <c:if test="${Error==1}">
        <p> Поля не должны быть пустыми!</p>
    </c:if>

    <c:if test="${ErrorNewLogin==1}">
        <p> Пользователь с таким логином уже существует, придумайте новый логин!</p>
    </c:if>

</div>
<footer>
    Copy 2022
</footer>
</body>
</html>





