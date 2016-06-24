<%@ page import="ru.polinabevad.bugtracker.taskboard.TaskList" %>
<%@ page import="ru.polinabevad.bugtracker.core.Task" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Стартовая страница Баг-трекера</title>

    <link href="<c:url value="/resources/clearcss.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/index.css"/>" rel="stylesheet">


</head>
<body>
<div class="main">

    <div class="header"> Здесь будет заголовок с переходом на главную + кнопки:
        <button name="create">Войти\Зарегистрироваться</button>
        <button name="create">FAQ</button>
        <br>

    </div>

    <div class="center">
        <div class="leftpane">
            Здесь будут кнопки:
            <button name="create">Создать задачу</button> <!--<a href="<c:url value='/new' />">Add New Task</a>-->
            <br><br>
            <button name="taskList">Список задач</button>
            <br> <br>
            <button name="taskFilter">Фильтр задач</button>
            <br> <br>

        </div>
        <div class="content">
            Здесь будет выводиться само приложение: список задач, при клике на задаче - содержимое задачи,
            при этом кнопки поменяются - добавятся кнопки для комментариев и перехода назад. <br>
            Нужны еще страницы:<br>
            форма новой задачи, форма редактирования задачи, форма просмотра задачи.<br>
            форма списка задач, FAQ, форма логина и форма регистрации
            (возможно просто два поля в заголовке с кнопками Войти\Зарегистрироваться).<br>

            <h2>List of Tasks</h2>
            <table>
                <tr>
                    <td>ID</td>
                    <td>Название</td>
                    <td>Дата создания</td>
                    <td>Автор</td>
                    <td>Ответственный</td>
                    <td>Статус</td>
                    <td></td>
                </tr>
                <c:forEach items="${tasks}" var="task">
                    <tr>
                        <td>${task.taskId}</td>
                        <td>${task.taskName}</td>
                        <td>${task.taskCreateDate.time}</td>
                        <td>${task.taskAuthor.login}</td>
                        <td>${task.taskAppointer.login}</td>
                        <td>${task.taskStatus.name()}</td>
                        <!--<td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
                        <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a></td>-->
                    </tr>
                </c:forEach>
            </table>
            <br/>
        </div>

        <div class="rigthpane">
            Здесь будут блоки с названиями задач, перечисление и ссылка: <br>
            "Мои задачи (последние 5)"<br>
            "Новые задачи (последние 5)<br>
        </div>

    </div>


    <div class="footer">
        Здесь будет информация о приложении: контакты, год.
    </div>
</div>


</body>
</html>
