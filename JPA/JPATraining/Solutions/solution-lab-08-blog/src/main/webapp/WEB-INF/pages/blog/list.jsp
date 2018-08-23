<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />

    <link rel="Stylesheet" type="text/css" href="<c:url value="/style.css"/>"/>
</head>
<body>

<c:forEach items="${blogs}" var="blog">
        <p>
            <a href="<c:url value="/post/list.do"/>?id=<c:out value="${blog.id}"/>"><c:out value="${blog.name}"/></a>
            <i>(by <c:out value="${blog.author}"/>)</i>
        </p>
        <p>
            <a href="<c:url value="/blog/edit.do"/>?id=<c:out value="${blog.id}"/>">Edit</a>&nbsp|
            <a href="<c:url value="/blog/remove.do"/>?id=<c:out value="${blog.id}"/>">Delete</a>
        </p>
        <br>
    </c:forEach>

    <p>
        <a href="<c:url value="/blog/edit.do"/>">Add new Blog</a>
    </p>
</body>
</html>
