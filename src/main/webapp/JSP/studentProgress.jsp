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
    <div>
        <div>
            <a href="/logout" class="gradient-button">Выйти</a>
        </div>
        <div>
            ${FirstName} ${LastName} <br> ${RoleName}
        </div>
    </div>

    <c:if  test="${isLogin !=1}">
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
    <h3>Отображена успеваемость для следующего студента</h3>

    <table class="students-table">
        <tr>

            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
        </tr>

        <tr>
            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.group}</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${student.data_enter}"/></td>
        </tr>

    </table>
    <c:if test="${termNull != '1'}">
    <form action="/student_progress" method="get" id="studentProgressForm">
        <table class="students-table">
            <tr>
                <td>
                    <input type="hidden" name="idStudent" value="${student.id}">
                    <div class="grade-box">
                        <div display="inline">
                            <b>Выбрать семестр:</b>
                            <select name="selectedId"
                                    onchange="document.getElementById('studentProgressForm').submit();">
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
                <td>Средняя оценка: ${averageMark}</td>

            </tr>
        </table>
        <table class="students-table">
            <tr>
                <th>Дисциплина</th>
                <th>Оценка</th>
            </tr>
            <c:forEach items="${disciplineMark}" var="t">
                <tr>
                    <td>${t.name}</td>
                    <td>${t.mark}</td>
                </tr>

            </c:forEach>
        </table>
    </form>
    </c:if>
<c:if test="${termNull == '1'}">
    <h2>У данного студента отсутствуют семестры!</h2>

</c:if>
</div>
<footer>
    Copy 2022
</footer>
</body>
</html>
