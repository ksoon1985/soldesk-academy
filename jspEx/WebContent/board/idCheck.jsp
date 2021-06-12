<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="./js/boardScript.js" type="text/javascript"></script>

</head>
<body>

		
		<table>
			<tr>
				<td>비밀번호입력 : </td>
				<td><input type="password" id="pwCheck" />
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="확인" 
					onclick="javascript:setParentText()"/>
				</td>
				<td colspan="2">
					<input type="button" value="닫기" 
					onclick="window.close()"/>
				</td>
			</tr>
		</table>	
		
</body>
</html>