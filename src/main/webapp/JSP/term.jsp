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
<c:if test="${termNull != '1'}">
    <form action="/term" method="get" id="terms">
        <div class="content-box">
            <div class="terms-filter-box">
                <br>
                <div display="inline">
                    <b>Выбрать семестр:</b>
                    <select name="selectedId"
                            onchange="document.getElementById('terms').submit();">
                        <c:forEach items="${allTerm}" var="t">
                            <option
                                    <c:if test="${t eq term}">selected</c:if>
                                    value="${t.id}">
                                    ${t.name}</option>

                        </c:forEach>
                    </select>
                </div>

                <b>Длительность семестра: ${term.duration}</b>
            </div>
            <a href="termCreating.html" class="action-button"><img class="prefix-button" src="../resources/img/add.png"
                                                                   width="18px" alt="">Создать семестр</a>
            <a href="termModifying.html" class="action-button">Изменить текущий семестр</a>
            <a href="" class="action-button"><img class="prefix-button" src="../resources/img/trash.png" width="18px"
                                                  alt="">Удалить текущий семестр</a>
            <h3>Список дисциплин семестра</h3>
            <table class="students-table">
                <tr>
                    <th>Дисциплина</th>
                </tr>
                <c:forEach items="${discipline}" var="t">
                    <tr>
                        <td>${t.name}</td>
                    </tr>

                </c:forEach>
            </table>

        </div>
    </form>
</c:if>
<footer>
    Copy 2022
</footer>
</body>
</html>
