<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 처리</title>
</head>
<body>
	
	<%
	/*
		// dao instance 받아오기 
		BoardDAO dao = BoardDAO.getInstance();
		
		int r = dao.boardWrite(dto);
		response.sendRedirect("boardList.jsp");

			if(r>0) response.sendRedirect("boardList.jsp"); 
			else out.println("저장 못함 !!!"); 
		*/
	%>
	<c:redirect url="list.do?currentPage=${pdto.currentPage}&currPageBlock=${pdto.currPageBlock}"></c:redirect>
</body>
</html>