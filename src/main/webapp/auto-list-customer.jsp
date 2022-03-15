<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Auto Management Application</title>
</head>
<body>
<%@include file="header1.jsp"%>


<c:url var="Auto" value="/auto"><c:param name="pathAuto" value="auto2"/></c:url>

<div class="contact-box">

        <h4><a href="${Auto}">Mostra elenco Auto</a></h4>

    <table>
        <tr>
            <th>ID</th>
            <th>Targa</th>
            <th>Modello</th>
            <th>Marca</th>
        </tr>
        <c:forEach var="auto" items="${listAuto2}">
            <tr>
                <td><c:out value="${auto.id}" /></td>
                <td><c:out value="${auto.targa}" /></td>
                <td><c:out value="${auto.modello}" /></td>
                <td><c:out value="${auto.marca}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

