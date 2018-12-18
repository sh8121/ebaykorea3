<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <!-- web api 호출시 사용 -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Join form</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h1>가입 폼</h1>
<hr>
<form method="post" action="/members/join">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    name : <input type="text" name="name"><br/>
    email : <input type="text" name="id"><br>
    password : <input type="password" name="password"><br>
    <input type="submit" value="가입">
</form>
<script type="text/javascript">
    <c:if test="${message != null}">
        $(document).ready(function(){
            alert("${message}");
        });
    </c:if>
</script>
</body>
</html>