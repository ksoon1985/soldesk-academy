<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 
          uri="http://java.sun.com/jsp/jstl/functions"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글내용</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./resources/member/js/memberScript.js"></script>
<script src="./resources/member/js/jquery_board.js" 
          type="text/javascript"></script>
<link href="./resources/member/css/member.css" rel="stylesheet">
</head>
<body>
  <table>
    <thead class="class01 class-center">
      <tr>
         <th colspan=2 > <h3>회원정보</h3> 
         </th>
       </tr>
    </thead>
    <tbody class="class02 class-left">
        <tr>
            <th>아이디: </th>
            <td>${mdto.memid} </td>
        </tr>
        <tr>
            <th > 이름:</th>
            <td>${mdto.memname}</td>
        </tr>
        <tr>
            <th>연락처: </th>
            <td>${mdto.memtel}</td>
        </tr>
        <tr>
            <th>이메일: </th>
            <td>${mdto.mememail}</td>
        </tr>
        <tr>
            <th>생년월일: </th>
            <td>${mdto.membirth}</td>
        </tr>
        <tr>
            <th>성별: </th>
            <td> <c:if test="${fn:contains(mdto.memgender,'F')}">
  		          <c:out value="여성"/>
 		          </c:if>
 		          <c:if test="${fn:contains(mdto.memgender,'M')}">
  		          <c:out value="남성"/>
 		          </c:if></td>
        </tr>
          <tr>
            <td colspan="2" align="center">
                <input type="button" id="up_btn" value="정보수정" onclick="pwCheck('u');"/>
                <input type="button" id="del_btn"value="회원탈퇴" onclick="pwCheck('d');"/>
                <input type="button" value="회원목록 " id="list"/>
            </td>
        </tr>
    </tbody>
  </table>
    <form action ="" name="parentForm" method="post"> 
      <input type="hidden" name="cpass" value="">
      <input type="text" name="passwd" value="${mdto.passwd }">
      <input type="hidden" name="memid" value="${mdto.memid}">
    </form>    
</body>
</html>



