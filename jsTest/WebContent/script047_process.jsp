<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.Map"%>  
<% 
	request.setCharacterEncoding("utf-8");
	String program = request.getParameter("program");
	String program2 = request.getParameter("program2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

	if(program == null) //research2 가 요청 왔을 때  
	{
		if(program2.equals("BR"))
			out.write("정답입니다.");
		else{
			out.println("<script>alert('정답이 아닙니다. 다시 풀어주세요');</script>");
/* 			out.write("정답이 아닙니다. 다시 풀어주세요 "); */
			response.sendRedirect(request.getHeader("Referer"));
		}
		return ;
	}
	if(program2 == null)
	{
		if(program.equals("HTML"))
			out.write("정답입니다.");
		else{
			out.println("<script>alert('정답이 아닙니다. 다시 풀어주세요');</script>");
/* 			out.write("정답이 아닙니다. 다시 풀어주세요 "); */
			response.sendRedirect(request.getHeader("Referer"));
			}
		return ;
	}
	
%>
</body>
</html>