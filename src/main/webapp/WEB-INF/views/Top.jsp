<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
  <tr>
  <c:choose>
    <c:when test="${idKey==null}">
     <th> <b><a href="/login">로그인</a></b></th>
     <th> <b><a href="/register">회원가입</a></b></th>
    </c:when>
     <c:otherwise>
     <th><b><a href="/logout">로그아웃</a></b></th>
     <th> <b><a href="/memberUpdate">회원수정</a></b></th>
     </c:otherwise>
  </c:choose>
    <th><b><a href="/productList">상품목록</a></b></th>
    <th><b><a href="/cartList">장바구니</a></b></th>
    <th><b><a href="/orderList">구매목록</a></b></th>
  </tr>
</table>
