
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <style><%@include file="/WEB-INF/style.css"%></style>
</head>
<body>
<header>
    <div class="header">
        <div class="inner_header">
            <div class="logo_container">
                <h1>Rental <span>CAR</span></h1>
            </div>

            <ul class="navigation">
                <a href="parcoAuto.jsp"><li>Parco Auto</li></a>
                <a href="profilo.jsp"><li>Profilo</li></a>
                <a href="<%=request.getContextPath()%>/LogoutController"><li>Logout</li></a>
            </ul>

        </div>
    </div>
</header>
</body>
</html>

