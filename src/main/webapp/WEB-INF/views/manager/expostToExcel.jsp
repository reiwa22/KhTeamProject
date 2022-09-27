<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String filename = request.getAttribute("filename").toString();
response.setHeader("Content-type","application/vnd.ms.xls");
response.setHeader("Content-Disposition","inline;filename=monitoring"+filename+".xls");
%>
</head>
<body>
<table>
	<tr>
		<th>주문 번호</th>
		<th>상품 코드</th>
		<th>주문 날자</th>
		<th>주문 금액</th>
		<th>주문 수량</th>
		<th>고객</th>
		<th>주소</th>
		<th>전화번호</th>
	</tr>
	<c:forEach items="${list}" var="cartVo">
	<tr>
		<td>${cartVo.c_num}</td>
		<td>${cartVo.p_main}${cartVo.p_serve}${cartVo.p_num }<b>${cartVo.p_name}</b></td>
		<td>${cartVo.p_date}</td>
		<td>${cartVo.p_price }원</td>
		<td>size - ${cartVo.p_size} -  ${cartVo.p_count }개</td>
		<td>${cartVo.u_id }</td>
		<td>${cartVo.u_address }</td>
		<td>${cartVo.u_phone }</td>
		
	</tr>
	</c:forEach>
</table>
</body>
</html>