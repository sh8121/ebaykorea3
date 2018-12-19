<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Join form</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h2>${welcomeMessage}</h2>
${category.name}
<br/>
<c:forEach var="item" items="${items}">
    <a href="/items/${item.id}">${item.name}</a>
</c:forEach>
</body>