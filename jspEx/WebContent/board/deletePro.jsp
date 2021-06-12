<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 	
	
	<jsp:useBean id="dto" class= "board.BoardDTO"/>
	<jsp:setProperty property="*" name="dto"/> 
	
	--%>
	
	
	<%
	
	int num = Integer.parseInt(request.getParameter("num"));
	
	//DAO에 대한 인스턴스 받아오기 	
	BoardDAO dao =BoardDAO.getInstance(); 

	BoardDTO dto = dao.getArticle(num);
	
	int r= dao.boardDelete(dto);	

	
	if(r>0)response.sendRedirect("boardList.jsp");
	else out.println("저장못함!!!");
	
	%>
</body>
</html>