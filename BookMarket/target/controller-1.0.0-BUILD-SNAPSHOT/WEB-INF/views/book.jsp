<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href=<c:url value ="/resources/css/bootstrap.min.css"/> rel="stylesheet">
    <script src = "${pageContext.request.contextPath}/resources/js/controller.js"></script>
    <title>도서 목록</title>
</head>
<body>
<%--타일즈 사용으로인한 주석처리--%>
<%--<nav class = "navbar navbar-expand navbar-dark bg-dark">--%>
<%--    <div class = "container">--%>
<%--        <div class = "navbar-header">--%>
<%--            <a class = "navbar-brand" href="./home">Home</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<div class = "jumbotron">--%>
<%--    <div class="container">--%>
<%--        <h1 class = "display-3" >도서 정보</h1>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="container">
    <div class="row">
            <div class="col-md-4">
                <c:choose>
                    <c:when test = "${book.getBookImage() == null}">
                        <img src="${pageContext.request.contextPath}/upload/${book.getBookId()}.png"style="width: 100%"/>
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/upload/${book.getBookImage().getOriginalFilename()}"style="width: 100%"/>
                    </c:otherwise>
                </c:choose>
            </div>
        <div class="col-md-8">
                <h3>${book.name}</h3>
                <p>${book.description}</p>
                <br>
                <p><b>도서코드:</b><span class = "badge badge-info">${book.bookId}</span></p>
                <p><b>저자</b>${book.author}</p>
                <p><b>저자</b>${book.publisher}
                <p><b>저자</b>${book.releaseDate}
                <p><b>분류</b> : ${book.category}
                <p><b>재고수</b> : ${book.unitsInStock}
                <h4>${book.unitPrice}원</h4>
                <br>
            <form:form name ="addForm" method="put">
                <p><a href ="javascript:addToCart('../cart/add/${book.bookId}')" class ="btn btn-primary">도서주문 &raquo;</a>
                    <p><a href="<c:url value ="/cart"/>" class = "btn btn-primary">장바구니 &raquo;</a>
                <a href ="<c:url value = "/books"/>" class = "btn btn-secondary">도서목록 &raquo;</a>
            </form:form>
            </div>
    </div>
    <hr>
    <footer class="container">
        <p>&copy; BookMarket</p>
    </footer>
</div>
</body>
</html>
