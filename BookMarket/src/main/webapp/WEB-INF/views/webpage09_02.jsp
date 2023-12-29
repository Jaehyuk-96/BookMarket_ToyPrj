<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>File Upload</title>
</head>
<body>
<h3>파일업로드</h3>
<form:form action="form" modelAttribute="member" method="post" enctype="multipart/form-data">
    <p>이름: <form:input path="name"/>
    <p>파일: <form:input path="imageFile" type="file"/>
<p><input type="submit" value="전송하기"/>
    <input type="reset" value="다시쓰기"/>
</form:form>

</body>
</html>
