<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update person</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<div align="center">
    <h2>Update person</h2>
    <form:form action="update" method="post" modelAttribute="person">
        <form:label path="idPerson">Id:</form:label>
        <form:input required="required" path="idPerson"/><br/>
        <form:label path="username">Username:</form:label>
        <form:input path="username"/><br/>
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName"/><br/>
        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName"/><br/>
        <form:label path="email">Email:</form:label>
        <form:input path="email"/><br/>
        <form:button>Update</form:button>
    </form:form>
</div>
</body>
</html>