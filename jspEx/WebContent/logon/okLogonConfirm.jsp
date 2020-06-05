<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#logout').click(function(){
		
		$('#form1').submit();

	});
	
})
</script>


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
				id = c.getValue();
			}
		}
		
		if(id.equals(""))
		{
			// 로그인 화면으로 이동 
			response.sendRedirect("cookieLogin.jsp");
		}
	}else
	{
		// 다시 로그인 화면으로 이동
		response.sendRedirect("cookieLogin.jsp");
	}
	
%>

<!-- 회원이 맞으므로 세션(연결) 부여  -->

	<form action="cookieLogout.jsp" id="form1" name="form1">
		<table>
			<tbody>
				<tr>
					<th>로그인 성공<br/></th>
					<td><%= id %> 님이 로그인 하셨습니다.<br/></td>
				</tr>
				<tr>
					<th colspan="2">
						<div id="logout" >로그아웃</div>
					</th>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>