<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp" %>
<style>
  
.title{ 
    width:300px;
    height:100px;
    margin:0 auto;
}
.point{
	width:1000px; 
	height:140px; 
	text-align:left; 
	padding:7px; 
	font-size:14pt; 
	border:1px solid black;
}
.pointText{
	text-align:right; 
	float:right;
	font-size:14pt; 
}

#myshopMain {
    margin: 10px 120px 0 0;
    height: 149px;
    width: 175%;
    clear: both;
}
#myshopMain .shopMain {
    text-align: center;
    font-size: 11px !important;
    font-weight: normal !important;
    float: left;
    width: 14.284%;
    border-bottom: 1px solid black;
    border:1px solid #e8e8e8;
}


.xans-myshop-asyncbankbook .title {
    float: left;
    width: 40%;
    font-size: 17px;
    padding: 0 0 0 10px;
    font-weight: 300;
    box-sizing: border-box;
    text-align:left;
    
}

.xans-myshop-asyncbankbook ul li {
    float: left;
    margin: 20px 0;
    padding: 0 45px;
    font-weight: 400;
    width: 50%;
    height: 20px;
    font-size: 16px;
    line-height: 1.6;
    vertical-align: top;
    box-sizing: border-box;
    text-align:right;
    
}
.ec-base-box {
    padding: 20px;
    margin-left: auto;
    margin-right: auto;
    border: 1px solid #e8e8e8;
    color: #404040;
    height: 180px;
    
}

.ScrollButton {
  position: fixed;   /* 버튼의 위치 고정 */
  right: 10px;       /* x 위치 입력 */
  cursor: pointer;   /* 호버링 했을 때 커서 모양 변경 */
  z-index: 10;       /* 다른 태그에 가려지지 않게 우선순위 변경 */
}
/* 두 태그에 각각 y 위치 입력 */
#TopButton {
  bottom: 108px;        
}
#BottomButton {
  bottom: 75px;
}

</style>

<script>
$(document).ready(function() {
	var totalPoints = 0;
	var usePoints = 0;
	
	$(".getPoints").each(function() {
		$(this).css("display", "none");
	});
	
	$("input[name=getPoints]").each(function() {
		var point = $(this).val();
		totalPoints += Number(point);
		$(".totalPoints").text(totalPoints + " 원");
	});
	
	$("[id^='xans_myshop_bankbook']").each(function() {
		$(this).text(numberFormat($(this).text()));
	});
});

function numberFormat(inputNumber) {
   return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
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
    	<div class="row">
			<div class="col-lg-12">
				<div class="title" style="text-align:center;"><h1>MY PAGE</h1></div>
<!-- 				<div class="point"> -->
<!-- 					<ul> -->
<!-- 				        <li class=""> -->
<!-- 				            <strong class="title">총포인트</strong> -->
<%-- 				            <strong class="data"><span id="totalPoints" class="pointText" id="totalPoint">${u_point}원</span></strong> --%>
<!-- 				        </li> -->
<!-- 				        <li class=""> -->
<!-- 				            <strong class="title">사용포인트</strong> -->
<!-- 				            <strong class="data"><span id="usePoints" class="pointText" id="usePoints">0원</span></strong> -->
<!-- 				        </li> -->
<!-- 						<li class=" "> -->
<!-- 				            <strong class="title">가용포인트</strong> -->
<%-- 				            <strong class="data">&nbsp;<span class="pointText" id="nowPoint">${u_point}원</span></strong> --%>
<!-- 				        </li> -->
<!-- 				        <li> -->
<!-- 				            <strong class="title">총 주문상품</strong> -->
<!-- 				            <strong class="data"><span class="pointText" id="usedPoint">₩0</span>(<span id="totalOrderCount">0</span>개)</strong> -->
<!-- 				        </li> -->
<!-- 				    </ul> -->
<!-- 				</div> -->
				
				
				<div class="xans-element- xans-myshop xans-myshop-asyncbankbook ec-base-box gHalf">
					<ul>
						<li class=" ">
							<strong class="title">가용적립금</strong>
							<strong class="data use">&nbsp;<span id="xans_myshop_bankbook_avail_mileage" class="nowPoint">${u_point} 원</span></strong>
						</li>
						<li class="">
							<strong class="title">총적립금</strong>
							<strong class="data"><span id="xans_myshop_bankbook_total_mileage" class="totalPoint">${totalPoint} 원</span></strong>
						</li>
						<li class="">
							<strong class="title">사용적립금</strong>
							<strong class="data"><span id="xans_myshop_bankbook_used_mileage" name="usePoints">${usePoint} 원</span></strong>
						</li>
						<li>
							<strong class="title">총주문</strong>
							<strong class="data"><span id="xans_myshop_bankbook_order_price" class="usedPoint">${usePoint} 원</span>(<span id="xans_myshop_bankbook_order_count">${oCount}</span>개)</strong>
						</li>
					</ul>
				</div>
				
				
				
				
				
				
				<div id="myshopMain" class="xans-element- xans-myshop xans-myshop-main ">
					<div class="shopMain order">
						<li>
							<p><a href="/cjh/myOrder?p_status=1"><img src="../../resources/images/order.png"></a></p>
							<h3><a href="/cjh/myOrder?p_status=1">ORDER</a></h3>
							<p><a href="/cjh/myOrder?p_status=1">주문내역 조회</a></p>
						</li>
					</div>
					<div class="shopMain profile">
						<li>
							<p><a href="/cjh/pwCheck"><img src="../../resources/images/mypage.png"></a></p>
							<h3><a href="/cjh/pwCheck">PROFILE</a></h3>
							<p><a href="/cjh/pwCheck">회원정보</a></p>
						</li>
					</div>
					<div class="shopMain wishlist">
						<li>
							<p><a href="/cjh/cart"><img src="../../resources/images/cart.png"></a></p>
							<h3><a href="/cjh/cart">CART</a></h3>
							<p><a href="/cjh/cart">장바구니</a></p>
						</li>
					</div>
					<div class="shopMain mileage">
						<li>
							<p><a href="/cjh/myPoint?point_code=1"><img src="../../resources/images/mileage.png"></a></p>
							<h3><a href="/cjh/myPoint?point_code=1">MILEAGE</a></h3>
							<p><a href="/cjh/myPoint?point_code=1">적립금</a></p>
						</li>
					</div>
				</div>
				
				
				
				
				
				
<!-- 				<div> -->
<!-- 			        <li> -->
<!-- 			        <h3><a href="/cjh/myOrder?p_status=1">주문내역</a></h3> -->
<!-- 			        </li> -->
<!-- 			    </div> -->
			    
<!-- 				<div> -->
<!-- 			        <li> -->
<!-- 			        <h3><a href="/cjh/pwCheck">내정보 수정</a></h3> -->
<!-- 			        </li> -->
<!-- 			    </div> -->
			    
<!-- 				<div> -->
<!-- 			        <li> -->
<!-- 			        <h3><a href="/cjh/cart">장바구니</a></h3> -->
<!-- 			        </li> -->
<!-- 			    </div> -->
			    
<!-- 				<div> -->
<!-- 			        <li> -->
<!-- 			        <h3><a href="/cjh/myPoint?point_code=1">적립금</a></h3> -->
<!-- 			        </li> -->
<!-- 			    </div> -->
				
			</div>
    <!-- /.row -->

		</div>

	</div>
</div>


<%@ include file="../include/foot.jsp" %>