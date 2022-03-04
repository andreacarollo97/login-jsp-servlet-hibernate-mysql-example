
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Aggiungi Customer</title>
</head>
<body>
<%@include file="header2.jsp"%>
<div class="contact-box">
    <h3>Aggiungi un nuovo Customer</h3>
    <form action="<%=request.getContextPath()%>/register" method="post">
        <input type="text" class="input-field" placeholder="Nome" name="firstName" required>
        <input type="text" class="input-field" placeholder="Cognome" name="lastName" required>
        <input type="date" class="input-field" name="date" required>
        <input type="text" class="input-field" placeholder="Username" name="username" required>
        <input type="password" class="input-field" placeholder="Password"  name="password" required>
        <button type="submit" class="btn">Aggiungi Customer</button>
    </form>
</div>
</body>
</html>