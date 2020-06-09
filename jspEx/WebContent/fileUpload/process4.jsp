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
	String path = "C:/study/upload";
	
	//파일 업로드 해주는 클래스
	DiskFileUpload upload = new DiskFileUpload();
	
	upload.setSizeMax(1000000); // byte단위 , 업로드할 수 있는 최대값 
	upload.setSizeThreshold(4096); //byte단위 , 메모리 버퍼의 최대값  , 최대값을 넘길경우 버패내의 데이터를 일시적 저장 
	upload.setRepositoryPath(path); // 파일 임시 저장소 
	
	List items = upload.parseRequest(request); 
	
	for(Object item : items)
	{
		System.out.println(item);
		// name=null, StoreLocation=C:\\study\\upload\\upload_6841863a_17297b56aa4__8000_00000011.tmp, size=6bytes, isFormField=true, FieldName=name
		// name=null, StoreLocation=C:\\study\\upload\\upload_6841863a_17297b56aa4__8000_00000012.tmp, size=6bytes, isFormField=true, FieldName=title
		// name=12.txt, StoreLocation=C:\\study\\upload\\upload_6841863a_17297b56aa4__8000_00000013.tmp, size=1127bytes, isFormField=false, FieldName=fileName
	}
	
	Iterator params = items.iterator();
	
	while(params.hasNext())
	{	
		FileItem item = (FileItem) params.next();
		
		if(item.isFormField()) // input type ="file"이 아닌경우  즉, name = null 이 아닌경우 
		{
			String name = item.getFieldName();			// name  값
			String value = item.getString("utf-8");		// value 값
			out.println(name + "=" + value + "<br>");
		}
		else // file 인경우 
		{
			String fileFieldName = item.getFieldName(); // name 값
			String fileName = item.getName(); 			// 파일 이름 
			String contentType = item.getContentType(); // 콘텐츠 유형 
			
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1 );
			
			long fileSize = item.getSize();				// 파일 사이즈 
			
			File file = new File(path + "/" + fileName); // 저 경로 + fileName 으로 파일하나 만들고
			item.write(file); // item 값을  fileName에 작성하라 
			
			out.println("------------------------------<br>");
			
			out.println("요청 파라미터 이름 : " + fileFieldName + "<br>");
			out.println("파일 저장 이름  : " + fileName + "<br>");
			out.println("파일 콘텐츠 유형 : " + contentType + "<br>");
			out.println("파일 크기 : " + fileSize);
		}
	}
%>
</body>
</html>