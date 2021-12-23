<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 
          uri="http://java.sun.com/jsp/jstl/functions"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link href="./resources/member/css/member.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./resources/member/js/jquery_member.js" 
          type="text/javascript"></script>
<script type="text/javascript">
/*  function cllInfo(memid){
	 $('#memform').val(memid);
	 alert($('#memform').val())
	 $('#memform').submit()
 } */
 
 function cllInfo(memid){
	 document.memform.memid.value=memid;
	 document.memform.submit();
 }
</script>
</head>
<body>
<h3 style="text-align: center;">게시글 목록</h3>

<c:choose>
 <c:when test="${list.size()==0}">
	<table border="1">
	  <tbody class="class02">
	    <tr><th><h4>가입된 회원이 없습니다.</h4></th>
	    </tr>
	  </tbody>
	</table>
 </c:when>
 <c:when test="${list.size()!=0}">
 	<table>
 	  <thead class="class01 ">
 	    <tr><th colspan="6"><h4 style="text-align: right;">전체 회원수:&nbsp;<c:out value="${allCnt}"/>&nbsp;명</h4></th></tr> 
 	    <tr><th>순번</th>
 	    <th>회원명(id)</th>
 	    <th>생년월일</th>
 	    <th>가입일자</th>
 	    <th>연락처</th>
 	    <th>성별</th>
 	    </tr>
 	  </thead>
	  <tbody class="class02">
		<!-- 해당 리스트를 출력  jstl 사용-->
		<c:forEach var="mdto" items="${list}" varStatus="i">
		   <tr>
		     <td align="center"><c:out value="${mdto.rr}"/>
		       <input type="hidden" 
		         value='<c:out value="${mdto.memseq}"/>'>
		     </td>
			   <td >
			       <a href='#' id="meminfo" onclick="cllInfo('${mdto.memid}')">
			       <c:out value="${mdto.memname}"/>(<c:out value="${mdto.memid}"/>)
		  	       </a>
			      </td>
			     <td >
			       <c:out value="${mdto.membirth}"/>
			      </td>
		       <td>
		       <c:out value="${mdto.regdate}"/>
		       </td>
		     <td><c:out value="${mdto.memtel}"/></td>
		     <td align="center">
		          <c:if test="${fn:contains(mdto.memgender,'F')}">
  		          <c:out value="여성"/>
 		          </c:if>
 		          <c:if test="${fn:contains(mdto.memgender,'M')}">
  		          <c:out value="남성"/>
 		          </c:if>
		     </td>
		   </tr>
		</c:forEach>
		 <tr>
		     <td align="right" colspan="6"> <button onclick="location.href='memberForm.mg'">회원등록</button></td>
		 </tr>
	  </tbody>
	</table>
 </c:when>
</c:choose>
<form action="memInfo.mg" name="memform" method="post">
   <input type="text" name="memid" value=''/>    
</form>

</body>
</html>






