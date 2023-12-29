<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Validation</title>
</head>
<body>
<h3>유효성 검사</h3>
<form:form modelAttribute="member" method="post">
    <p>이름: <form:input path="memberName" /> <form:errors path="memberName"/>
    <p>나이: <form:input path="age" /> <form:errors path="age"/>
    <p>이메일: <form:input path="email" /> <form:errors path="email"/>
    <p>번호: <form:input path="number" /> <form:errors path="number"/>
    <p><input type="submit" value="확인"/>
    <input type="reset" value="취소"/>
</form:form>
</body>
</html>
