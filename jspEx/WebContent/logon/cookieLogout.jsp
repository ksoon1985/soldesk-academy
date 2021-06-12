<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/jquery.js"></script>

</head>
<body>
<%
	String id = "";
	// 모든 쿠키를 배열로 받는다.
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null)
	{
		// memId 가 있는지 확인해서 해당 id 가져오기 
		for(Cookie c : cookies)
		{
			if(c.getName().equals("memId"))
			{
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
	}
	response.sendRedirect("okLogonConfirm.jsp");
	
%>

</body>
</html>