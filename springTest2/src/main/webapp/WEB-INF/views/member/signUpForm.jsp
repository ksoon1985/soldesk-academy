<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table , th , td {
		border:1px solid black;
	}
</style>
<script src="./resources/member/js/jquery.js" type="text/javascript"></script>
<script src="./resources/member/js/jquery_board.js" type="text/javascript" ></script>
	
</head>
<body>
<form action="signUpPro.sp" method="post" name="joinForm"> 

		<table>
			<thead>
				<tr>
					<th colspan="2"><h3>회원가입</h3></th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<th>이름 : </th>
					<td>
						<input type="text" class="chk" title="이름" size="70%" name ="memname" placeholder="제목을 입력하세요 "/>
					</td>
				</tr>
				<tr>
					<th>id : </th>
					<td>
						<input type="text" class="chk" id="idchk" title="아이디" size="70%" 
						name ="memid" placeholder="제목을 입력하세요 "/>
					</td>
					
					
				</tr>
				<tr>
					<th>passwd : </th>
					<td>
						<input type="password" id="passwd1" class="chk" title="비밀번호" size="70%" name ="mempasswd" placeholder="비밀번호을 입력하세요 "/>
					</td>
				</tr>
				<tr>
					<th>passwd 확인 : </th>
					<td>
						<input type="password" id="passwd2" class="chk" title="비밀번호" size="70%" name ="passwd2" placeholder="비밀번호을 확인하세요"/>
						<font name="check" size="2" color="red"></font>
					</td>
				</tr>
				
				<tr>
					<th>Tel : </th>
					<td>
						<input type="tel" class="chk" size="70%" title="전화번호" name="memtel" placeholder="전화번호를 입력하세요"/>
					</td>
				</tr>
				<tr>
					<th>email : </th>
					<td>
						<input type="text" class="chk" size="70%" title="이메일" name="mememail" placeholder="이메일을 입력하세요"/>
					</td>
				</tr>
				<tr>
					<th>성별 : </th>
					<td>
						<input type="radio" name="memgender" title="성별" value="M"/>남자
						<input type="radio" name="memgender" title="성별" value="F" checked/>여자
					</td>
				</tr>
				<tr>
					<th><label for="birth">생년월일 : </label></th>
					<td>
						<input type="date" class="chk" name="membirth" placeholder="생년월일을 입력하세요" id="birth" title="생년월일"
						value ="2018-07-22" min="1950-01-01" max="2020-01-01"/>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="submit1" name="submit1" value="등록" />
						<input type="button" id="list2"   name="list2"   value="글목록으로..." />
					 </td>
				</tr>
			</tbody>
		</table>
	</form>
	
</body>
</html>