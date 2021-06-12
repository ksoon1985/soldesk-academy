<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table , th
</style>
<style type="text/css">
	table {
		border:1px solid black;
	}
</style>
</head>
<body>
 	<!-- JNDI -->
	<sql:query var="rs" dataSource="jdbc/soldesk">
		select * from person 
	</sql:query>
	<h3> person 출력 </h3>
	<table>
		<thead>
			<tr>
				<c:forEach var="colname" items="${rs.columnNames}">
					<th><c:out value="${colname}" /></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
							<!-- 레코드 출력 -->
			<c:forEach var="rows" items="${rs.rowsByIndex}">
				<tr>
							 <!-- 필드 출력  -->
					<c:forEach var ="cols" items="${rows}" varStatus="i">
						<td>
							<c:if test="${cols != null}">
								<c:out value="${cols}" />
							</c:if>
							
							<c:if test="${cols == null }">
								<c:out value=""/>
							</c:if>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>