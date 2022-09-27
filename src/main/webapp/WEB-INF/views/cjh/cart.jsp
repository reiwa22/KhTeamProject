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
	
	//	쪽지 전체 선택
	$("#allcheck").click(function() {
		if($("#allcheck").prop("checked")) {
			$("input[name=checkbox]").prop("checked", true);
		} else {
			$("input[name=checkbox]").prop("checked", false);
		}
	});
	
	//	주문전 가격 확인
	$("#updateCart").click(function() {
		var totalPrice = 0;
		$(".sumPrice").each(function(index, element) {
			var price = ($(this).text());
			var nPrice = Number(price);
			totalPrice += nPrice;
		});
// 		console.log("totalPrice : " + totalPrice);
		$("#totalPrice").text(totalPrice );
		$("#btnCheckOut").attr("disabled", false);
	});
	
	//	수량 변경
	$("input[name=p_count]").change(function() {
// 		console.log($(this).val());
		var p_num = $(this).parent().parent().prev().prev().val();
		var count = $(this).val();
		var c_num = $(this).parent().parent().next().next().next().text();
		console.log("c_num : " + c_num);
		location.href = "/cjh/updateCart?p_num="+p_num+"&p_count="+count+"&c_num="+c_num;
		var p_price = $(this).parent().parent().prev().text();
// 		var p_count = $(this).parent().parent().next().children().text();
// 		console.log("p_count : " + p_count);
// 		console.log("p_price : " + p_price);
		$(this).parent().parent().next().children().text(count * p_price);
	});
	
	//	결제하러가기
	$("#btnCheckOut").click(function(e) {
		e.preventDefault();
		location.href = "/cjh/checkout";
	});
	
	//	선택된 쪽지 삭제
	$("#btnDelete").click(function() {
		var sc_num = "";
		var c_num = "";
		var ischecked = $("input[name=checkbox]:checked").length;
		if (ischecked != 0) {
			$("input[name=checkbox]:checked").each(function() {
//	 			var sc_nums = $("td[name=c_num]").text();
				var sc_nums = $(this).parent().next().next().next().next().next().next().next().next().text();
				sc_num += sc_nums+",";
				console.log("sc_num : " + sc_num);
			});
			var u_id = $("#u_id").val();
			var c_num = sc_num.substring(0, sc_num.length - 1);
			console.log(c_num);
	 		location.href="/cjh/deleteCheckedCart?&c_num="+c_num;
		} else {
			alert("삭제할 항목을 체크해주세요");
		}
		
		



// //		맨끝에 있는 콤마(,) 빼내기
// 		var nums = memo_nums.substring(0, memo_nums.length - 1);
// 		console.log(nums);
// 		var url = "memo_delete_checked.board";
// 		var sendData = { "nums" : nums };
// 		$.get(url, sendData, function(receivedData) {
// 			console.log(receivedData);
// 			var rData = receivedData.trim();
// 			if (rData == "true") {
// 				//	체크된 박스들
// 				checkedList.each(function() {
// 					//	체크박스가있는 tr 태그
// 					$(this).parent().parent().hide(1000);
// 				});
// 			} else {
// 				alert("쪽지 삭제 실패");
// 			}
// 		});
	});
	
});
</script>


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
		<div class="row mb-5">
			<form id="frmCart" class="col-md-12" action="/cjh/updateCart" method="post">
				<div class="title" style="text-align:center;"><h1 class="tit">CART</h1></div>
				
				<div class="site-blocks-table">
					<table class="table table-bordered">
						<thead style="height: 10px">
							<tr bgcolor="#eeeeee"><th colspan="7" style="text-align: Left;">장바구니 목록</th></tr>
							<tr>
								<th style="width: 5%">
									<input type="checkbox" id="allcheck" name="allcheck"/>
								</th>
								<th style="width: 15%" class="product-thumbnail">이미지</th>
								<th style="width: 25%" class="product-name">상품내용</th>
								<th style="width: 20%" class="product-price">가격</th>
								<th style="width: 10%" class="product-quantity">수량</th>
								<th style="width: 15%" class="product-total">총가격</th>
								<th style="width: 15%" class="product-remove">삭제</th>
							</tr>
						</thead>
						
						<tbody>
							<c:if test="${not empty list}">
								<c:forEach var="item" items="${list}" varStatus="status">
									<tr class="calculation1_tbody_tr1" style="height: 90px; background-color: #fff;" >
										<td style="text-align: Left; text-align:center; border-right:none; width:10px">
											<input type="checkbox" id="checkbox" name="checkbox"/>
											<input type="hidden" class="buypd${status.index}" value="${item.p_num}">
											<input type="hidden" id="u_id" value="${u_id}">
										</td>
										
<%-- 										<td style="border-left: none; border-right: none;"><img style="width:15px;" src="/resources/images/${item.title_name}"></td> --%>
<!-- 										<td style="border-left: none; border-right: none;"><img style="width:150px;" src="/resources/images/cloth_1.jpg"></td> -->
										<td style="border-left: none; border-right: none;"><img src="/upload/displayFile?fileName=${item.title_name}"></td>
											
										<td style="text-align:Left; padding-left: 10px; border-left: none; font-weight: bold;">${item.p_name} - ${item.p_size}</td>
											<input type="hidden" id="p_num" value="${item.p_num}">
										<td><a name="p_price" style="padding-left: 10px;" class="p_price${status.index}">${item.p_price}</a></td>
										
										<td	style="width:150px">
											
											<div class="input-group mb-3" style="max-width: 120px;">
<!-- 												<div class="input-group-prepend"> -->
<!-- 													<button name="btnminus" class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button> -->
<!-- 												</div> -->
												<input name="p_count" type="number" min="1" max="100" class="form-control text-center" value="${item.p_count}">
<!-- 												<div class="input-group-append"> -->
<!-- 													<button name="btnplus" class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button> -->
<!-- 												</div> -->
											</div>
										</td>
										
										<td><a class="sumPrice" id="sumPrice${status.index}" name="sumPrice">${item.p_price * item.p_count}</a>원</td>
										
										<td><a href="/cjh/deleteCart?u_id=${u_id}&c_num=${item.c_num}" class="btn btn-basic btn-sm">X</a></td>
										<td name="c_num" style="display : none;">${item.c_num}</td>
									</tr>
								</c:forEach>
							</c:if>
							
							<c:if test="${empty list}">
								<tr id="not product" style="background-color: #fff;">
									<td colspan="10" style="font-size: 20pt; color: gray;"><span>장바구니에 등록된 상품이 없습니다.</span></td>
								</tr>
							</c:if>
							
							<tr bgcolor="#eeeeee">
								<th colspan="7" style="text-align: Right;">
									선택항목 삭제 <button id="btnDelete" type="button" class="btn btn-basic btn-sm">X</button>
								</th>
							</tr>
							
						</tbody>
						
					</table>
				</div>
			</form>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="row mb-5">
					<div class="col-md-6 mb-3 mb-md-0">
						<button type="button" onclick="location.href='/lsh/shop'" class="btn btn-outline-primary btn-sm btn-block">쇼핑 계속하기</button>
					</div>
					<div class="col-md-6">
						<c:if test="${not empty list}">
							<button id="updateCart" class="btn btn-primary btn-sm btn-block">장바구니 항목 결제하기</button>
						</c:if>
					</div>
				</div>
<!-- 				<div class="row"> -->
<!-- 					<div class="col-md-12"> -->
<!-- 						<label class="text-black h4" for="coupon">Coupon</label> -->
<!-- 						<p>Enter your coupon code if you have one.</p> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-8 mb-3 mb-md-0"> -->
<!-- 						<input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code"> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4"> -->
<!-- 						<button class="btn btn-primary btn-sm">Apply Coupon</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
			<div class="col-md-6 pl-5">
				<div class="row justify-content-end">
					<div class="col-md-7">
						<div class="row">
							<div class="col-md-12 text-right border-bottom mb-5">
								<h3 class="text-black h4 text-uppercase">Cart Totals</h3>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-6">
								<span class="text-black">결제 가격</span><br>
							</div>
							<div class="col-md-6 text-right">
								<span class="text-black"><strong id="totalPrice"></strong>  원</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button id="btnCheckOut" class="btn btn-primary btn-lg py-3 btn-block" disabled>결제하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	    </div>
	</div>
</div>

<%@ include file="../include/foot.jsp" %>