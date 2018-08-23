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

    <form:form action="/post/modify.do" commandName="post">
        <form:hidden path="id"/>
        <form:hidden path="blogId"/>
        <table border="0">
            <tr>
                <td>Title:</td>
                <td><form:textarea path="title" rows="2"/></td>
            </tr>
            <tr>
                <td>Text:</td>
                <td><form:textarea path="text" rows="5"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Apply"/>
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>
