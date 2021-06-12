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

	<table >
	<tr> 
	<td>

		<form method="post" action="ProductProc?flag=insert" enctype="multipart/form-data">
			<table>
				<thead>
					<tr> 
					<td colspan="2" ><font color="#FFFFFF">상품 등록</font></td>
					</tr>
				</thead>
				<tbody>
					<tr> 
						<td>상품이름</td>
						<td ><input type="text" name="name" size="20"></td>
					</tr>
					<tr> 
						<td >상품가격</td>
						<td ><input type="text" name="price" size="20">원</td>
					</tr>
					<tr> 
						<td>상품설명</td>
						<td><textarea rows="10" cols="45" name="detail"></textarea></td>
					</tr>
					<tr> 
						<td>상품수량</td>
						<td><input type="text" name="stock" size="10">개</td>
					</tr>
					<tr> 
						<td>상품이미지</td>
						<td><input type="file" name="image"></td>
					</tr>
					<tr> 
						<td> 
						<!-- chk title기입 -->
						<button type="submit" id ="inputCheck">상품등록</button> 
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
						<button type="reset">다시쓰기 </button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	
	</td>
	</tr>
	</table>

     <c:import url="Bottom.jsp"/>

</body>
</html>

