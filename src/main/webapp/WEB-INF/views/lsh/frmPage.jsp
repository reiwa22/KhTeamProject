<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="singlePage" action="/lsh/shop" method="get">
	<input type="hidden" name="p_num" value="${lshBoardVo.p_num}"/>
</form>

<form id="mainPage" action="/lsh/shop" method="get">
	<input type="hidden" name="p_main" value="${p_main}"/>
	<input type="hidden" name="type" value="${lshBoardDto.type}"/>
	<input type="hidden" name="page" value="${lshBoardDto.page}"/>
</form> 

<form id="servePage" action="/lsh/shop" method="get">
	<input type="hidden" name="p_serve" value="${p_serve}"/> 
	<input type="hidden" name="type" value="${lshBoardDto.type}"/>
	<input type="hidden" name="page" value="${lshBoardDto.page}"/>
</form>

<form id="shop" action="/lsh/shop" method="get">
	<input type="hidden" name="type" value="${lshBoardDto.type}"/>
	<input type="hidden" name="page" value="${lshBoardDto.page}"/>
</form>

