<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage ="true" %>
<!-- 이렇게 해주면 exception 내장객체를 사용 할 수 있다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>[경고]오류 발생</h3>
	<h3>오류 유형 : <%= exception.getClass().getName() %></h3>
	<h3>오류 유형 : <%= exception.getMessage() %></h3>
	
</body>
</html>