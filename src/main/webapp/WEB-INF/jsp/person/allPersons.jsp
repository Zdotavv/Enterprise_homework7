<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>All persons</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">All persons</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>email</th>
        </tr>
        <c:forEach  items="${all}" var ="person">
            <tr>
                <td>${person.idPerson}</td>
                <td>${person.username}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.email}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<br>
<a href="${pageContext.request.contextPath}/person">&#8592 Back to person control page </a>
</body>
</html>