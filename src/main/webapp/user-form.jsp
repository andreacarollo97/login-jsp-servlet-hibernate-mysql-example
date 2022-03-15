<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<%@include file="header2.jsp"%>

<c:url var="UserInsert" value="/user"><c:param name="pathUser" value="insert"/></c:url>
<c:url var="UserUpdate" value="/user"><c:param name="pathUser" value="update"/></c:url>
<c:url var="User" value="/user"></c:url>

<div class="contact-box">

    <h4><a href="${User}">Mostra elenco Utenti</a></h4>    &nbsp;&nbsp;&nbsp;


    <c:if test="${user.id != null}">
    <form action="${UserUpdate}" method="post">
        </c:if>
        <c:if test="${user.id == null}">
        <form action="${UserInsert}" method="post">
            </c:if>

                <c:if test="${user.id != null}">
                    <input type="hidden" name="id"
                           value="<c:out value='${user.id}' />" />
                </c:if>
                <input type="text" class="input-field" placeholder="Nome" name="firstName" required
                       value="<c:out value='${user.firstName}' />"
                />
                <input type="text" class="input-field" placeholder="Cognome" name="lastName" required
                       value="<c:out value='${user.lastName}' />"
                />
                <input type="date" class="input-field" placeholder="Data di Nascita" name="date" required
                       value="<c:out value='${user.date}' />"
                />
                <input type="text" class="input-field" placeholder="Username" name="username" required
                       value="<c:out value='${user.username}' />"
                />
                <input type="password" class="input-field" placeholder="Password" name="password" size="45"
                       value="<c:out value='${user.password}' />"
                />
                <c:if test="${user.id != null}">
                <button type="submit" class="btn">Applica Modifiche</button>
                    </c:if>
                    <c:if test="${user.id == null}">
                        <button type="submit" class="btn">Aggiungi Utente</button>
                        </c:if>

    </form>
</div>
</body>
</html>
