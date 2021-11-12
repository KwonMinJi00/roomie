<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
    <script>
        function studentCreate() {
            if (form.name.value == "") {
                alert("이름을 입력하세요.");
                form.name.focus();
                return false;
            }
            if (form.email.value == "") {
                alert("이메일을 입력하세요.");
                form.email.focus();
                return false;
            }
            if (form.password.value == "") {
                alert("비밀번호를 입력하세요.");
                form.password.focus();
                return false;
            }
            if (form.password.value != form.password2.value) {
                alert("비밀번호가 일치하지 않습니다.");
                form.password2.focus();
                return false;
            }
            var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
            if(emailExp.test(form.email.value) == false) {
                alert("이메일 형식이 올바르지 않습니다.");
                form.email.focus();
                return false;
            }
            form.submit();
        }
    </script>
    <style>
        table {
            margin-top: 100px;
            width: 60%;
            font-size: 13px;
            /*border: black 1px solid;*/
        }
        th {
            font-size: 45px;
            font-weight: bold;
            text-align: left;
        }
        input {
            margin: 2px;
            padding: 5px;
        }
        #college {
            padding: 5px 10px;
            font-size: 12px;
            margin: 2px;
        }
    </style>
</head>
<body>
<form name="form" method="POST" action="${pageContext.request.contextPath}/student/register">
    <div align=center>
        <table>
            <tr>
                <th rowspan="3">Roomie<br>루미</th>
                <td width="20%">&nbsp;</td>
            </tr>
            <tr>
                <td>
                    <br>
                    이름<br>
                    <input type="text" placeholder="닉네임을 입력하세요." size="40" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    <br>
                    아이디<br>
                    <input type="email" placeholder="본인의 학교 웹메일을 입력하세요." size="40" name="email">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <br>
                    비밀번호<br>
                    <input type="password" placeholder="비밀번호는 6~8자로 입력하세요." size="40" name="password">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <br>
                    비밀번호 확인<br>
                    <input type="password" placeholder="비밀번호를 한 번 더 입력하세요." size="40" name="password2">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <br>
                    성별<br>
                    <input type = "radio" name = "gender" value = "0">남자&nbsp;&nbsp;&nbsp;
                    <input type = "radio" name = "gender" value = "1">여자
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <br>
                    학교<br>
                    <select id="college" name="college">
                        <option value="학교데이터 가져와야함">동덕여자대학교</option>
                        <option value="학교데이터 가져와야함">학교</option>
                        <option value="학교데이터 가져와야함">대핵교</option>
                        <option value="학교데이터 가져와야함">중핵교</option>
                        <option value="학교데이터 가져와야함">초등핵교</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <br>
                    <input type="button" style="width: 238px;" value="가입하기" onClick="studentCreate()">
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
