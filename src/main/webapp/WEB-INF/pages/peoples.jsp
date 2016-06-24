<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все пользователи Баг-трекера</title>
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
            <h2>Список пользователей:</h2>
            <table>
                <tr>
                    <td>ID</td>
                    <td>Логин</td>
                    <td>Дата регистрации</td>
                    <td>email</td>
                </tr>
                <c:forEach items="${peoples}" var="people">
                    <tr>
                        <td>${people.userId}</td>
                        <td>${people.login}</td>
                        <td>${people.regDate.time.date}.${people.regDate.time.month+1}.${people.regDate.time.year+1900}</td>
                        <td>${people.email}</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
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
