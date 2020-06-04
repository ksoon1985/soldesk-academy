<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, td{
		border : 1px solid black;
	}
	table{
		width: 60%;
		height: 100px;
		margin: auto;
		text-align: center;		
	}
	table tbody td input{
	
	}
	h3{
		width:60%;
		text-align:center;
	}
</style>
</head>
<body>
	<form action="memberPro.jsp" name="memForm" method="post">
		<table>
			<thead>
				<tr>
					<th colspan="1">회원가입</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th align="right">아이디 : </th>
					<td align="left">
						<input type ="text" name="id" value="" size="20"/>
					</td>
				</tr>
				
				<tr>
					<th align="right">이 름  : </th>
					<td align="left">
						<input type ="text" name="name" value="" size="20"/>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type ="submit" value="가입"/>
					</td>
				</tr>
				
			</tbody>
		</table>
	</form>
</body>
</html>