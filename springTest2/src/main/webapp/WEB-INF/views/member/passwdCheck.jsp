<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script src="./resources/member/js/jquery.js" type="text/javascript"></script>
<script src="./resources/member/js/boardScript.js" type="text/javascript"></script>
<script src="./resources/member/js/jquery_board.js" type="text/javascript" ></script>

</head>
<body>
		<table>
			<tr>
				<td>��й�ȣ�Է� : </td>
				<td><input type="password" id="pwCheck" />
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="Ȯ��" 
					onclick="javascript:setParentText()"/>
				</td>
				<td colspan="2">
					<input type="button" value="�ݱ�" 
					onclick="window.close()"/>
				</td>
			</tr>
		</table>	
</body>
</html>