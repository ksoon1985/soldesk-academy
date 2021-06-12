<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- 톰켓 에 conf 에 URIEncoding = "utf-8" 환경변수 를 지정해 준것은 GET만 해당  -->
<%
	request.setCharacterEncoding("utf-8");
	// 스프링 가면 필터로 지정함  web.xml 에 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// String subject = request.getParameter("subject"); 
String subject = request.getParameter("subgroup"); 

%>
<% if(subject==null) {%>
<%
	// ?fid = 홍길동 -> id 에 홍길동이 저장 
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
%>

<p> <%= id  %> </p>
<p> <%= password  %> </p>
<p> <%= email  %> </p>
<%} else{ %>
<%= subject  %>
<%} %>


</body>
</html>