<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userid = request.getParameter("id");
		String passward = request.getParameter("passwd");
		
		if(userid.equals("관리자") && passward.equals("1234"))
		{
			response.sendRedirect("response02_success.jsp");
		}
		else
		{
			response.sendRedirect("response02_failed.jsp");
		}
	%>

	
</body>
</html>