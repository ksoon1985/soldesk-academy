<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${message}"/> <br/>
	<a href="memberList.sp" ><input type="button" value="회원 목록으로 가기..." /></a>
</body>
</html>