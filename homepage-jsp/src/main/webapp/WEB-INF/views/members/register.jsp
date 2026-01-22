<!-- members/register.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<main>

    <section id="register-member">

        <div class="container">
            <h2>멤버 등록</h2>
            <form action="${pageContext.request.contextPath}/members/processRegister" method="post">

                <div id="id-input-area" class="input-group">
                    <label for="id">아이디 : 5~15개의 글자</label><br>
                    <input type="text" id="input-id" name="id" value="${memberVO.id}" required />
                    <!-- 검증 에러 메시지 표시 -->
                    <c:if test="${not empty errors.id}">
                        <p style="color:red; font-size: 0.8em;">${errors.id}</p>
                    </c:if>
                </div>

                <div id="password-input-area" class="input-group">
                    <label for="password">비밀번호 : 2~15개의 영문자(대소문자) 및 숫자</label><br>
                    <input type="password" id="input-password" name="password" required />
                    <!-- 검증 에러 메시지 표시 -->
                    <c:if test="${not empty errors.password}">
                        <p style="color:red; font-size: 0.8em;">${errors.password}</p>
                    </c:if>
                </div>

                <div id="name-input-area" class="input-group">
                    <label for="name">사용자명 : 실제 이름이 아닌 해당 웹서비스 상에서 사용할 이름</label><br>
                    <input type="text" id="input-name" name="name" value="${memberVO.name}" required />
                    <!-- 검증 에러 메시지 표시 -->
                    <c:if test="${not empty errors.name}">
                        <p style="color: red; font-size: 0.8em;">${errors.name}</p>
                    </c:if>
                </div>

                <div id="role-input-area" class="input-group">
                    <label for="role">권한</label><br>
                    <select name="role" id="role-select">
                        <option value="user" selected>일반 사용자</option>
                        <option value="manager">매니저</option>
                        <option value="admin">관리자</option>
                    </select>
                </div>

                <button type="submit">가입하기</button>

            </form>
        </div>

    </section>

</main>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />