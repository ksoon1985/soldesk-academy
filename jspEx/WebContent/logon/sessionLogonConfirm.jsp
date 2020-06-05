<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	if(session.getAttribute("memId")==null)
	{
		response.sendRedirect("cookieLogin.jsp");
	}else if(session.getAttribute("memId") != null){
		
	}
	
%>

<!-- 회원이 맞으므로 세션(연결) 부여  -->

	<form action="sessionLogout.jsp" id="form1" name="form1">
		<table>
			<tbody>
				<tr>
					<th>로그인 성공<br/></th>
					<td><%= session.getAttribute("memId") %> 님이 로그인 하셨습니다.<br/></td>
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