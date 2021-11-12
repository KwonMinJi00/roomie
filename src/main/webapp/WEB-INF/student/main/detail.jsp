<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>detail profile</title>
    <style>
        html, body {
            margin: 0;
            width: auto;
            height: auto;
        }
        td {
            padding-left: 10px;
            padding-bottom: 15px;
        }
        ul.space_list li { margin-bottom: 1em; }
        ul.none {margin-bottom: 1em; list-style: none;}
        .layer {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%)
        }
        .button {
            border: 0px; border-radius: 10px; background-color: lightgray; padding: 7px 50px 7px 50px;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="w-auto p-3" style="background-color: lightcyan; text-align: center;"><h4>당신의 루미를 찾아보세요! <button class="btn btn-outline-success" type="submit">자동매칭 하러가기</button></h4></div>

<a href = "../student/search.jsp"><h3 style="padding-top: 30px; padding-left: 100px; color: black;">Roomie 루미</h3></a>
<div style="padding-top: 50px;">
    <table style="border-radius: 10px; align: center;">
        <tr>
            <td colspan="2" rowspan="2"><img style="border-radius: 10px; width:300px; height:400px;" src="<c:url value='/images/jjang.jpg' />"/></td>
            <td width="100"></td>
            <td colspan="2" style="width:400px; text-align: center; font-size: x-large; font-weight: 800; padding-top: 5px;">프로필 옵션 </td>
            <td/>
        </tr>
        <tr>
            <td width="100"></td>
            <td width="400" rowspan="3" >
                <table style="font-size: large; width:400px;">
                    <tr>
                        <td>흡연유무</td>
                        <td>: &emsp;&emsp;&emsp;Y</td>
                    </tr>
                    <tr>
                        <td>전공</td>
                        <td>: &emsp;&emsp;&emsp;컴퓨터학과</td>
                    </tr>
                    <tr>
                        <td>생필품 공유</td>
                        <td>: &emsp;&emsp;&emsp;Y</td>
                    </tr>
                    <tr>
                        <td>생활 패턴</td>
                        <td>: &emsp;&emsp;&emsp;아침형</td>
                    </tr>
                    <tr>
                        <td>학년</td>
                        <td>: &emsp;&emsp;&emsp;3</td>
                    </tr>
                    <tr>
                        <td>체질</td>
                        <td>: &emsp;&emsp;&emsp;더위 탐</td>
                    </tr>
                    <tr>
                        <td>잠버릇</td>
                        <td>: &emsp;&emsp;&emsp;Y</td>
                    </tr>
                    <tr>
                        <td>청소 주기</td>
                        <td>: &emsp;&emsp;&emsp;매일</td>
                    </tr>
                    <tr>
                        <td>나이</td>
                        <td>: &emsp;&emsp;&emsp;21</td>
                    </tr>
                    <tr>
                        <td>실내취식</td>
                        <td>: &emsp;&emsp;&emsp;Y</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center"><button class="button">스크랩</button></td>
            <td align="center"><button class="button">쪽지</button></td>
            <td width="100"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><button class="button">나의 루미 pick!</button></td>
            <td width="100"></td>
        </tr>
    </table>
</div>

