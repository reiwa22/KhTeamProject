<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
$(function() {
	var arrSize = [];
	function checkSize(size) {
		for (var v = 0; v < arrSize.length; v++) {
			if (size == arrSize[v]) {
				return true;
			}
		}
		arrSize.push(size);
		return false;
	}
	
	$("input[name=p_count]").change(function() {
		var p_count = $(this).val();
		$(this).val(p_count);
// 		console.log("p_count : "+ p_count);
	});
	
	$("#insertCart").click(function(e) {
		e.preventDefault();
		var u_id = "${sessionScope.u_id}";
		
		
// 		var u_id = $("#u_id").text();
		if (u_id == null || u_id == "") {
			if(confirm("로그인후 이용가능합니다. 로그인 하시겠습니까?")) {
				var p_num = $("#p_num").text();
				var p_serve = $("#p_serve").text();
			    var targetLocation = "/lsh/shop_single?p_num="+p_num+"&p_serve="+p_serve;
			    location.href = "/jm/jm_login?targetLocation=" + targetLocation;
// 				location.href="/lsh/shop_single?p_num="+p_num+"&p_serve="+p_serve;
			}
		} else {
			p_num = $("#p_num").text();
			console.log("p_num : " + p_num);
			var countArr = new Array();
			var sizeArr = new Array();
			$("h4[name=p_size]").each(function() {
				var size = $(this).text();
				sizeArr.push(size);
			});
			
			if(sizeArr.length == 0) {
				sizeArr.push(" ");
			}
			
			console.log("sizeArr : " + sizeArr);
			$("input[name=p_count]").each(function() {
				var count = $(this).val();
				countArr.push(count);
			});
			if ((countArr).length == 0) {
				alert("상품을 선택해주세요");
				return;
			}
			var sendData = {
				"p_num"			:	p_num,
			    "countArr"	:	countArr,
			    "sizeArr"		:	sizeArr
			};

//	 		var sendData = {
//	 				"p_num" : 1450,
//	 				"sizeArr" : ["S", "M"],
//	 				"countArr" : ["1", "2"]
//	 		};
			
			var strSendData = JSON.stringify(sendData);
			console.log("strSendData", strSendData);
			console.log('sendData', sendData);
			var url = "/cjh/insertCart";
			$.ajaxSettings.traditional = true;
//	 		$.ajax({
//	 		    type        : "POST",
//	 		    url         : url,
//	 		    contentType :'application/json; charset=UTF-8',
//	 		    data        : sendData,
//	 		    traditional : true,
//	 		    success : function (data){
//	 		    	location.href="/cjh/cart";
//	 		    }
//	 		});

			$.post(url, sendData, function(data) {
				var p_num = $("#p_num").text();
				var p_serve = $("#p_serve").text();
	 			location.href="/cjh/cart";
			});
		}
	});
	$("#size").change(function() {
// 		$("#insertCart").attr("disabled", false);
		var size = $("#size").val();
		var isChecked = checkSize(size);
		console.log(isChecked);
		if (isChecked == true) {
			return;
		}
		var html = "<div class='input-group mb-3' style='max-width: auto; border:3px solid black;'>";
		html += "<h4 id='name'>${lshBoardVo.p_name}[</h4><h4 name=p_size>"+size+"</h4><h4>]</h4>";
		html += "<h4>&nbsp&nbsp| 수량 :</h4>"
		html += "<input name='p_count' type='number' min='1' class='form-control text-center' value='1'>";
		html += "<a></a>"
		html += "<h4 class='sumPrice'>${lshBoardVo.p_price}</h4><h4>원</h4>"
		html += "<a href='#'class='delete'><h2>x</h2></a>"
		html += "</div>";
		
		$("#hidden").append(html);
		
		var totalPrice = 0;
		var count = $(this).val();
		var price = $(".h4").text();
		$(this).next().next().text(count*price);
		$(".sumPrice").each(function(index, element) {
			var tPrice = $(this).text();
			var nPrice = Number(tPrice);
			totalPrice += nPrice;
		});
		$("#total").text(totalPrice);
		
		$(this).find("option:first").prop("selected", true);
		
	});
	$("#hidden").on("click", ".delete", function(e) {
		e.preventDefault();
		var that = $(this);
		var sumPrice = $(this).prev().prev().text();
		var nPrice = Number(sumPrice);
		var total = $("#total").text();
		var totalPrice = Number(total);
		$("#total").text(totalPrice - nPrice);
		that.parent().remove();
		arrSize = [];
	});
	$("#hidden").on("change", "input[name=p_count]", function() {
		var totalPrice = 0;
		var count = $(this).val();
		var price = $(".h4").text();
		$(this).next().next().text(count*price);
		$(".sumPrice").each(function(index, element) {	
			var tPrice = $(this).text();
			var nPrice = Number(tPrice);
			totalPrice += nPrice;
		});
		$("#total").text(totalPrice);
	});
	
	$("a.title").click(function(e) {
		e.preventDefault();
		var p_num = $(this).attr("data-p_num");
		var p_serve = $(this).attr("data-p_serve")
		$("#singlePage > input[name=p_num]").val(p_num);
		$("#singlePage > input[name=p_serve]").val(p_serve);
		$("#singlePage").attr("action", $(this).attr("href"));
		$("#singlePage").submit();
	});
	
	function addComma(n) {
	    return n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}

	
});
</script>

<style>
	#image{
	width : 100%; 
	height : 600px;
	background-color : white;
	color : black;
	margin : auto;
	}
	
	#images{
	width : 100%; 
	height : auto;
	background-color : white;
	color : black;
	margin : auto;
	}
</style>
<%@ include file="frmPage.jsp" %>
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
	          <a href="/">Home</a> 
	          <span class="mx-2 mb-0">/</span> 
	          <a href="shop">Shop</a>  
	          <span class="mx-2 mb-0">/</span>
	          <strong class="text-black">${lshBoardVo.p_name}</strong>
          </div>
        </div>
      </div>
    </div> 
    
    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
				 <figure class="block-4-image">
				 	<img id="image" src="/upload/displayFile?fileName=${lshBoardVo.title_name}">
				 </figure>
          </div>
          <div class="col-md-6">
            <h2 class="text-black">${lshBoardVo.p_name}</h2>
            <h4>${lshBoardVo.p_content}</h4>
            <h5><strong class="text-primary h4">${lshBoardVo.p_price}</strong>원</h5>
            <div class="mb-1 d-flex">
	            <c:if test="${lshBoardVo.p_main == 'T' || lshBoardVo.p_main == 'P' || lshBoardVo.p_main == 'S'}">
	                <h4>Size:</h4>
		            <select id="size">
		            		<option selected disabled>-- 사이즈를 선택해주세요 --</option>
		            		<c:forEach items="${sizeList}" var="item">
		            			<c:choose>
		            				<c:when test="${item.p_count == null || item.p_count == 0}">
		            					<option value="${item.p_size}" disabled>${item.p_size}(품절)</option>
		            				</c:when>
		            				
		            				<c:otherwise>
		            					<option value="${item.p_size}">${item.p_size}(남은수량:${item.p_count})</option>
		            				</c:otherwise>
		            			</c:choose>
		            		</c:forEach>
		            </select>
	            </c:if>
	            
            </div>
            
            <div id="hidden">
            	<c:if test="${lshBoardVo.p_main == 'A'}">
            		
            		<c:forEach items="${sizeList}" var="Size">
            			<h4>Size : ${Size.p_size}</h4>
            			<h4 style="display:none" name='p_size'>${Size.p_size}</h4>
            		</c:forEach>
            		
	            	<div class='input-group mb-3' style='max-width: auto; border:3px solid black;'>
		            	<h5 id="name">${lshBoardVo.p_name}</h5>
		            	<h5>&nbsp&nbsp| 수량 :</h5>
		            	<input name='p_count' type='number' min='1' class='form-control text-center' value='1'>
		            	<a></a>
		            	<h5 class='sumPrice'>
		            		${lshBoardVo.p_price}
		            	</h5>
		            	<h5>원</h5>
		            </div>
	            </c:if>
            </div>
            <h2>가격 :<span id="total" style="color: black">
            	<c:choose>
            		<c:when test="${lshBoardVo.p_main == 'A'}">${lshBoardVo.p_price}</c:when>
            		<c:otherwise>0</c:otherwise>
            	</c:choose>
            </span>원</h2>
            
            <div id="p_num" style="display:none">${lshBoardVo.p_num}</div>
            <div id="p_serve" style="display:none">${lshBoardVo.p_serve}</div>
            
            <p><button id="insertCart" class="buy-now btn btn-sm btn-primary">장바구니에 담기</button></p>
			
          </div>
          
          
			
			
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="tabbable" id="tabs-402995">
							<ul class="nav nav-tabs" style="left: 50%; margin-left: 420px;">
								<li class="nav-item">
									<a class="nav-link active show" href="#tab1" data-toggle="tab">상품 정보</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#tab2" data-toggle="tab">관련 상품</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#tab3" data-toggle="tab">구매 정보</a>
								</li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="tab1" style="text-align: center;">
									<c:forEach items="${imgList}" var="lshBoardVo">
										<img id="images" src="/upload/displayFile?fileName=${lshBoardVo.file_name}">
		 							</c:forEach>
								</div>
								
								<div class="tab-pane" id="tab2" style="text-align: center;">
									<div class="site-section block-3 site-blocks-2">
								      <div class="container">
								        <div class="row justify-content-center">
								          <div class="col-md-7 site-section-heading text-center pt-4">
								            <h2>관련 상품</h2>
								          </div>
								        </div>
								        <div class="row">
								          <div class="col-md-12">
								            <div class="nonloop-block-3 owl-carousel">
								            
								            <c:forEach items="${relationList}" var="lshBoardVo">
								              <div class="item">
								                <div class="block-4 text-center" >
								                  <a class="block-4 title" href="shop_single" data-p_num="${lshBoardVo.p_num}">
								                    <img src="/upload/displayFile?fileName=${lshBoardVo.title_name}">
								                  </a>
								                  <div class="block-4-text p-4">
								                    <h3><a href="shop_single" class="title" data-p_num="${lshBoardVo.p_num}">
								                    	${lshBoardVo.p_name}</a>
								                    </h3>
								                    <p class="mb-0">${lshBoardVo.p_content}</p>
								                    <p class="text-primary font-weight-bold">
								                    <fmt:formatNumber value="${lshBoardVo.p_price}" pattern="#,###"/>원
													</p>
								                  </div>
								                </div>
								              </div>
								             </c:forEach>
								              
								            </div>
								          </div>
								        </div>
								        
								      </div>
								    </div>
								</div>
								
								<div class="tab-pane" id="tab3">
									<div>
										<h3 style="color: black">상품 결제 정보</h3>
											<p>
												고액결제의 경우 안전을 위해 카드사에서 확인전화를 드릴 수도 있습니다. 확인과정에서 도난 카드의 사용이나 타인 명의의 주문등 정상적인 주문이 아니라고 판단될 경우 임의로 주문을 보류 또는 취소할 수 있습니다.  
												무통장 입금은 상품 구매 대금은 PC뱅킹, 인터넷뱅킹, 텔레뱅킹 혹은 가까운 은행에서 직접 입금하시면 됩니다.  
												주문시 입력한 입금자명과 실제입금자의 성명이 반드시 일치하여야 하며, 3일 이내로 입금을 하셔야 하며 입금되지 않은 주문은 자동취소 됩니다.
												무통장 입금확인의 경우 15분 단위로 전산처리되어 바로 입금확인처리가 안될 수 있습니다. (주문시 입금자명과 금액이 꼭 동일해야 정상전산처리됩니다.)
											</p>
										<hr/>
										<h3 style="color: black">배송정보</h3>
										<p>
											배송 방법 : 택배<br>
											배송 지역 : 전국지역<br>
											배송 비용 : ₩2,500<br>
											배송 기간 : 3일 ~ 7일<br>
											배송 안내 : - 산간벽지나 도서지방은 별도의 추가금액을 지불하셔야 하는 경우가 있습니다.
											고객님께서 주문하신 상품은 입금 확인후 배송해 드립니다. 다만, 상품종류에 따라서 상품의 배송이 다소 지연될 수 있습니다.<br>
											- 수량부족시 교환이 아닌 환불 처리될 수 있습니다
										</p>
										<hr/>
										<h3 style="color: black">교환 및 반품정보</h3>
										<h5 style="color: black">교환 및 반품 주소</h5>
										<p> - 울산광역시 남구 삼산로35번길 19</p>
										<h5 style="color: black">교환 및 반품이 가능한 경우</h5>
										<p>
											- 상품을 공급 받으신 날로부터 7일이내 포장을 개봉하였거나 포장이 훼손되어 상품가치가 상실된 경우에는 교환/반품이 불가능합니다.<br>
											- 공급받으신 상품 및 용역의 내용이 표시.광고 내용과 다르거나 다르게 이행된 경우에는 공급받은 날로부터 3월이내, 그사실을 알게 된 날로부터 30일이내
										</p>
										<h5 style="color: black">교환 및 반품이 불가능한 경우</h5>
										<p>
											- 고객님의 책임 있는 사유로 상품등이 멸실 또는 훼손된 경우. 단, 상품의 내용을 확인하기 위하여
											 포장 등을 훼손한 경우는 제외<br>
											- 포장을 개봉하였거나 포장이 훼손되어 상품가치가 상실된 경우<br>
											- 고객님의 사용 또는 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우<br>
											- 시간의 경과에 의하여 재판매가 곤란할 정도로 상품등의 가치가 현저히 감소한 경우<br>
											- 복제가 가능한 상품등의 포장을 훼손한 경우<br>
											※ 고객님의 마음이 바뀌어 교환, 반품을 하실 경우 상품반송 비용은 고객님께서 부담하셔야 합니다.<br>
											 (색상 교환, 사이즈 교환 등 포함)<br>
											※ 교환접수시 택배사로 기사님 배정을 해드립니다. 접수완료 후 영업일 기준 1-3일 이내에 기사님에게 연락이 갑니다. 빠른 교환을 원하시는 경우 따로 본사주소로 배송 부탁드립니다.<br>
											※  재고부족시 환불처리될 수 있습니다
										</p>
									</div>
									
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			
        </div>
      </div>
    </div>

<%@ include file="../include/foot.jsp" %>