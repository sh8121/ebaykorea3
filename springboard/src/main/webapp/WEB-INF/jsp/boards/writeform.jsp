<%@page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>list</title>
    </head>
    <body>
    <%--http://localhost:8080/boards--%>
    <h1>Board writeform!</h1>

    <form method="post" action="/boards">
        name : ${name}<br>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        title : <input type="text" name="title"><br>
        <textarea name="content" cols="50" rows="5"></textarea>
        <input type="submit">
    </form>
    </body>
</html>