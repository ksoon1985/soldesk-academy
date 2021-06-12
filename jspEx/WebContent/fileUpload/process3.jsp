<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String fileUploadPath = "C:/study/upload"; 		// 파일이 저장될 저장소(경로)
		
		DiskFileUpload upload = new DiskFileUpload(); 	// 객체(파일)를 추출(가져오기)하기 위해 DiskFileUpload 사용 
		
		List items = upload.parseRequest(request);		// request로 온 파라미터들 을 위의  DiskFileUpload통해 items저장
														
		// file 이 아니면 결국 밑에처럼 name 에 null이 들어감  
		// items : name=null, StoreLocation=C:\\study\\upload\\upload_6841863a_17297b56aa4__8000_00000011.tmp, size=6bytes, isFormField=true, FieldName=name
		// items : name=12.txt, StoreLocation=C:\\study\\upload\\upload_6841863a_17297b56aa4__8000_00000013.tmp, size=1127bytes, isFormField=false, FieldName=fileName
		Iterator params = items.iterator();
		
		while(params.hasNext())
		{
			FileItem fileItem = (FileItem) params.next(); 
			
			if(!fileItem.isFormField()) // 받은 파라미터가 file 이냐 
			{
				String fileName = fileItem.getName();
				System.out.println(fileName); // (파일명 )jquery-1.12.4.min.js
				
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				System.out.println(fileName); // (파일명 )jquery-1.12.4.min.js
				
				File file = new File(fileUploadPath + "/" + fileName); 
									// C:/study/upload / jquery-1.12.4.min.js
				fileItem.write(file);
			}
		}
	%>
</body>
</html>