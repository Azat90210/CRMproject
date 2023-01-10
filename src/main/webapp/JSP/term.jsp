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
        <a href="/logout" class="gradient-button">Выйти</a>
    </div>

    <div class="title-box">
        ${FirstName} ${LastName} <br> ${RoleName}
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
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <h1>Cеместры:</h1>
        <form action="/term" method="get" id="termForm">
            <table class="students-table">
                <tr>
                    <td>
                        <input type="hidden" name="idTerm" value="${termId.id}">
                        <div class="grade-box">
                            <div display="inline">
                                <b>Выбрать семестр:</b>
                                <select name="selectedId"
                                        onchange="document.getElementById('termForm').submit();">
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
                    </td>


                </tr>
            </table>
            <table class="students-table">
                <tr>
                    <th>Дисциплины:</th>
                </tr>
                <c:forEach items="${termDiscipline}" var="t">
                    <tr>
                        <td>${t.disciplineName}</td>
                    </tr>

                </c:forEach>
            </table>
        </form>


</div>
<footer>
    Copy 2022
</footer>
</body>
</html>
