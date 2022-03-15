<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Auto Management Application</title>
</head>
<body>

<%@include file="header2.jsp"%>

<c:url var="AutoNew" value="/auto"><c:param name="pathAuto" value="new"/></c:url>
<c:url var="Auto" value="/auto"></c:url>

<div class="contact-box">
    <c:if test="${listAuto == null}">
        <h4><a href="${Auto}">Mostra elenco Auto</a></h4>

    </c:if>
    <c:if test="${listAuto != null}">
        <h4><a href="${AutoNew}">Aggiungi un Auto</a></h4>
    </c:if>

    <table>
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
