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
    <div class="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div class="center">
        <div class="leftpane">
            <jsp:include page="leftpane.jsp"/>
        </div>
        <div class="content">
            <h2>Список задач:</h2>
            <table>
                <tr>
                    <td>ID</td>
                    <td>Название</td>
                    <td>Дата создания</td>
                    <td>Автор</td>
                    <td>Ответственный</td>
                    <td>Статус</td>
                </tr>
                <c:forEach items="${tasks}" var="task">
                    <tr>
                        <td>${task.taskId}</td>
                        <td>${task.taskName}</td>
                        <td>${task.taskCreateDate.time.date}.${task.taskCreateDate.time.month+1}.${task.taskCreateDate.time.year+1900}</td>
                        <td>${task.taskAuthor.login}</td>
                        <td>${task.taskAppointer.login}</td>
                        <td>${task.taskStatus.statusName}</td>
                        <!--<td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
                        <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a></td>-->
                    </tr>
                </c:forEach>
            </table>
            <br/>
                Добавить еще: при клике на задаче - содержимое задачи,
                при этом кнопки поменяются - добавятся кнопки для комментариев и перехода назад. <br>
                Нужны еще страницы:<br>
                форма новой задачи, форма редактирования задачи, форма просмотра задачи.<br>
                форма списка задач, FAQ, форма логина и форма регистрации
                (возможно просто два поля в заголовке с кнопками Войти\Зарегистрироваться).<br>

        </div>
        <div class="rigthpane">
            <jsp:include page="rightpane.jsp"/>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>
