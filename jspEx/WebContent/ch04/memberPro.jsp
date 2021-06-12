<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.dbutil.* , java.sql.* , javax.naming.* " %>
<%
	request.setCharacterEncoding("UTF-8");
%> 

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 확인</title>

<style type="text/css">
	table , td{
		border : 1px solid black;
	}
	table{
		width: 60%;
		height: 100px;
		margin: auto;
		text-align: center;		
	}
	table tbody td input{
	
	}
	h3{
		width:60%;
		text-align:center;
	}
</style>
</head>
<body>

	<jsp:useBean id="person" class="jspEx.ch04.Person" scope="request" />
	<jsp:setProperty property="*" name="person"/>
	<!-- member.jsp 에서 받은 (파라미터들 )속성들을  person 의 property에 맞게 대입시켜줌  -->
	<!-- form 태그에서 id는 id로 name은 name으로 ...  -->
	
	
	<h3>회원가입확인 </h3>
	<table>
			<tbody>
				<tr>
					<th align="right">아이디 : </th>
					<td align="left"><jsp:getProperty property="id" name="person"/>
					</td>
				</tr>
				
				<tr>
					<th align="right">이 름  : </th>
					<td align="left"><jsp:getProperty property="name" name="person"/>
					</td>
				</tr>
				
				<!-- 				
				<tr>
					<td colspan="2" align="center">
						<input type ="submit" value="가입"/>
					</td>
				</tr>
				-->
			</tbody>
		</table>
</body>
</html>

	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			if(conn!=null) out.println("db연결 성공");
			
			//System.out.println(person.getId());
			String sql = "insert into person(id,name) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("id"));
			pstmt.setString(2,request.getParameter("name"));
			
			pstmt.executeQuery();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			out.println("db연결 실패");
			out.println(e.getMessage());
		}
	%>