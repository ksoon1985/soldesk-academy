<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="board.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
%>



</head>
<body>
		<form action="" name="check" method="post">
			<input type="text" name="num" value="<%= num %>" />
		</form>
<script type="text/javascript">
	var check = window.confirm("정말 삭제하시겠습니까 ? ");
	if(check)
	{
		document.check.action = 'deletePro.jsp';
	}
	else
	{
		document.check.action = 'content.jsp';
	}
	
	document.check.submit();
</script>
</body>
</html>