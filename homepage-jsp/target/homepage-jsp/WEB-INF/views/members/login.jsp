<!-- members/login.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<main>

    <section id="login-member">

        <div class="container">
            <h2>멤버 로그인</h2>
            <form action="${pageContext.request.contextPath}/members/processLogin" method="post">
                <!-- 아이디 입력 부분 -->
                <div id="input-id-area">
                    <label for="id">아이디</label><br>
                    <input type="text" id="input-id" name="id" required />
                </div>
                <!-- 비밀번호 입력 부분 -->
                <div id="input-password-area">
                    <label for="password">비밀번호</label><br>
                    <input type="password" id="input-password" name="password" required />
                </div>
                <!-- 버튼 : 로그인 -->
                <button type="submit">로그인</button>
            </form>
            <!-- 에러 메시지 처리 -->
            <c:if test="${not empty param.error}">
                <p style="color: red;">아이디 또는 비밀번호가 잘못 입력되었습니다.</p>
            </c:if>
        </div>

    </section>

</main>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />