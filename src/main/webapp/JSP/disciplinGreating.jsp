<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href= "../resources/styles/styles.css">
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

  <div class="title-login">
    <a href="" class="gradient-button-leftside">Войти</a>
    <a href="" class="gradient-button-rightside">Регистрация</a>
  </div>
</div>
<hr>
<div class="navigation-box">
  <a href=/home" class="gradient-button">Главная</a>
  <a href="/student" class="gradient-button">Студенты</a>
  <a href="/disciplin" class="gradient-button">Дисциплины</a>
  <a href="terms.html" class="gradient-button">Семестры</a>
  <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
  <h3>Создание новой дисциплины</h3>
  <form action="/disciplin_creat" method="post">
    <table>
      <tr>
        <td>Наименование</td>
        <td><input type="text" name="disciplinName" id="1"></td>
      </tr>
      </table>
      <input type="submit" value="Сохранить" class="gradient-button">
  </form>
  <c:if test="${Error==1}">
    <p> Поля не должны быть пустыми</p>
  </c:if>
</div>
<footer>
  Copy 2022
</footer>
</body>
</html>