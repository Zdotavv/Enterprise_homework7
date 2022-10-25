<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>View person By ID</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">View person By ID</h1>
<div align="center">
    <%--@elvariable id="personById" type="com.zdotavv.enterprise_homework7.dto.PersonDto"--%>
    <table>
        <tr>
            <td>ID: </td>
            <td>${personById.idPerson}</td>
        <tr>
        <td>Username: </td>
        <td>${personById.username}</td>
        <tr>
            <td>First name: </td>
            <td>${personById.firstName}</td>
        <tr>
            <td>Last name: </td>
            <td>${personById.lastName}</td>
        <tr>
            <td>Email: </td>
            <td>${personById.email}</td>
    </table>

</div>
    <br>
    <a href="${pageContext.request.contextPath}/person">&#8592 Back to person control page </a>
</body>
</html>