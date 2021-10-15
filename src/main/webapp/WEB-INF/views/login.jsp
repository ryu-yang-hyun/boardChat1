<%--
  Created by IntelliJ IDEA.
  User: dbdidgus
  Date: 21. 10. 14.
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Login</title>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
    <link type="text/css" rel="stylesheet" href="../resources/css/common.css"/>
    <link type="text/css" rel="stylesheet" href="../resources/css/reset.css"/>
    <script type="text/javascript" src="../resources/js/jquery-3.5.1.min.js"></script>
</head>
<body>
    <div class="wrap">
        <div class="login">
            <h2>Log-in</h2>
            <div class="login_sns">
                <li><a href=""><i class="fab fa-instagram"></i></a></li>
                <li><a href=""><i class="fab fa-facebook-f"></i></a></li>
                <li><a href=""><i class="fab fa-twitter"></i></a></li>
            </div>
            <form action="/login" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div class="login_id">
                    <h4>아이디</h4>
                    <input type="text" name="username" id="" placeholder="아이디" autocomplete="off">
                </div>
                <div class="login_pw">
                    <h4>비밀번호</h4>
                    <input type="password" name="password" id="" placeholder="비밀번호">
                </div>
                <div class="login_etc">
                    <div class="checkbox">
                        <input type="checkbox" name="" id=""> Remember Me?
                    </div>
                    <div class="forgot_pw">
                        <a href="">Forgot Password?</a>
                    </div>
                </div>
                <div class="submit">
                    <input type="submit" value="submit">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
