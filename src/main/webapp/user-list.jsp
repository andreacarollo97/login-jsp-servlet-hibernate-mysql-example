
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<%@include file="header2.jsp"%>

<c:url var="UserNew" value="/user"><c:param name="pathUser" value="new"/></c:url>
<c:url var="User" value="/user"></c:url>

<div class="contact-box">
    <c:if test="${listUser == null}">
        <h4><a href="${User}">Mostra elenco Utenti</a></h4>
    </c:if>
        <c:if test="${listUser != null}">
            <h4><a href="${UserNew}">Aggiungi un Utente</a></h4>
            </c:if>



    <table>

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


