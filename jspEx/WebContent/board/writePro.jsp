<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="board.BoardDAO" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 처리</title>
</head>
<body>
	<jsp:useBean id="dto" class="board.BoardDTO"/>
	<jsp:setProperty property="*" name="dto" />
	<!-- DTO 로 가져온 유즈빈을 article로 정해주고 setProperty 해서 * 로 모든 속성을 가져옴  -->
	
	<%
		// dao instance 받아오기 
		BoardDAO dao = BoardDAO.getInstance();
		
		int r = dao.boardWrite(dto);
		response.sendRedirect("boardList.jsp");
		
		/*
			if(r>0) response.sendRedirect("boardList.jsp"); 
			else out.println("저장 못함 !!!"); 
		*/
	%>
</body>
</html>