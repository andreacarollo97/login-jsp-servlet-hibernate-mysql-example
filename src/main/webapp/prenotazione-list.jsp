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

    <c:url var="PrenotazioneNew" value="/prenotazione"><c:param name="pathPrenotazione" value="new"/></c:url>
    <c:url var="Prenotazione" value="/prenotazione"></c:url>

    <h2>
        <a href="${PrenotazioneNew}">Add New Prenotazione</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${Prenotazione}">List All Prenotazioni</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Prenotazioni</h2></caption>
        <tr>
            <th>ID</th>
            <th>Data di Inizio Prenotazione</th>
            <th>Data di Fine Prenotazione</th>
            <th>Targa</th>
        </tr>
        <c:forEach var="prenotazione" items="${listPrenotazione}">
            <tr>
                <td><c:out value="${prenotazione.id}" /></td>
                <td><c:out value="${prenotazione.dateStart}" /></td>
                <td><c:out value="${prenotazione.dateEnd}" /></td>
                <td><c:out value="${prenotazione.targa}" /></td>
                <td>
                    <c:url var="PrenotazioneEdit" value="/prenotazione">
                        <c:param name="pathPrenotazione" value="edit"/>
                        <c:param name="id" value="${prenotazione.id}"/>
                    </c:url>
                    <a href="${PrenotazioneEdit}">Edit</a>

                    <c:url var="PrenotazioneDelete" value="/prenotazione">
                        <c:param name="pathPrenotazione" value="delete"/>
                        <c:param name="id" value="${prenotazione.id}"/>
                    </c:url>
                    <a href="${PrenotazioneDelete}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
