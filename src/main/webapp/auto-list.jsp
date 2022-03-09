<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Auto Management Application</title>
</head>
<body>
<center>
    <h1>Auto Management</h1>

    <c:url var="AutoNew" value="/auto"><c:param name="pathAuto" value="new"/></c:url>
    <c:url var="Auto" value="/auto"></c:url>

    <h2>
        <a href="${AutoNew}">Add New Auto</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${Auto}">List All Auto</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Targa</th>
            <th>Modello</th>
            <th>Marca</th>

        </tr>
        <c:forEach var="auto" items="${listAuto}">
            <tr>
                <td><c:out value="${auto.id}" /></td>
                <td><c:out value="${auto.targa}" /></td>
                <td><c:out value="${auto.modello}" /></td>
                <td><c:out value="${auto.marca}" /></td>
                <td>
                    <c:url var="AutoEdit" value="/auto">
                        <c:param name="pathAuto" value="edit"/>
                        <c:param name="id" value="${auto.id}"/>
                    </c:url>
                    <a href="${AutoEdit}">Edit</a>

                    <c:url var="AutoDelete" value="/auto">
                        <c:param name="pathAuto" value="delete"/>
                        <c:param name="id" value="${auto.id}"/>
                    </c:url>
                    <a href="${AutoDelete}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>