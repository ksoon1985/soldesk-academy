<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "com.dbutil.* , java.sql.* , javax.naming.* " %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	try {
		conn = DBConnection.getConnection();
		
		String sql = "select sysdate from dual";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			out.print(rs.getString(1));
		}
	} catch (NamingException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
</body>
</html>