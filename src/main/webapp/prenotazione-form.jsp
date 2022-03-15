<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Prenotazioni Management Application</title>
</head>
<body>
<%@include file="header1.jsp"%>

<c:url var="PrenotazioneListAuto" value="/prenotazione"><c:param name="pathPrenotazione" value="listauto"/></c:url>

<div class="contact-box">


        <form action="${PrenotazioneListAuto}" method="post">

                <c:if test="${prenotazione.id != null}">
                    <input type="hidden" name="id"
                           value="<c:out value='${prenotazione.id}' />" />
                </c:if>


                <input type="date" name="dateStart" required
                       value="<c:out value='${prenotazione.dateStart}' />"
                />

                <input type="date" name="dateEnd" required
                       value="<c:out value='${prenotazione.dateEnd}' />"
                />
                <button type="submit" class="btn">Mostra Auto Disponibili in questo Intervallo</button>
        </form>
</div>
</body>
</html>





