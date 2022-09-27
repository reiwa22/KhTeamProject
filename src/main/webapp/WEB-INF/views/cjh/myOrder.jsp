<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>

<style>
.title{ 
    width:300px;
    height:100px;
    margin:0 auto;
}
</style>

<script>
$(document).ready(function() {
	$("td[name=p_date]").each(function() {
		var p_date = $(this).text();
		var sp_date = p_date.substring(0, 16);
		console.log("sp_date : " + sp_date);
		$(this).text(sp_date);
	});
	
	$("#p_status").change(function() {
		var p_status = $(this).val();
		console.log("p_status : " + p_status);
		$("select option").each(function() {
			if ($(this).val() == p_status) {
				$(this).attr("selected");
			} else {
				$(this).removeAttr("selected");
				console.log($(this).val());
			}
		});
		location.href="/cjh/myOrder?p_status=" + p_status;
	});
	
	// 현재 페이지 액티브
	$("a.page").each(function() {
		var page = $(this).attr("href");
		if (page == "${pagingDto.page}") {
			$(this).parent().addClass("active");
			return;
		}
	});
	
	// 페이지 번호 클릭
	$("a.page").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href").trim();
		var p_status = $("#p_status").val();
		$("#myOrder > input[name=page]").val(page);
		$("#myOrder > input[name=point_code]").val(p_status);
		$("#myOrder").submit();
	});
	
	//	구매확정시키기
	$("button[name=btnConfirm]").click(function(e) {
		e.preventDefault();
		var c_num = $(this).parent().prev().prev().prev().prev().prev().prev().text().trim();
		if(confirm("구매확정후 취소가 불가능합니다 구매확정 하시겠습니까?")) {
			var p_status = $("#p_status").val();
			$("#confirm > input[name=c_num]").val(c_num);
			$("#confirm > input[name=p_status]").val(p_status);
			$("#confirm").submit();
		}
	});
});
</script>

<form id="confirm" action="/cjh/confirm" method="get">
	<input type="hidden" name="c_num" value=""/>
	<input type="hidden" name="p_status" value=""/>
</form>

<form id="myOrder" action="/cjh/myOrder" method="get">
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="p_status" value="${pagingDto.p_status}"/>
</form>

<div class="bg-light py-3">
	<div class="container">
		<div class="row">
			<div class="col-md-12 mb-0"><a href="/cjh/index">Home</a> <span class="mx-2 mb-0">/</span>
				<a href="/cjh/mypage">My Page</a>  <span class="mx-2 mb-0"></span>
			</div>
		</div>
	</div>
</div>

<div class="site-section">
	<div class="container">
		<div class="title" style="text-align:center;"><h1>ORDER</h1></div>
		<div class="row">
			<div class="col-md-12 mb-5">
				<div class="d-flex"> 
					<div class="dropdown mr-1 ml-md-auto">
					<select id="p_status" id="p_status">
						<option value=1 <c:if test="${p_status == 1}">selected</c:if>>주문목록</option>
						<option value=1002 <c:if test="${p_status == 1002}">selected</c:if>>주문접수</option>
						<option value=1003 <c:if test="${p_status == 1003}">selected</c:if>>출고</option>
						<option value=1004 <c:if test="${p_status == 1004}">selected</c:if>>배송중</option>
						<option value=1005 <c:if test="${p_status == 1005}">selected</c:if>>배송완료</option>
						<option value=1006 <c:if test="${p_status == 1006}">selected</c:if>>구매확정</option>
					</select>
					</div>
				</div>
			</div>
		</div>
		<div class="site-blocks-table">
		
			<table class="table table-bordered">
				<thead>
					<tr bgcolor="#eeeeee"><th colspan="7" style="text-align: Left;">주문목록</th></tr>
					<tr>
						<th>주문번호</th>
						<th colspan="2">상품정보</th>
						<th>수량</th>
						<th>주문금액</th>
						<th>주문날짜</th>
						<th>진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty list}">
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr class="calculation1_tbody_tr1" style="height: 90px; background-color: #fff;">
								<td style="text-align: Left; text-align:center; width:10%">
									${item.c_num}
								</td>
								
								<td style="border-right: none;"><img src="/upload/displayFile?fileName=${item.title_name}"></td>
								<td style="border-left: none;">${item.p_name} - ${item.p_size}</td>
								
								<td style="text-align:center; font-weight: bold;">
									${item.p_count}
								</td>
								<td>
									<a name="p_price" style="padding-left: 10px;">${item.p_price * item.p_count}</a>
								</td>
								
								<td name="p_date" style="text-align:center; padding-left: 10px; font-weight: bold;">${item.p_date}</td>
								
								<td	style="width:15%">
									${item.o_status}
									<c:if test="${item.o_status == '배송완료'}">
										<button type="button" name="btnConfirm" class="btn btn-default">구매확정</button>
									</c:if>
								</td>
								
							</tr>
						</c:forEach>
					</c:if>
					
					<c:if test="${empty list}">
						<tr id="not product" style="background-color: #fff;">
							<td colspan="10" style="font-size: 20pt; color: gray;"><span>주문내역이 없습니다.</span></td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="row" data-aos="fade-up">
	<div class="col-md-12 text-center">
		<div class="site-block-27">
			<ul>
				<c:if test="${pagingDto.startPage != 1}">
					<li>
						<a class="page" href="${pagingDto.startPage - 1}">&lt;</a>
					</li>
				</c:if>
				
				<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="v">
					<li>
						<a class="page" href="${v}">${v}</a>
					</li>
				</c:forEach>
				
				<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
					<li>
						<a class="page" href="${pagingDto.endPage + 1}">&gt;</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>


<%@ include file="../include/foot.jsp" %>