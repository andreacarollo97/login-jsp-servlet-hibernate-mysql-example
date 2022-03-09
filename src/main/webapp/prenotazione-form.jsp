<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Prenotazioni Management Application</title>
</head>
<body>
<center>
    <h1>Prenotazioni Management</h1>
    <c:url var="PrenotazioneInsert" value="/prenotazione"><c:param name="pathPrenotazione" value="insert"/></c:url>
    <c:url var="PrenotazioneNew" value="/prenotazione"><c:param name="pathPrenotazione" value="new"/></c:url>
    <c:url var="PrenotazioneUpdate" value="/prenotazione"><c:param name="pathPrenotazione" value="update"/></c:url>
    <c:url var="Prenotazione" value="/prenotazione"></c:url>

    <h2>
        <a href="${PrenotazioneNew}">Add New Prenotazione</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${Prenotazione}">List All Prenotazioni</a>
    </h2>
</center>
<div align="center">
    <c:if test="${prenotazione.id != null}">
    <form action="${PrenotazioneUpdate}" method="post">
        </c:if>
        <c:if test="${prenotazione.id == null}">
        <form action="${PrenotazioneInsert}" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${prenotazione != null}">
                            Edit Prenotazione
                        </c:if>
                        <c:if test="${prenotazione == null}">
                            Add New Prenotazione
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${prenotazione.id != null}">
                    <input type="hidden" name="id"
                           value="<c:out value='${prenotazione.id}' />" />
                </c:if>
                <tr>
                    <th>Data di Inizio Prenotazione: </th>
                    <td>
                        <input type="date" name="dateStart" size="45"
                               value="<c:out value='${prenotazione.dateStart}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Data di Fine Prenotazione: </th>
                    <td>
                        <input type="date" name="dateEnd" size="45"
                               value="<c:out value='${prenotazione.dateEnd}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Targa: </th>
                    <td>
                        <input type="text" name="targa" size="45"
                               value="<c:out value='${prenotazione.targa}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

