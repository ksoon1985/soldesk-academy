<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="kr.co.sol.board.dto.*, java.util.*"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
<c:redirect url="boardList.sp?currentPage=${pvo.currentPage}&currPageBlock=${pvo.currPageBlock}">
</c:redirect>
</body>
</html>