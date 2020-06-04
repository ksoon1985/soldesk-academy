<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
    	response.setHeader("Pragma", "no-cache");
    	response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

/*a라는 요소에서 가상 클래스가  link(이미 정의가 되어 제공이 되있음 )일 때*/
/* 한번도 방문하지 않았을 때 */
a:link{
	color:red;
}
</style>
</head>
<body>
	<a href="http://www.w3schools.com">W3Schools</a>
</body>
</html>