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
        <a href="/logout" class="gradient-button">Выйти</a>
    </div>

    <div class="title-box">
        ${RoleName.firstName} ${RoleName.lastName} <br> ${RoleName.name}
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

<c:if test="${RoleId!=3}">
        <a href="#" class="action-button" onclick="progressStudent()">Посмотреть успеваемость</a>
</c:if>
    <c:if test="${RoleId==1}">
        <a href="/student_creat" class="action-button"><img class="prefix-button" src="../resources/img/add.png"
                                                            width="18px" alt="">Добавить нового студента</a>

        <a href="#" class="action-button" onclick="deleteStudents()"><img class="prefix-button"
                                                                          src="../resources/img/trash.png"
                                                                          width="18px" alt="">Удалить студента</a>
    </c:if>
    <table class="students-table">
        <tr>
            <th></th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
        </tr>

        <c:forEach items="${allStudents}" var="s">
            <tr>
                <th>
                    <input type="checkbox" value="${s.id}" name="idStudent">
                </th>
                <td>${s.surname}</td>
                <td>${s.name}</td>
                <td>${s.group}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${s.data_enter}"/></td>
                <td display="inline">
                    <a class="editing-box-button" href=""><img src="../resources/img/pencil.png" width="18px"
                                                               alt=""></a>
                    <a class="trashing-box-button" href=""><img src="../resources/img/trash.png" width="18px"
                                                                alt=""></a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<form action="/student_delete" method="post" id="deleteStudentForm">
    <input type="hidden" id="deleteStudentHidden" name="idStudent">
</form>
<form action="/student_progress" method="get" id="progressStudentForm">
    <input type="hidden" id="progressStudentHidden" name="idStudent">
</form>
<footer>
    Copy 2022
</footer>
</body>
</html>
