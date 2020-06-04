<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/jspEx/board2/css/board.css" rel="stylesheet">
<link href="/jspEx/board2/css/content.css" rel="stylesheet">

<script src="/jspEx/board2/js/jquery.js"></script>
<script src="/jspEx/board2/js/boardScript.js" type="text/javascript" ></script>
<script src="/jspEx/board2/js/jquery_board.js" type="text/javascript" ></script>


<!-- 
<script type="text/javascript">
function pwCheck(){
	window.name="parentForm";
	window.open("idCheck.jsp","idCheck","width=500, height=300, resizable = no, scrollbars = no");
}
</script>
 -->
</head>
<body>
	<!-- form 은 name으로 타고들어감  -->
		<table>
			<tbody>
				<tr>
					<th>글번호 : </th>
					<td>
						<c:out value="${dto.num}" /> 
					</td>
				</tr>
				<tr>
					<th>글제목 : </th>
					<td>
						<c:out value="${dto.subject}" /> 
					</td>
				</tr>
				<tr>
					<th>내용 : </th>
					<td>
						<textarea cols="102" rows="20" readonly>
							<c:out value="${dto.content}" /> 
						</textarea>
					</td>
				</tr>
				<tr>
					<th>작성자 : </th>
					<td>
						<c:out value="${dto.writer}" /> 
					</td>
				</tr>
				<tr>
					<th>작성일 : </th>
					<td>
						<c:out value="${dto.reg_date}" /> 
					</td>
				</tr>
				<tr>
					<th>조회수 : </th>
					<td>
						<c:out value="${dto.readcnt}" /> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="글수정" name="update" onclick="javascript:pwCheck('u')"/>
						<input type="button" value="글삭제" name="delete" onclick="javascript:pwCheck('d')"/>
						<input type="button" value="답글" id="reply" />
						<input type="button" value="글목록으로 ..." id="list1" onclick="javascript:location.href='list.do'"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<form action="" name="parentForm" method="post">
			<input type="text"   name="passwd" 		value="${dto.passwd}" />
			<input type="text"   name="num" 		value="${dto.num}" />
			<input type="text"   name="cpass" 		value="" />
			<input type="text"	 name="ref" 		value="${dto.ref}" />
			<input type="text" 	name="re_step" 		value="${dto.re_step}" />
			<input type="text" 	name="re_level" 	value="${dto.re_level}" />
			
		</form>
		
</body>
</html>