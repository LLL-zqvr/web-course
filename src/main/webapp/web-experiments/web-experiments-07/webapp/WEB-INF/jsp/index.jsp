<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <c:url var="base" value="/" />
    <base href="${base}">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${users}" var="u">
        <li>${u.name} - ${u.insertTime}</li>
    </c:forEach>
</ul>
</body>
</html>
