<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	request.setCharacterEncoding("utf-8");
	String other = request.getParameter("other");
	String other2 = request.getParameter("subject");
	String[] checkbox = request.getParameterValues("subject");
	String radio = request.getParameter("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= other %><br/>
	<%= other2 %><br/>
<%-- 	<%= other3[0] %>
	<%= other3[1] %>
	<%= other3[2] %> --%>
	
	<% for(int i=0;i<checkbox.length;i++) {%>
	<%= checkbox[i] %>
	<%} %>
	
	<%= radio %>>
</body>
</html>