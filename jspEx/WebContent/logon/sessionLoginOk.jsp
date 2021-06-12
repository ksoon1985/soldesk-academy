<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logon.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="dto" class="logon.LogonDTO"/>
<jsp:setProperty property="*" name="dto"/>

<!-- id 와 passwd 받기 -->

<!-- DAO 호출 실행하고 결과 가지고 ALERT 띄움  -->
<%
	LogonDAO dao = LogonDAO.getInstance();
	
	int c = dao.userCheck(dto.getId(),dto.getPasswd());
	
	out.println(c);
	
	if(c==1){
		
		session.setAttribute("memId",dto.getId());
		response.sendRedirect("sessionLogonConfirm.jsp");
	}
	else{
		out.println("아이디가 없거나 비밀번호가 틀립니다. ");
	}
	
%>

</body>
</html>