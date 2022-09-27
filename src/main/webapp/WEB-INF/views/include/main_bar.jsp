<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<form id="shop_form" action="/magager/manager_main" method="get">
	<input type="hidden" name="main_code" value="${Kys_MainVo.main_code}"/>
	<input type="hidden" name="main_name" value="${Kys_MainVo.main_name}"/>
	<input type="hidden" name="serve_code" value="${Kys_ServeVo.servo_code }"/>
	<input type="hidden" name="serve_name" value="${Kys_ServeVo.serve_name }"/>
	<input type="hidden" name="serve_maincode" value="${Kys_ServeVo.main_code }"/>
</form>
<form id="frmPage" action="/manager/normal_list" method="get">
	<input type="hidden" name="p_main" value="${boardDto.p_main}">
	<input type="hidden" name="p_serve" value="${boardDto.p_serve}">
	<input type="hidden" name="page" value="${boardDto.page}"/>
	<input type="hidden" name="perPage" value="${boardDto.perPage}"/>
</form>
<form id="frmDeletePage" action="/manager/board_deleteList" method="get">
	<input type="hidden" name="p_main" value="${deleteListDto.p_main}">
	<input type="hidden" name="p_serve" value="${deleteListDto.p_serve}">
	<input type="hidden" name="page" value="${deleteListDto.page}"/>
	<input type="hidden" name="perPage" value="${deleteListDto.perPage}"/>
</form>
<form id="salesAllPage" action="/manager/salesAll" method="get">
		<input type="hidden" name="page" value="${salesDto.page}"/>
	<input type="hidden" name="perPage" value="${salesDto.perPage}"/>
</form>
	<div class="row">
		<div class="col-md-2">
			 
		</div>
		<div class="col-md-8">
			<div class="btn-group" role="group">

				<button class="btn btn-secondary" type="button"><a href="/manager/manager_main">관리자 홈</a></button>
				<button class="btn btn-secondary" type="button"><a href="/manager/salesAll">주문 리스트</a></button>
				<button class="btn btn-secondary" type="button"><a href="/manager/shop_single_input">상품 등록</a></button>
				<button class="btn btn-secondary" type="button"><a href="/manager/normal_list">상품리스트</a></button>
				<button class="btn btn-secondary" type="button"><a href="/jm/jm_userList">유저리스트</a></button>
				<button class="btn btn-secondary" type="button"><a href="/jm/jm_contact">Q&A</a></button>
				<button class="btn btn-secondary" type="button"><a href="/manager/board_deleteList">삭제된 상품</a></button>
			</div>
			<div class="row">
				<div class="col-md-12"></div>
			</div>

		</div>
		<div class="col-md-2"></div>
	</div>



