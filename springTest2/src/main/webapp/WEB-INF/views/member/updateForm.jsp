<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="./resources/member/js/jquery.js" type="text/javascript"></script>
<script src="./resources/member/js/jquery_board.js" type="text/javascript" ></script>

<script type="text/javascript">
	function dateTransfer()
	{
		var date = $("#regdate1").val();
/* 		var formmatedDate = new Date(date);
		var y = formmatedDate.getFullYear();
		y.substring(2,3);
		window.alert(y);
		var m = formmatedDate.getMonth() + 1;
		window.alert(m);
		var d = formmatedDate.getDate();
		window.alert(d); */
		
		var dateArray = date.split('-'); 
		var dateString = dateArray[0].substring(2,4)+"/"+dateArray[1]+"/"+dateArray[2];
		
		$("#regdate2").val(dateString);

		$("#updateForm").attr("action","updatePro.sp").submit();
	}

</script>

</head>
<body>
	<form action="" id="updateForm" name="joinForm" method="post">
		<table>
			<tbody>
				<tr>
					<th>회원명 : </th>
					<td>
						<input type="text" name="memname" class="chk" value='<c:out value="${mdto.memname}"/>'/>
					</td>
				</tr>
				<tr>
					<th>id : </th>
					<td>
						<input type="text" name="memid" class="chk" value='<c:out value="${mdto.memid}"/>'/>
					</td>
				</tr>
				<tr>
					<th>passwd : </th>
					<td>
						<input type="password" name="mempasswd" class="chk" value='<c:out value="${mdto.mempasswd}"/>'/>
					</td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td>
						<input type="text" name="mememail" class="chk" value='<c:out value="${mdto.mememail}"/>'/>
					</td>
				</tr>
				<tr>
					<th>생년월일 : </th>
					<td>
						<input type="date" name="membirth" class="chk" min="1950-01-01" max="2020-01-01"
							 value='<c:out value="${mdto.membirth}"/>'/>
					</td>
				</tr>
				<tr>
					<th>가입일자 : </th>
					<td>
						<input type="date" name="regdate1" class="chk" id="regdate1"
							min="1950-01-01" max="2020-01-01"
							value='<c:out value="${mdto.regdate}"/>'/>
							
						<input type="hidden" name="regdate" value="" id="regdate2" />
					</td>
				</tr>
				<tr>
					<th>연락처:</th>
					<td>
						<input type="text" name="memtel" class="chk" value='<c:out value="${mdto.memtel}"/>'/>
					</td>
				</tr>
				<tr>
					<th>성별 : </th>
					<td>
						<input type="radio" name="memgender"  title="성별" value="M"/>남자
						<input type="radio" name="memgender"  title="성별" value="F" checked/>여자
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="수정" onclick="javascript:dateTransfer()"/>
						<a href="memberList.sp" ><input type="button" value="회원 목록으로"/></a>
					</td>
				</tr>
			</tbody>
		</table>
		
		<input type="text" name="memseq" value="${mdto.memseq}" />
	</form>
</body>
</html>