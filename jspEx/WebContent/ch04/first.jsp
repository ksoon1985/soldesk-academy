<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<% String str = "first"; %>
	<h3>이 파일은 first.jsp입니다. </h3>
	<jsp:forward page="second.jsp" > 
		<jsp:param name = "date" value="<%= new java.util.Date() %>"/>
	</jsp:forward>
	
	<!-- <jsp:include page="second.jsp" /> 과 비교 해볼 것 -->
	<h3>이 파일은 first.jsp입니다. </h3>
</body>
</html>