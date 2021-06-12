<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>
 
<body>

	 <c:import url="Top.jsp"/>


	<table>
	<tr> 
	<td>
 
	 <table>
		<tr > 
			<td><font color="#FFFFFF">이름</font></td>
			<td><font color="#FFFFFF">가격</font></td>
			<td><font color="#FFFFFF">날짜</font></td>
			<td><font color="#FFFFFF">재고</font></td>
			<td>&nbsp;</td>
		</tr>
		<c:choose>
		 <c:when test="${pdtoList.size}">
			<tr> 
			<td align="center" colspan="5">등록된 상품이 없습니다.</td>
			</tr>
		 </c:when>
		 <c:otherwise>
			 <c:forEach var="pdto" items="${pdtoList}">
				<tr> 
				<td align="center">${pdto.name}</td>
				<td align="center">${pdto.price}</td>
				<td align="center">${pdto.date}</td>
				<td align="center">${pdto.stock}</td>
				<td align="center"><a href="javascript:productDetail('${pdto.no}')">상세보기</a></td>
				</tr>
			 </c:forEach>
		 </c:otherwise>
		</c:choose>
		<tr>
		<td colspan="5" align="center"><a href="productInsert">상품등록</a></td>
		</tr>
		</table>
		
	</td>
	</tr>
	</table>

   <c:import url="Bottom.jsp"/>
	
	<form name="detail" method="post" action="productDetail" >
	  <input type="hidden" name="no">
	</form>

</body>
</html>
   