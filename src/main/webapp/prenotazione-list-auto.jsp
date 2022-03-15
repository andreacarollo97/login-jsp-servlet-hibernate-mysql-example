<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Elenco Auto Disponibili</title>
</head>
<body>

<%@include file="header1.jsp"%>

<c:url var="PrenotazioneListAuto" value="/prenotazione"><c:param name="pathPrenotazione" value="listauto"/></c:url>
<c:url var="PrenotazioneInsert" value="/prenotazione"><c:param name="pathPrenotazione" value="insert"/></c:url>
<div class="contact-box">


    <table>
        <tr>
    <th>ID</th>
    <th>Targa</th>
    <th>Modello</th>
    <th>Marca</th>
        </tr>
        <c:forEach var="auto" items="${listAutoByCalendar}">
            <tr>
                <td><c:out value="${auto.id}" /></td>
                <td><c:out value="${auto.targa}" /></td>
                <td><c:out value="${auto.modello}" /></td>
                <td><c:out value="${auto.marca}" /></td>
                <td>
                    <form action="${PrenotazioneInsert}" method="post">

                        <input type="hidden" name="auto_id"
                               value="<c:out value='${auto.id}' />" />
                        <input type="hidden" name="dateStart"
                               value="<c:out value='${dataInizio}' />" />
                        <input type="hidden" name="dateEnd"
                               value="<c:out value='${dataFine}' />" />

                        <button type="submit" class="btn">Prenota</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>
</body>
</html>
