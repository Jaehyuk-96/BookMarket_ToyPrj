<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>회원정보</h3>
<p>비밀번호: ${member.password}
<p>비밀번호: ${member.city}
<p>비밀번호: ${member.sex}
<p>취미 : <c:forEach items="${member.hobby}" var="hobby">
    [<c:out value = "${hobby}"/>
    </c:forEach>
</body>
</html>
