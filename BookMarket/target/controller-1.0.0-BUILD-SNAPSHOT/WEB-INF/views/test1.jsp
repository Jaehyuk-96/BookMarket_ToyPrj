<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="dataBean" action='result'>
        <form:radiobuttons path ="a2" items="${requestScope.data_list2}"/>
</form:form>

</body>
</html>