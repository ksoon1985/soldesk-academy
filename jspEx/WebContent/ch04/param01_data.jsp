<%@page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	// form 에서 method 방식이 post일 때 

	String id = request.getParameter("id");
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : <%= id %> </p>
	
	<% String n = request.getParameter("name"); %>
	
	<p>이 름 : <%= URLDecoder.decode(n) %> </p>
</body>
</html>