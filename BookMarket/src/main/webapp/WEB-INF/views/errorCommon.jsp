<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href=<c:url value ="/resources/css/bootstrap.min.css"/> rel="stylesheet">
    <title>예외처리</title>
</head>
<body>
<nav class = "navbar navbar-expand navbar-dark bg-dark">
    <div class ="container">
        <div class = "navbar-header">
            <a class = "navbar-brand" href="../home">Home</a>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container"></div>
    <h2 class="alert alert-danger">
        요청한 도서가 존재하지 않습니다.<br>
        도서ID: ${invalidBookId}
    </h2>
</div>
</body>
</html>
