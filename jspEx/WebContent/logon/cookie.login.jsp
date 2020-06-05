<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키</title>

<style type="text/css" >
table{
	margin:auto;
	text-align:center;
	}
</style>

<script src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){
	$('#submit').click(function(){
		var idLength = $()
		if($('#id').val()==null || $('#id').val()=='')
		{
			alert("아이디를 입력하세요 ");
			
			$('#id').focus();
			
			return;
		}
		
		if($('#passwd').val()==null || $('#passwd').val()=='')
		{
			alert("비밀번호를 입력하세요 ");
			
			$('#passwd').focus();

			return;
		}
		
		$('#logonForm').submit();
	});
})
</script>

</head>
<body>
	<form action="cookieLoginOk.jsp" id="logonForm" method="post" >
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id" 
						size="20" placeholder="아이디를 입력하세요 " /></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="passwd" id="passwd"
						 size="20" placeholder="패스워드를 입력하세요" /></td>
				</tr>
				<tr>
					<th colspan="2">
						<span id="submit"> 로그인 </span>
					</th>
				</tr>
				
			</tbody>
		</table>
	</form>
</body>
</html>