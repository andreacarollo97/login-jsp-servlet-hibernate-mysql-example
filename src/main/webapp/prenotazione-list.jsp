<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Auto Management Application</title>
</head>
<body>

<%@include file="header2.jsp"%>

<c:url var="PrenotazioneNew" value="/prenotazione"><c:param name="pathPrenotazione" value="new"/></c:url>
<c:url var="Prenotazione" value="/prenotazione"></c:url>

<div class="contact-box">

        <h4><a href="${Prenotazione}">Mostra Elenco Prenotazioni</a></h4>


        <h4><a href="${PrenotazioneNew}">Gestisci Prenotazioni</a></h4>
    <table>
        <tr>
            <th>ID</th>
            <th>Data di Inizio Prenotazione</th>
            <th>Data di Fine Prenotazione</th>
        </tr>
        <c:forEach var="prenotazione" items="${listPrenotazione}">
            <tr>
                <td><c:out value="${prenotazione.id}" /></td>
                <td><c:out value="${prenotazione.dateStart}" /></td>
                <td><c:out value="${prenotazione.dateEnd}" /></td>
                <td>
                    <c:url var="PrenotazioneEdit" value="/prenotazione">
                        <c:param name="pathPrenotazione" value="edit"/>
                        <c:param name="id" value="${prenotazione.id}"/>
                    </c:url>
                    <a href="${PrenotazioneEdit}">Conferma Prenotazione</a>

                    <c:url var="PrenotazioneDelete" value="/prenotazione">
                        <c:param name="pathPrenotazione" value="delete"/>
                        <c:param name="id" value="${prenotazione.id}"/>
                    </c:url>
                    <a href="${PrenotazioneDelete}">Elimina Prenotazione</a>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>
</body>
</html>

