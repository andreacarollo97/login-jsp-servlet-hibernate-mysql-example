<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>

    <c:url var="UserNew" value="/user"><c:param name="pathUser" value="new"/></c:url>
    <c:url var="User" value="/user"></c:url>

    <h2>
        <a href="${UserNew}">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${User}">List All User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Data di Nascita</th>
            <th>Username</th>
            <th>Password</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.firstName}" /></td>
                <td><c:out value="${user.lastName}" /></td>
                <td><c:out value="${user.date}" /></td>
                <td><c:out value="${user.username}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td>
                    <c:url var="UserEdit" value="/user">
                        <c:param name="pathUser" value="edit"/>
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <a href="${UserEdit}">Edit</a>

                    <c:url var="UserDelete" value="/user">
                        <c:param name="pathUser" value="delete"/>
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <a href="${UserDelete}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>