<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>스크랩 목록</title>
    <style>
        html, body {
            margin: 0;
            width: auto;
            height: auto;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <%--    <script>--%>
    <%--        function card_click() {--%>
    <%--            <jsp:forward page="/student/main/detail.jsp"/>--%>
    <%--        }--%>
    <%--    </script>--%>
</head>
<body>
<%!
    int totalCount;
    int countList;
    int totalPage;
    int i;
%>
<%
    totalCount = 25;
    countList = 10;

    totalPage = totalCount / countList;

    if (totalCount % countList > 0) {
        totalPage++;
    }
%>

<div class="w-auto p-3" style="background-color: lightcyan; text-align: center;"><h4>당신의 루미를 찾아보세요! <button class="btn btn-outline-success" type="submit">자동매칭 하러가기</button></h4></div>

<a href = "<c:url value='/WEB-INF/student/main/detail.jsp'/>"><h3 style="padding-top: 30px; padding-left: 200px; color: black;">Roomie 루미</h3></a>
<h3 style="text-align: right; padding-top: 0px; padding-right: 200px;">스크랩</h3>

<% for (i = 1; i <= countList/2; i++) { %>
<div style = "padding-top: 30px; padding-left: 200px;" class="row">
    <div class="col-sm-6">
        <div class="card mb-3" style="border-radius: 10px; max-width: 600px;" onClick="location.href='/student/main/detail.jsp'">
            <div class="row g-0">
                <div class="col-md-4">
                    <img style="border-radius: 10px;" src="<c:url value='/images/jjang.jpg' />" class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">짱구</h5>
                        <p class="card-text">전공: 컴퓨터학과&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <br>나이: 21&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</p>
                        <p class="card-text"><small class="text-muted"></small></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style = "float:right; padding-left: 50px;" class="col-sm-6">
        <div class="card mb-3" style="border-radius: 10px; max-width: 600px;" onClick="location.href='/student/main/detail.jsp'">
            <div class="row g-0">
                <div class="col-md-4">
                    <img style="border-radius: 10px;" src="<c:url value='/images/jjang.jpg' />" class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">짱구</h5>
                        <p class="card-text">전공: 컴퓨터학과&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <br>나이: 21&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</p>
                        <p class="card-text"><small class="text-muted"></small></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%
    }
%>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>
    </ul>
</nav>
</body>
</html>