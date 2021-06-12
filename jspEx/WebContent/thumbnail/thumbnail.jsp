<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸내일 예제</title>
</head>
<body>
	<form name="fileForm" method="post" enctype="multipart/form-data"
		action="thumbnailPro.jsp">
		
		원본이미지
		<input type="file" name="image"><br>
		<input type="submit" value="썸네일 이미지 만들기 ">	
	</form>
</body>
</html>