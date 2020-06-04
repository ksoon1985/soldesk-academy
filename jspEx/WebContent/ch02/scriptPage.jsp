<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Script Tag</title>
</head>
<body>
	<h2>Scripting Tag</h2>
	
	<!-- 전역 변수  -->
	<%! 
		int count = 3; 
		String makeItLower(String data)
		{
			return data.toLowerCase();
		}
	%>
	
	<%
		for(int i=0;i<=count;i++)
		{
			out.println("Java server page" + i +".<br>");
			
		}
	%>
	<%= makeItLower("hellO WORLD") %>
	
	<h2>주석 연습하기</h2>
	<%-- 이곳은 jsp 의 주석을 쓰는 방법입니다. --%>
	
	
</body>
</html>