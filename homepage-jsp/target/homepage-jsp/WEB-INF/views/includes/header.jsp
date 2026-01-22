<!-- includes/header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈페이지</title>
    <script>
        window.contextPath = '${pageContext.request.contextPath}';  // <!-- 전역 변수로 contextPath를 미리 심어둡니다 --> 
    </script> 
</head>

<body>
<header>

    <div class="container" style="background-color: #ddd; width:1000px;">

        <div id="hd1" style="height:50px; background-color: #bff;">
            <!-- 회원가입 링크와 로그인 링크 or 회원아이디 와 로그아웃 링크 -->
            <c:choose>

                <c:when test="${empty sessionScope.loginUser}">
                    <div id="access-register-page">
                        <a href="${pageContext.request.contextPath}/members/accessRegisterPage">회원가입(</a>
                    </div>
                    <div id="access-login-page">
                        <a href="${pageContext.request.contextPath}/members/accessLoginPage">로그인</a>
                    </div>
                </c:when>

                <c:otherwise>
                    <div id="user-info">
                        <strong>${sessionScope.loginUser.id}</strong>
                    </div>
                    <div id="process-logout">
                        <a href="${pageContext.request.contextPath}/members/processLogout">로그아웃</a>
                    </div>
                </c:otherwise>

            </c:choose>
        </div>  <!-- end #hd1 -->

        <div id="hd2" style="height:50px; background-color: #fbf;">
            <!-- 로고(작업 예정) : 크기(200x100), 가운데 정렬 -->
            <!-- 네비게이션 -->
            <nav>
                <div><a href="${pageContext.request.contextPath}/members/accessMyAccount">내 계정</a></div>
            </nav>
        </div>  <!-- end #hd2 -->

    </div>

</header>