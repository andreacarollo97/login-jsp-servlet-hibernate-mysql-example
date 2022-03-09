<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Auto Management Application</title>
</head>
<body>
<center>
    <h1>Auto Management</h1>
    <c:url var="AutoInsert" value="/auto"><c:param name="pathAuto" value="insert"/></c:url>
    <c:url var="AutoNew" value="/auto"><c:param name="pathAuto" value="new"/></c:url>
    <c:url var="AutoUpdate" value="/auto"><c:param name="pathAuto" value="update"/></c:url>
    <c:url var="Auto" value="/auto"></c:url>

    <h2>
        <a href="${AutoNew}">Add New Auto</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${Auto}">List All Auto</a>
    </h2>
</center>
<div align="center">
    <c:if test="${auto.id != null}">
    <form action="${AutoUpdate}" method="post">
        </c:if>
        <c:if test="${auto.id == null}">
        <form action="${AutoInsert}" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${auto != null}">
                            Edit Auto
                        </c:if>
                        <c:if test="${auto == null}">
                            Add New Auto
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${auto.id != null}">
                    <input type="hidden" name="id"
                           value="<c:out value='${auto.id}' />" />
                </c:if>
                <tr>
                    <th>Targa: </th>
                    <td>
                        <input type="text" name="targa" size="45"
                               value="<c:out value='${auto.targa}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Modello: </th>
                    <td>
                        <input type="text" name="modello" size="45"
                               value="<c:out value='${auto.modello}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Marca: </th>
                    <td>
                        <input type="text" name="marca" size="45"
                               value="<c:out value='${auto.marca}' />"
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