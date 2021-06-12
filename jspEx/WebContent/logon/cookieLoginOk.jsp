<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="logon.*" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- id 와 passwd 받기 -->
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
%>

<!-- DAO 호출 실행하고 결과 가지고 ALERT 띄움  -->
<%
	LogonDAO dao = LogonDAO.getInstance();

	int c = dao.userCheck(id, passwd);
	
	out.println(c);
	
	if(c==1){
		Cookie ck = new Cookie("memId",id);
		ck.setMaxAge(10*60); // 10분
		response.addCookie(ck); // 쿠키 저장 
		
		response.sendRedirect("okLogonConfirm.jsp");
	}
	else{
		out.println("아이디가 없거나 비밀번호가 틀립니다. ");
	}
	
	
%>

</body>
</html>