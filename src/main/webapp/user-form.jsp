<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <c:url var="UserInsert" value="/user"><c:param name="pathUser" value="insert"/></c:url>
    <c:url var="UserNew" value="/user"><c:param name="pathUser" value="new"/></c:url>
    <c:url var="UserUpdate" value="/user"><c:param name="pathUser" value="update"/></c:url>
    <c:url var="User" value="/user"></c:url>

    <h2>
        <a href="${UserNew}">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${User}">List All User</a>
    </h2>
</center>
<div align="center">
    <c:if test="${user.id != null}">
    <form action="${UserUpdate}" method="post">
        </c:if>
        <c:if test="${user.id == null}">
            <form action="${UserInsert}" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${user.id != null}">
                    <input type="hidden" name="id"
                           value="<c:out value='${user.id}' />" />
                </c:if>
                <tr>
                    <th>Nome: </th>
                    <td>
                        <input type="text" name="firstName" size="45"
                               value="<c:out value='${user.firstName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Cognome: </th>
                    <td>
                        <input type="text" name="lastName" size="45"
                               value="<c:out value='${user.lastName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Data di Nascita: </th>
                    <td>
                        <input type="date" name="date" size="45"
                               value="<c:out value='${user.date}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Username: </th>
                    <td>
                        <input type="text" name="username" size="45"
                               value="<c:out value='${user.username}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="password" name="password" size="45"
                               value="<c:out value='${user.password}' />"
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
