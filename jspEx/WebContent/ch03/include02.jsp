<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<!-- 
		inlude 디렉티브 : 흐름이동이 아닌 파일 내용을 현재 위치에 삽입시킨 후 컴파일을 한다. 
		
		jsp action 태그1 (jsp:include)  : 흐름의 이동 , a.jsp 페이지 갔다가 
			b.jsp 페이지로 돌아옴.  즉 , 페이지가 포함된 것 처럼 확인이 가능. 
			제어권 까지 가지고 있음 
			include 디렉티브 같이 사용 하는 것  
		
		
		jsp action 태그2 (jsp:forward) : 페이지가 넘어가면 제어권을 갖지 못함 
			redirect 같은 놈 
	-->
	
	<%@ include file = "include02_header.jsp" %>
	
	<p>방문해주셔서 감사합니다. </p>
	
	<%@ include file = "include02_footer.jsp" %>
	
</body>
</html>