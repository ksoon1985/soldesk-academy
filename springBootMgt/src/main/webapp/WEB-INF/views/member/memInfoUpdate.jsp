<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 
          uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<link href="./resources/member/css/member.css" rel="stylesheet">
<script type="text/javascript" src="./resources/member/js/memberScript.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./resources/member/js/jquery_member.js" type="text/javascript"></script>
<script type="text/javascript">
/* $(function(){
 $("input:radio[name=memgender][value=" + '<c:out value="${ mdto.memgender }"/>' + "]").attr("checked","checked");
} */
</script>
</head>
<body>

 <form action="updatePro.mg" method="post" name="updateForm" enctype="multipart/form-data">
  <table>
    <thead class="class01 class-center">
      <tr>
         <th colspan=2 > <h3>회원가입</h3> 
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
            <td><input type="text" size="80%"
                 placeholder="연락처를 입력하시오.(010-1234-5678)" 
                 name ="memtel" value ="${mdto.memtel}" title="연락처" class="chk"/></td>
        </tr>
        <tr>
            <th>이메일: </th>
            <td><input type="text" size="80%"
                 placeholder="메일주소를 입력하시오.(형식:abcd@abc.net)" 
                 name ="mememail" value ="${mdto.mememail}" title="이메일" class="chk"/></td>
        </tr>
        <tr>
            <th>생년월일: </th>
            <td><input type="text" size="80%"
                 placeholder="생년월일을 입력하시오.(형식:1970-11-11)" 
                 name ="membirth" value ="${mdto.membirth}" title="이메일" class="chk"/></td>
        </tr>
        <tr>
            <th>성별: </th>
            <td><input type="radio" name="memgender" value="M" <c:if test="${fn:contains(mdto.memgender,'M')}"> checked="checked"</c:if> /> 남성
                <input type="radio" name="memgender" value="F" <c:if test="${fn:contains(mdto.memgender,'F')}"> checked="checked"</c:if> /> 여성</td>
        </tr>
        <tr>
            <th>비밀번호: </th>
            <td><input type="password" 
                 placeholder="비밀번호를 입력하시오" 
                 name ="passwd"  value ="${mdto.passwd}" id="passwd" title="비밀번호" class="chk"/></td>
        </tr>
         <tr>
            <th>비밀번호확인: </th>
            <td><input type="password" 
                 placeholder="비밀번호를 확인하시오." 
                 name ="passwd2"  value ="${mdto.passwd}" id="passwd2" title="비밀번호확인" class="chk"/>
                  <font id="check" size="2" color="red"></font> 
                 </td>

        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit"  id="submit1">수정</button>
                <button type="button"  id="list">목록으로 </button>
            </td>
        </tr>
    </tbody>
  </table>
</form>
</body>
</html>