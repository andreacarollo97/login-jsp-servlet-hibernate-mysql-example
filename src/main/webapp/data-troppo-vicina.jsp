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
  <h2>Hai selezionato una data 48 ore prima della prenotazione!</h2>
  <a href="prenotazione-form.jsp">Riprova</a>


</div>
</body>
</html>