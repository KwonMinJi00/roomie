<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <script>
        function search(targetUri) {
            form.action = targetUri;
            form.method="POST";		// register form 요청
            form.submit();
        }
    </script>

    <style>
        body {
            margin: 5%;
            align-content: center;
        }

        table {
            margin: 0 auto;
            width: 80%;
            height: 40%;
            position: relative;
            top: 20%;
            background-color: lightgrey;
        }

        td {
            padding: 2% 1% 2% 5%;
        }

        select {
            width: 100px;
            height: 35px;
            padding: 5px 20px 5px 10px;
            border-radius: 4px;
            outline: 0 none;
        }
        .select option {
            background: black;
            color: #fff;
            padding: 3px 0;
        }

        div {
            float: right;
        }

        .btn {
            margin-top: 10px;
            margin-right: 8%;
        }

        .search-img {
            margin-top: 15px;
            margin-right: -20px;
        }

        #magnifier {
            width: 80px;
        }

        .btn-outline-secondary {
            width: 100px;
            padding: 5px;
            color: black;
            border-color: lightgrey;
            background-color: white;
        }
    </style>

</head>
<body>
<h4>&nbsp;Roomie 루미</h4>

<%-- 검색 필터 --%>
<%--<form name="form" method="post" action="<c:url value='/student/searchResult'>">--%>
<form name="form" method="POST" action="">
    <table>
        <tr>
            <td><input type="checkbox" id="age" name="searchFilter"><label>&nbsp;나이</label></td>
            <td><input type="checkbox" id="sleep_habit" name="searchFilter"><label>&nbsp;잠버릇</label></td>
            <td><input type="checkbox" id="lifestyle" name="searchFilter"><label>&nbsp;생활 패턴</label></td>
            <br>
        </tr>
        <tr>
            <td><input type="checkbox" id="smoking" name="searchFilter"><label>&nbsp;흡연 유무</label></td>
            <td><input type="checkbox" id="grade" name="searchFilter"><label>&nbsp;학년</label></td>
            <td><input type="checkbox" id="major" name="searchFilter"><label>&nbsp;전공</label></td>
            <br>
        </tr>
        <tr>
            <td><input type="checkbox" id="cleaning" name="searchFilter"><label>&nbsp;청소 주기</label></td>
            <td><input type="checkbox" id="indoor_eating" name="searchFilter"><label>&nbsp;실내 취식</label></td>
            <td><label>&nbsp;&nbsp;&nbsp;MBTI&nbsp;
                <select id="mbti" name="searchFilter">
                    <option value="istj">ISTJ</option>
                    <option value="isfj">ISFJ</option>
                    <option value="infj">INFJ</option>
                    <option value="intj">INTJ</option>
                    <option value="istp">ISTP</option>
                    <option value="isfp">ISFP</option>
                    <option value="infp">INFP</option>
                    <option value="intp">INTP</option>
                    <option value="estp">ESTP</option>
                    <option value="esfp">ESFP</option>
                    <option value="enfp">ENFP</option>
                    <option value="entp">ENTP</option>
                    <option value="estj">ESTJ</option>
                    <option value="esfj">ESFJ</option>
                    <option value="enfj">ENFJ</option>
                    <option value="entj">ENTJ</option>
                </select>
            </label></td>
            <br>
        </tr>
        <tr>
            <td><input type="checkbox" id="sharing" name="searchFilter"><label>&nbsp;생필품 공유</label></td>
            <td><input type="checkbox" id="habitude" name="searchFilter"><label>&nbsp;체질</label></td>
        </tr>
    </table>

    <div class="btn">
        <%-- 검색 실행 버튼 --%>
        <button type="submit" class="btn btn-outline-secondary" onclick="search('${pageContext.request.contextPath}/student/search')">검색하기</button>
    </div>
    <%-- 돋보기 이미지 --%>
    <div class="search-img">
        <img src="<c:url value='/images/magnifier.png'/>" id="magnifier"/>
    </div>
</form>
</body>
</html>
