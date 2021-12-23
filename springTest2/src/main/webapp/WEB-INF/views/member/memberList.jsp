<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="kr.or.sol.memmgt.dto.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="./resources/member/css/board.css" rel="stylesheet">

<script type="text/javascript">
	function MemInfo(num)
	{
		document.content.memseq.value = num;
		document.content.submit();
	}
</script>

</head>
<body>

	<!-- <c:set var="list" value="${list}" /> -->
	
	<h3 class="title">멤버 목록 </h3>
	
	<c:choose>
		<c:when test="${list.size()==0}">
			<table border="1" class="posts-no-exist">
				<tbody>
					<tr>
						<th><h4>회원이 없습니다.</h4></th>
					</tr>
				</tbody>
			</table>
		</c:when>

		<c:when test="${list.size()!=0}">
			<table border="1" class="posts-exist">
				<thead>
					<tr>
						<th colspan="7">
							<h2 style="text-align:right">
								전체 회원 수 : &nbsp;<c:out value="${allCnt}"/>&nbsp;						</h2>
						</th>
					</tr>
					<tr>
						<th>순번</th>
						<th>회원명(id)</th>
						<th>이메일</th>
						<th>생년월일</th>
						<th>가입일자</th>
						<th>연락처</th>
						<th>성별</th>
					</tr>
				</thead>
				<tbody>
				<%-- <a href='mailto.jsp?email=<c:out value="${dto.email}"/>'> --%>
					
					<c:forEach var="mdto" items="${list}" varStatus="i">
						<tr>
							<td><c:out value="${mdto.rr}"/>
								<input type="hidden" value='<c:out value="${mdto.memseq}"/>'>
							</td>

							<td>
								<a href="#" onclick="javascript:MemInfo('<c:out value= "${mdto.memseq}" />')" >
									<c:out value="${mdto.memname}"/>(<c:out value="${mdto.memid}"/>)
								</a>
							</td>

							<td>
								<c:out value="${mdto.mememail}" />
							</td>
							
							<td>
								<c:out value="${mdto.membirth}" />
							</td>
							
							<td>
								<c:out value="${mdto.regdate}" />
							</td>
							
							<td>
								<c:out value="${mdto.memtel}" />
							</td>
							
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
						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="7" align="right">
							<a href="signUpForm.sp"> 
								<input type="button" value="회원가입" />
							</a>
						</td>
					</tr>
				</tbody>
			</table>
			<!--  
	 		<h5 style="text-align: center">
	    		<c:if test="${pdto.startPage > pdto.pageBlock}">
	        		<a href="/boardList.sp?currentPage=${pdto.startPage-pdto.pageBlock}&currPageBlock=${pdto.currPageBlock-1}"
	          		style=" text-decoration: none;"> [이전]</a>
	   		    </c:if>
	   			<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
	      			<a href="/boardList.sp?currentPage=${i}&currPageBlock=${pdto.currPageBlock}" style=" text-decoration: none;">
	            		<c:out value="[${i}]"/>&nbsp;
	            	</a>
	    		</c:forEach>
	    		<c:if test="${pdto.endPage < pdto.allPage}">
	        		<a href="/boardList.sp?currentPage=${pdto.endPage+1}&currPageBlock=${pdto.currPageBlock+1}"
	          			style=" text-decoration: none;"> [다음]
	          		</a>
	    		</c:if>
	  		</h5>
	  		-->
		</c:when>
	</c:choose>
	
		<form action="memberInfo.sp" name="content" method="post">
			<input type="hidden" name="memseq"  value='' />
		</form>
</body>
</html>

