<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>guestbook</title>
    </head>
    <body>
        <h1>Guestbook!</h1>

        <form method="post" action="/write">
            name : <input type="text" name="name"><br>
            content :
            <textarea name="content"
                       cols="30" rows="10"></textarea><br>
            <input type="submit">
        </form>

        <br>
        <c:forEach items="${guestbookPage}" var="guestbook" >
            ${guestbook.id}<br>
            ${guestbook.name}<br>
            <pre>${guestbook.content}</pre><br>
            <hr><br>
        </c:forEach>

    </body>
</html>