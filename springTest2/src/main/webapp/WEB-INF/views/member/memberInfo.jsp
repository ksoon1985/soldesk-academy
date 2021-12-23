<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<script src="./resources/member/js/boardScript.js" type="text/javascript"></script>
<script src="./resources/member/js/jquery_board.js" type="text/javascript" ></script>


</head>
<body>
		<table>
			<tbody>
				<tr>
					<th>SEQ : </th>
					<td>
						<c:out value="${mdto.memseq}" /> 
					</td>
				</tr>
				<tr>
					<th>회원명(id) : </th>
					<td>
						<c:out value="${mdto.memname}"/>(<c:out value="${mdto.memid}"/>)
					</td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td>
						<c:out value="${mdto.mememail}" />
					</td>
				</tr>
				<tr>
					<th>생년월일 : </th>
					<td>
						<c:out value="${mdto.membirth}" /> 
					</td>
				</tr>
				<tr>
					<th>가입일자 : </th>
					<td>
						<c:out value="${mdto.regdate}" /> 
					</td>
				</tr>
				<tr>
					<th>연락처:</th>
					<td>
						<c:out value="${mdto.memtel}" />
					</td>
				</tr>
				<tr>
					<th>성별 : </th>
					<td>
						<c:if test="${fn:contains(mdto.memgender,'F')}" >
							<c:out value="여성" />
						</c:if>
						<c:if test="${fn:contains(mdto.memgender,'M')}" >
							<c:out value="남성" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="회원 수정" name="update" onclick="javascript:passwdCheck('u')"/>
						<input type="button" value="회원 삭제" name="delete" onclick="javascript:passwdCheck('d')"/>
						<a href="memberList.sp" ><input type="button" value="회원 목록으로"/></a>
					</td>
				</tr>
			</tbody>
		</table>
		
		<form action="" name="parentForm" method="post">
			<input type="text"   name="memseq" 	value="${mdto.memseq}" />
			<input type="text"   name="regdate" value="${mdto.regdate}"/>
			
			<input type="text"   name="passwd" 	value="${mdto.mempasswd}"/>
			<input type="text"   name="cpass" 	value="" />
		</form>
</body>
</html>