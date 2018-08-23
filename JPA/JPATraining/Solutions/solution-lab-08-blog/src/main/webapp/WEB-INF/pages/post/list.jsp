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

    <form:form action="/post/search.do" commandName="criteria">
        <form:hidden path="blogId"/>
        <table>
            <tr>
                <td>Text:</td>
                <td colspan="3"><form:input path="text"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><form:input path="fromDate" maxlength="10" size="6"/></td>
                <td>till</td>
                <td><form:input path="tillDate" maxlength="10" size="6"/></td>

            </tr>
            <tr>
                <td></td>
                <td colspan="3"><div style="font-size:12px; color:gray; font-style: italic;">Date format: mm/dd/yyyy</div></td>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="submit" value="Search ..."/>
                </td>
            </tr>
        </table>
    </form:form>

    <br>
    <c:forEach items="${posts}" var="post">
        <p>
            <b><c:out value="${post.title}"/></b>
            <br>
            <i><c:out value="${post.date}"/></i>
        </p>
        <p>
            <c:out value="${post.text}"/>
        </p>
        <p>
            <a href="<c:url value="/post/edit.do"/>?id=<c:out value="${post.id}"/>&blogid=<c:out value="${post.blogId}"/>">Edit</a>&nbsp|
            <a href="<c:url value="/post/remove.do"/>?id=<c:out value="${post.id}"/>">Delete</a>
        </p>
        <br>
    </c:forEach>

    <br>
    <p>
        <a href="<c:url value="/post/edit.do?blogid=${criteria.blogId}"/>">Add new Post</a>
        &nbsp;|&nbsp;
        <a href="<c:url value="/blog/list.do"/>">To Blogs</a>
    </p>

</body>
</html>
