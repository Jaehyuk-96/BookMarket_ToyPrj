<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href=<c:url value ="/resources/css/bootstrap.min.css"/> rel="stylesheet">
    <title>도서 목록</title>
</head>
<body>
<%--타일즈 사용으로인한 주석처리--%>
<%--<nav class = "navbar navbar-expnad navbar-dark bg-dark">--%>
<%--    <div class = "container">--%>
<%--        <div class = "navbar-header">--%>
<%--            <a class = "navbar-brand" href="./home">Home</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<div class = "jumbotron">--%>
<%--    <div class="container">--%>
<%--        <h1 class = "display-3" >도서목록</h1>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="container">
    <div class="row" align="center">
        <c:forEach items="${bookList}" var="book">
            <div class="col-md-4">
               <c:choose>
                   <c:when test = "${book.getBookImage() == null}">
                       <img src="${pageContext.request.contextPath}/upload/${book.getBookId()}.png" style="width: 60%"/>
                   </c:when>
                   <c:otherwise>
                       <img src="${pageContext.request.contextPath}/upload/${book.getBookImage().getOriginalFilename()}"style="width: 60%" />
                   </c:otherwise>
               </c:choose>
                <h3>${book.name}</h3>
                <p>${book.author}</p>
                <br>${book.publisher}${book.releaseDate}
                <p align="left">${fn:substring(book.description, 0 , 100)}...
                <p>${book.unitPrice}원
                <p><a href ="<c:url value = "/books/book?id=${book.bookId}"/>" class = "btn btn-secondary">상세정보 &raquo;</a>
            </div>
        </c:forEach>
    </div>
    <hr>
<%--    타일즈사용으로인한주석처리--%>
<%--<footer class="container">--%>
<%--    <p>&copy; BookMarket</p>--%>
<%--    </footer>--%>
</div>
</body>
</html>
