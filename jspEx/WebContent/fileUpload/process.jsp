<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*
			multi
		*/
		MultipartRequest multi = new MultipartRequest(request,"C:/study/upload",
				5*1024*1024,"utf-8" // 5mb
				,new DefaultFileRenamePolicy());
		
		//multi.getParameterNames -> file 이 아닌 받아온 parameter 이름들
		Enumeration params = multi.getParameterNames(); // name , title
		
		while(params.hasMoreElements())
		{
			String name = (String)params.nextElement(); // name , title 
			String value = multi.getParameter(name);	 // 그스   ,  그스   (사용자가 form태그에 입력한 값 )
			out.println(name + " = " + value + "<br>");
		}
		out.println("============================<br>");
		
		//multi.getFileNames -> 받아온 file parameter 이름들
		Enumeration files = multi.getFileNames(); // fileName
		
		//받아온 파라미터 가 있냐 
		while(files.hasMoreElements())
		{
			String name = (String)files.nextElement(); // 있으면 input박스의 type 이 file 인 name 값 
			String filename = multi.getFilesystemName(name); // 파일시스템상 이름  
			String original = multi.getOriginalFileName(name); // 원본파일 이름 
			String type = multi.getContentType(name); // 콘텐츠 유형  
			
			//multi.getFile -> file 을 구해옴 
			File file = multi.getFile(name); // name : fileName
			
			out.println("요청 파라미터 이름 : " + name + "<br>");   // fileName
			out.println("실체 파일 이름 : " + original + "<br>");  // 12.txt
			out.println("저장 파일 이름 : " + filename + "<br>");  // 125.txt(중복으로 5번 올려서 실제 시스템상 125.txt로 저장됨)
			out.println("파일 콘텐츠 유형 : " + type + "<br>");    //  text/plain
			
			if(file != null)
			{
				out.println("파일 크기 : " + file.length()); // 파일의 크기  1127
				out.println("<br>");
			}
		}
	%>
</body>
</html>