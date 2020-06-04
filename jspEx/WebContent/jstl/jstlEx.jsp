<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	http://java.sun.com/jsp/jstl/core라이브러리 쓰고싶다면	
	접두사 c를 붙혀라  
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 예제 - set, out, remove</title>
</head>
<body>
browser변수값 설정 
<c:set var ="browser" value="${header['User-Agent']} " /><br/> 
<c:out value="${browser}" /><br/>
browser변수값 제거 후
<c:remove var="browser" /><br/>
<c:out value="${browser}" /><br/>
</body>
</html>