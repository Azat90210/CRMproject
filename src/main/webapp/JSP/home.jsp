<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <div class="title-login">
        <a href="" class="gradient-button-leftside">Войти</a>
        <a href="" class="gradient-button-rightside">Регистрация</a>
    </div>
</div>
<hr>
<div class="navigation-box">
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="/disciplin" class="gradient-button">Дисциплины</a>
    <a href="/term" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="grade-box">
    <a href="/news_creat" class="action-button"><img class="prefix-button" src="../resources/img/add.png"
                                                     width="18px" alt="">Добавить объявление</a>
    <a href="#" class="action-button" onclick="deleteNews()"><img class="prefix-button"
                                                                  src="../resources/img/trash.png"
                                                                  width="18px" alt="">Удалить объявление</a>
</div>
<div class="content-box">
<table>
    <tr>
        <th></th>
        <th>Заголовок</th>
        <th>Текст</th>
    </tr>

    <c:forEach items="${allNews}" var="s">
        <tr>
            <th>
                <input type="checkbox" value="${s.id}" name="idNews">
            </th>

            <td>${s.name}</td>
            <td>${s.text}</td>
        </tr>
    </c:forEach>

</table>
</div>
<form action="/news_delete" method="post" id="deleteNewsForm">
    <input type="hidden" id="deleteNewsHidden" name="idNews">
</form>
<footer>
    Copy 2022
</footer>
</body>
</html>