<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Auto Management Application</title>
</head>
<body>
<%@include file="header2.jsp"%>

<c:url var="AutoInsert" value="/auto"><c:param name="pathAuto" value="insert"/></c:url>
<c:url var="AutoNew" value="/auto"><c:param name="pathAuto" value="new"/></c:url>
<c:url var="AutoUpdate" value="/auto"><c:param name="pathAuto" value="update"/></c:url>
<c:url var="Auto" value="/auto"></c:url>

<div class="contact-box">

    <h4><a href="${Auto}">Mostra elenco Auto</a></h4>   &nbsp;&nbsp;&nbsp;


    <c:if test="${auto.id != null}">
    <form action="${AutoUpdate}" method="post">
        </c:if>
        <c:if test="${auto.id == null}">
        <form action="${AutoInsert}" method="post">
            </c:if>

                <c:if test="${auto.id != null}">
                    <input type="hidden" name="id"
                           value="<c:out value='${auto.id}' />" />
                </c:if>
                <input type="text" class="input-field" placeholder="Targa" name="targa" required
                       value="<c:out value='${auto.targa}' />"
                />
                <input type="text" class="input-field" placeholder="Modello" name="modello" required
                       value="<c:out value='${auto.modello}' />"
                />
                <input type="text" class="input-field" placeholder="Marca" name="marca" required
                       value="<c:out value='${auto.marca}' />"
                />

            <c:if test="${auto.id != null}">
                <button type="submit" class="btn">Applica Modifiche</button>
            </c:if>
            <c:if test="${auto.id == null}">
                <button type="submit" class="btn">Aggiungi Auto</button>
            </c:if>

        </form>
</div>
</body>
</html>



