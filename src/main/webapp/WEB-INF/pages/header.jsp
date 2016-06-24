<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Здесь будет заголовок с переходом на главную + кнопки: Войти\Зарегистрироваться, FAQ <br>
<a href="<c:url value='/tasks' />" class="button">Перейти к задачам</a>
<a href="<c:url value='/peoples' />" class="button">Перейти к пользователям</a>
</body>
</html>
