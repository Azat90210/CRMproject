<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?header('Content-Type: text/html; charset=utf-8');?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../resources/styles/styles.css">
    <script src="../resources/js/function.js" charset="UTF-8"></script>
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
            <a href="/login" class="gradient-button-leftside">Войти</a>
            <a href="/registration" class="gradient-button-rightside">Регистрация</a>
        </div>
    </c:if>
</div>
<hr>
<div class="navigation-box">
    <nav class="ui-helper-clearfix">
        <ul class="ui-helper-clearfix">
            <li><a href="/home" class="gradient-button">Главная</a></li>
            <li><a href="/student" class="gradient-button">Студенты</a></li>
            <li><a href="/disciplin" class="gradient-button">Дисциплины</a></li>
            <li><a href="/term" class="gradient-button">Семестры</a></li>
            <li><a href="/contact" class="gradient-button">Контакты</a></li>
        </ul>
        <a href="#" id="pull">Меню</a>
    </nav>
</div>
<c:if test="${RoleId==1}">
    <div class="grade-box">
        <a href="/news_creat" class="action-button"><img class="prefix-button"
                                                         src="../resources/img/add.png"
                                                         width="18px" alt="">Добавить объявление</a>
        <a class="action-button" href="#" onclick="updateNews()"><img class="prefix-button"
                                                                      src="../resources/img/pencil.png"
                                                                      width="18px" alt="">Редактировать объявление</a>

        <a class="action-button" href="#" onclick="deleteNews()"><img class="prefix-button"
                                                                      src="../resources/img/trash.png"
                                                                      width="18px" alt="">Удалить объявление</a>


    </div>
</c:if>
<c:forEach items="${allNews}" var="s">
    <div class="content-box">
        <div class="inline-box">
            <h1 display="inline">
                <c:if test="${RoleId==1}">
                    <input type="checkbox" value="${s.id}" name="idNews">
                </c:if>
                    ${s.name}

            </h1>
        </div>
            ${s.text}
    </div>
</c:forEach>

<form action="/news_update" method="get" id="updateNewsForm">
    <input type="hidden" id="updateNewsHidden" name="idNews">
</form>

<form action="/news_delete" method="post" id="deleteNewsForm">
    <input type="hidden" id="deleteNewsHidden" name="idNews">
</form>

<footer>
    Copy 2022
</footer>
</body>
</html>