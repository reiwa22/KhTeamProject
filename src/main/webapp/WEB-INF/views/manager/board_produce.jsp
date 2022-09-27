<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<style>
#imgDrop{
	width : 80%;
	height : 100px;
	margin : auto 20px;
	border : 1px solid blue;
}
</style>
	<div class="row">
		<div class="col-md-12" >
			<h3>
				상품 등록 하기
			</h3>
		</div>
	</div>
<div class="row">
	<div class="col-md-2">
		<!-- select bar -->
		<!-- 선택해서 의류 등록 하기 -->
		<div>
			<label>상의 : </label> 
			<select>
				<option value="반팔">반팔
				<option value="긴팔">긴팔
			</select>
		</div>
		<div>
			<label>바지 : </label> 
			<select>
				<option>반바지
				<option>긴바지
			</select>
		</div>
		<div>
			<label>acc : </label> 
			<select>
				<option>가방
				<option>모자
			</select>
		</div>
	</div>
	<!-- div 2 -->
	<!-- 상품 이미지 -->
	<div class="col-md-4">
		<div class="carousel slide" id="carousel-661420">
			<ol class="carousel-indicators">
				<li data-slide-to="0" data-target="#carousel-661420" class="active">
				</li>
				<li data-slide-to="1" data-target="#carousel-661420"></li>
				<li data-slide-to="2" data-target="#carousel-661420"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" alt="Carousel Bootstrap First"
						src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg" />
					<div class="carousel-caption">
						<h4>First Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" alt="Carousel Bootstrap Second"
						src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" alt="Carousel Bootstrap Third"
						src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
					<div class="carousel-caption">
						<h4>Third Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carousel-661420"
				data-slide="prev"><span class="carousel-control-prev-icon"></span>
				<span class="sr-only">Previous</span></a> <a
				class="carousel-control-next" href="#carousel-661420"
				data-slide="next"><span class="carousel-control-next-icon"></span>
				<span class="sr-only">Next</span></a>
		</div>
	</div>

	<!-- 상품 내용 -->
	<div class="col-md-4">
		<table class="table">
			<tbody>
				<tr class="table-active">
					<td>상품명</td>
					<th><textarea rows="1" cols="30"></textarea></th>
					
				</tr>
				
				<tr class="table-active">
					<td>상품 코드</td>
					<td>상품코드 span</td>
					
				</tr>
				
				
			</tbody>
		</table>
		<div id="totalPrice" class="totalPrice">
                <strong>TOTAL</strong> : <span class="total"><strong><em>0</em></strong> (0개)</span>
            </div>
		<div class="ec-base-button">
			<a href="#none" class="first dj-btn-1 " onclick="" >구매하기</a> 
			<a href="#none" class="dj-btn-1-2 "     onclick="" >장바구니</a> 
			<a href="#none" class="dj-btn-1-2 wish" onclick="" >관심상품</a> <br>
		</div>
	</div>
	<!-- 상품 내용 끝  -->
	<div class="col-md-2"></div>
		
</div>
<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<textarea rows="" cols="" placeholder="상품 사진 등록" id="imgDrop"></textarea>
		</div>
		<div class="col-md-2">
		</div>
	</div>



<%@ include file="../include/foot.jsp" %>