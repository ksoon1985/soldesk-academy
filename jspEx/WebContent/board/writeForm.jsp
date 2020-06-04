<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

<style type="text/css">
	table , th , td {
		border:1px solid black;
	}
</style>

<script src="./js/jquery.js"></script>
<script src="./js/boardScript.js"></script>
<script src="./js/jquery_board.js"></script>
</head>
<body>
	<jsp:useBean id="dto" class="board.BoardDTO"/>
	<jsp:setProperty property="*" name="dto" />
	<!-- form 은 name으로 타고들어감  -->
	
	<form action="writePro.jsp" method="post" name="writeForm" onsubmit="return sendData()">
		
		<input type="hidden"    name="num" 			value="${dto.num}" />
		<input type="hidden" 	name="ref" 			value="${dto.ref}" />
		<input type="hidden" 	name="re_step" 		value="${dto.re_step}" />
		<input type="hidden" 	name="re_level" 	value="${dto.re_level}" />
		
		<table>
			<thead>
				<tr>
					<th colspan="2"><h3>글쓰기</h3></th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<th>제목 : </th>
					
					<c:if test="${dto.num==0}">
					<td>
						<input type="text" size="100%" name ="subject" placeholder="제목을 입력하세요 " id ="subject"/>
					</td><!-- setProperty 에선 name으로 파라미터 값을 받음  -->
					</c:if>
					
					<c:if test="${dto.num !=0 }">
					<td>[답글]
						<input type="text" size="100%" name ="subject" placeholder="제목을 입력하세요 " id ="subject"/>
					</td><!-- setProperty 에선 name으로 파라미터 값을 받음  -->
					</c:if>
				</tr>
				<tr>
					<th>내용 : </th>
					<td>
						<textarea cols="102" rows="20" name="content" id="content"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일 : </th>
					<td>
						<input type="file" placeholder="파일을 선택하세요" name="attachnm" id="attachnm"/>
					</td>
				</tr>
				<tr>
					<th>작성자 : </th>
					<td>
						<input type="text" placeholder="작성자명을 입력하세요 " name="writer" id="writer"/>
					</td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td>
						<input type="text" placeholder="이메일 주소를  입력하세요 " name="email" id="email"/>
					</td>
				</tr>
				<tr>
					<th>비빌번호 : </th>
					<td>
						<input type="password" name ="passwd" placeholder="비밀번호를 입력하세요  " id="passwd" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록" />
						<input type="button" value="글 목록으로..." id="list1" />
					 </td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>