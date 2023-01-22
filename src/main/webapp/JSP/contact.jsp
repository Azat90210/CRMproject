<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../resources/styles/styles.css">
    <script src="../resources/js/function.js"></script>
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
    </div>
    <div>
        <div>
            <a href="/logout" class="gradient-button">Выйти</a>
        </div>
        <div>
            ${FirstName} ${LastName} <br> ${RoleName}
        </div>
    </div>
    <c:if test="${isLogin !=1}">
        <div class="title-login">
            <a href="" class="gradient-button-leftside">Войти</a>
            <a href="" class="gradient-button-rightside">Регистрация</a>
        </div>
    </c:if>
</div>
<hr>
<div class="navigation-box">
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="/disciplin" class="gradient-button">Дисциплины</a>
    <a href="/term" class="gradient-button">Семестры</a>
    <a href="/contact" class="gradient-button">Контакты</a>
</div>
<h3>Контакты</h3>
<table class="students-table">
    <tr>
        <th></th>
    </tr>
    <tr>
        <td>Приемная ректора: <br> (843) 511-11-11</td>
    </tr>
    <tr>
        <td>Приемная комиссия: <br> (843) 511-11-12<br> (843) 511-11-13</td>
    </tr>
    <tr>
        <td>Электронная почта: <br> Education@mail.ru</td>
    </tr>

</table>
<footer>
    Copy 2022
</footer>
</body>
</html>