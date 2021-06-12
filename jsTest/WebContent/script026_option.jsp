<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	// window.onload : 현재 페이지가 메모리에 로딩이 다 되면 
	window.onload = function(){ 
	document.frm.onsubmit=function(){
		var optFruit = document.frm.fruit;
		alert(optFruit.selectedIndex + "=" + optFruit.value); 
		//-> 선택된 항목의 인덱스 와 값 
	};
};
</script>
</head>
<body>
<form name="frm" method="get" action="#">
	<p>과일선택</p>
	<select name="fruit">
		<option value="fruit">과일을 선택하세요</option>
		<option value="apple">사과</option>
		<option value="kiwi">키위</option>
		<option value="banana">바나나</option>
	</select>
	<input type="submit" value="commit" />
	
</form>

</body>
</html>