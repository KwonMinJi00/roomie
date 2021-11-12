<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
    <script>
        function login() {
            if (form.email.value == "") {
                alert("사용자 ID(email)을 입력하세요.");
                form.email.focus();
                return false;
            }
            if (form.password.value == "") {
                alert("비밀번호를 입력하세요.");
                form.password.focus();
                return false;
            }
            form.submit();
        }

        function studentCreate(targetUri) {
            form.action = targetUri;
            form.method="GET";      //register form 요청
            form.submit();
        }
    </script>
    <style>
        .main {
            position: relative;
            top: 230px;
        }
        .roomie {
            font-size: 45px;
            font-weight: bold;
            float: left;
            position: relative;
            left: 270px;
            /*border: black 1px solid;*/
        }
        .in {
            font-size: 13px;
            float: right;
            position: relative;
            top: 20px;
            right: 270px;
        }
        .img {
            position: relative;
            top: 6px;

        }
        .btn {
            position: relative;
            left: 93px;
        }
    </style>
</head>
<body>
<br>
<form name="form" method="POST" action="${pageContext.request.contextPath}/student/login">
    <div class="main">
        <div class="roomie">Roomie<br>루미</div>
        <div class="in">
            <input type="image" class="img" src="/images/id.png" width="20px" height="20px">
            <input type="email" size="30" name="email">
            <p/>
            <input type="image" class="img" src="/images/password2.png" width="20px" height="20px">
            <input type="password" size="30" name="password">
            <p/>
            <input type="button" class="btn" value="회원가입" onClick="studentCreate('${pageContext.request.contextPath}/student/register')">&nbsp;
            <input type="button" class="btn" value="로그인" onClick="login()">
        </div>
    </div>
</form>
</body>
</html>
