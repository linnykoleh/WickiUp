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

    <form:form action="/blog/modify.do" commandName="blog">
        <form:hidden path="id"/>
        <table border="0">
            <tr>
                <td>Author:</td>
                <td><form:input path="author"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:textarea path="name" rows="2"/></td>
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
