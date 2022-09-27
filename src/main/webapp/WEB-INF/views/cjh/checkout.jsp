<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp" %>

<script>
$(document).ready(function() {
	var totalPrice = 0;
	$("td[name=p_price]").each(function() {
		var p_price = $(this).children().text();
		totalPrice += Number(p_price);
	});
	$("td[name=totalPrice]").children().text(totalPrice);
	
	$("#btnOrder").click(function(e) {
		e.preventDefault();
		var userPoint = $("td[name=userPoint]").children().text();
		if (userPoint < totalPrice) {
			alert("포인트가 부족합니다");
		} else {
			location.href = "/cjh/order?u_id=${u_id}&totalPrice="+totalPrice;
		}
	});
});
</script>

<div class="bg-light py-3">
	<div class="container">
		<div class="row">
			<div class="col-md-12 mb-0"><a href="/cjh/index">Home</a> <span class="mx-2 mb-0">/</span> <a href="/cjh/cart">Cart</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Checkout</strong></div>
		</div>
	</div>
</div>

<div class="site-section">
	<div class="container">
		<div class="row mb-5">
			<div class="col-md-12">
				<div class="border p-4 rounded" role="alert">
					Returning customer? <a href="#">Click here</a> to login
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 mb-5 mb-md-0">
				<h2 class="h3 mb-3 text-black">Billing Details</h2>
				<div class="p-3 p-lg-5 border">
<!-- 					<div class="form-group"> -->
<!-- 						<label for="c_country" class="text-black">Country <span class="text-danger">*</span></label> -->
<!-- 						<select id="c_country" class="form-control"> -->
<!-- 							<option value="1">Select a country</option>     -->
<!-- 							<option value="2">bangladesh</option>     -->
<!-- 							<option value="3">Algeria</option>     -->
<!-- 							<option value="4">Afghanistan</option>     -->
<!-- 							<option value="5">Ghana</option>     -->
<!-- 							<option value="6">Albania</option>     -->
<!-- 							<option value="7">Bahrain</option>     -->
<!-- 							<option value="8">Colombia</option>     -->
<!-- 							<option value="9">Dominican Republic</option>     -->
<!-- 						</select> -->
<!-- 					</div> -->
					<div class="form-group row">
						<div class="col-md-12">
							<label for="c_fname" class="text-black">이름 <span class="text-danger">*</span></label>
							<input type="text" class="form-control" id="c_fname" name="c_fname" value="${userVo.u_name}">
						</div>
<!-- 						<div class="col-md-6"> -->
<!-- 							<label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label> -->
<!-- 							<input type="text" class="form-control" id="c_lname" name="c_lname"> -->
<!-- 						</div> -->
					</div>

<!-- 					<div class="form-group row"> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<label for="c_companyname" class="text-black">Company Name </label> -->
<!-- 							<input type="text" class="form-control" id="c_companyname" name="c_companyname"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="form-group row">
						<div class="col-md-12">
							<label for="c_address" class="text-black">주소 <span class="text-danger">*</span></label>
							<input type="text" class="form-control" id="c_address" name="c_address" value="${userVo.u_address}">
						</div>
					</div>
              
					<div class="form-group row">
						<div class="col-md-12">
							<label for="c_email" class="text-black">이메일 <span class="text-danger">*</span></label>
							<input type="text" class="form-control" id="c_email" name="c_email" value="${userVo.u_email}">
						</div>
					</div>
              
					<div class="form-group row">
						<div class="col-md-12">
							<label for="c_phone" class="text-black">전화번호 <span class="text-danger">*</span></label>
							<input type="text" class="form-control" id="c_phone" name="c_phone" value="${userVo.u_phone}">
						</div>
					</div>

<!-- 					<div class="form-group"> -->
<!-- 						<input type="text" class="form-control" placeholder="Apartment, suite, unit etc. (optional)"> -->
<!-- 					</div> -->

<!-- 					<div class="form-group row"> -->
<!-- 						<div class="col-md-6"> -->
<!-- 							<label for="c_state_country" class="text-black">State / Country <span class="text-danger">*</span></label> -->
<!-- 							<input type="text" class="form-control" id="c_state_country" name="c_state_country"> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-6"> -->
<!-- 							<label for="c_postal_zip" class="text-black">Posta / Zip <span class="text-danger">*</span></label> -->
<!-- 							<input type="text" class="form-control" id="c_postal_zip" name="c_postal_zip"> -->
<!-- 						</div> -->
<!-- 					</div> -->

<!-- 					<div class="form-group row mb-5"> -->
<!-- 						<div class="col-md-6"> -->
<!-- 							<label for="c_email_address" class="text-black">Email Address <span class="text-danger">*</span></label> -->
<!-- 							<input type="text" class="form-control" id="c_email_address" name="c_email_address"> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-6"> -->
<!-- 							<label for="c_phone" class="text-black">Phone <span class="text-danger">*</span></label> -->
<!-- 							<input type="text" class="form-control" id="c_phone" name="c_phone" placeholder="Phone Number"> -->
<!-- 						</div> -->
<!-- 					</div> -->

<!-- 					<div class="form-group"> -->
<!-- 						<label for="c_create_account" class="text-black" data-toggle="collapse" href="#create_an_account" role="button" aria-expanded="false" aria-controls="create_an_account"><input type="checkbox" value="1" id="c_create_account"> Create an account?</label> -->
<!-- 						<div class="collapse" id="create_an_account"> -->
<!-- 							<div class="py-2"> -->
<!-- 								<p class="mb-3">Create an account by entering the information below. If you are a returning customer please login at the top of the page.</p> -->
<!-- 								<div class="form-group"> -->
<!-- 									<label for="c_account_password" class="text-black">Account Password</label> -->
<!-- 									<input type="email" class="form-control" id="c_account_password" name="c_account_password" placeholder=""> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="form-group">
					해외배송 준비중입니다.
					</div>
			  
					<div class="form-group">
<!-- 						<label for="c_ship_different_address" class="text-black" data-toggle="collapse" href="#ship_different_address" role="button" aria-expanded="false" aria-controls="ship_different_address"><input type="checkbox" value="1" id="c_ship_different_address"> Ship To A Different Address?</label> -->
						<div class="collapse" id="ship_different_address">
 							<div class="py-2">

								<div class="form-group">
									<label for="c_diff_country" class="text-black">Country <span class="text-danger">*</span></label>
									<select id="c_diff_country" class="form-control">
										<option value="1">Select a country</option>    
										<option value="2">bangladesh</option>    
										<option value="3">Algeria</option>    
										<option value="4">Afghanistan</option>    
										<option value="5">Ghana</option>    
										<option value="6">Albania</option>    
										<option value="7">Bahrain</option>    
										<option value="8">Colombia</option>    
										<option value="9">Dominican Republic</option>    
									</select>
								</div>
								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_diff_fname" class="text-black">First Name <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_fname" name="c_diff_fname">
									</div>
									<div class="col-md-6">
										<label for="c_diff_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_lname" name="c_diff_lname">
									</div>
								</div>
			
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_diff_companyname" class="text-black">Company Name </label>
										<input type="text" class="form-control" id="c_diff_companyname" name="c_diff_companyname">
									</div>
								</div>
			
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_diff_address" class="text-black">Address <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_address" name="c_diff_address" placeholder="Street address">
									</div>
								</div>
			
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Apartment, suite, unit etc. (optional)">
								</div>
			
								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_diff_state_country" class="text-black">State / Country <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_state_country" name="c_diff_state_country">
									</div>
									<div class="col-md-6">
										<label for="c_diff_postal_zip" class="text-black">Posta / Zip <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_postal_zip" name="c_diff_postal_zip">
									</div>
								</div>
			
								<div class="form-group row mb-5">
									<div class="col-md-6">
										<label for="c_diff_email_address" class="text-black">Email Address <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_email_address" name="c_diff_email_address">
									</div>
									<div class="col-md-6">
										<label for="c_diff_phone" class="text-black">Phone <span class="text-danger">*</span></label>
										<input type="text" class="form-control" id="c_diff_phone" name="c_diff_phone" placeholder="Phone Number">
									</div>
								</div>
		
							</div>
		
						</div>
					</div>
		
					<div class="form-group">
						<label for="c_order_notes" class="text-black">Order Notes</label>
						<textarea name="c_order_notes" id="c_order_notes" cols="30" rows="5" class="form-control" placeholder="Write your notes here..."></textarea>
					</div>
				</div>
			</div>
			<div class="col-md-6">

				<div class="row mb-5">
					<div class="col-md-12">
						<h2 class="h3 mb-3 text-black">Coupon Code</h2>
						<div class="p-3 p-lg-5 border">
                  
							<label for="c_code" class="text-black mb-3">보유한 쿠폰을 입력해주세요.</label>
							<div class="input-group w-75">
								<input type="text" class="form-control" id="c_code" placeholder="Coupon Code" aria-label="Coupon Code" aria-describedby="button-addon2">
								<div class="input-group-append">
									<button class="btn btn-primary btn-sm" type="button" id="button-addon2" disabled>Apply</button>
								</div>
							</div>
						</div>
					</div>
				</div>
            
				<div class="row mb-5">
					<div class="col-md-12">
						<h2 class="h3 mb-3 text-black">Your Order</h2>
						<div class="p-3 p-lg-5 border">
							<table class="table site-block-order-table mb-5">
								<thead>
									<th>Product</th>
									<th>Total</th>
								</thead>
								<tbody>
									<c:forEach var="item" items="${list}" varStatus="status">
										<tr>
											<td>
												${item.p_name} - ${item.p_size} <strong class="mx-2">x</strong> ${item.p_count}
											</td>
											<td name="p_price">
												<strong>${item.p_price * item.p_count}</strong> 원
											</td>
										</tr>
									</c:forEach>
										<tr>
											<td><strong class="mx-5">TOTAL PRICE</strong></td>
											<td name="totalPrice"><strong></strong> 원</td>
										</tr>
								</tbody>
							</table>
	
							<table class="table site-block-order-table mb-5">
								<tbody>
									<tr>
										<td>보유 포인트</td>
										<td name="userPoint">
											<strong>${userPoint}</strong> 원
										</td>
									</tr>
									<tr>
										<td>결제 금액</td>
										<td name="totalPrice">
											<strong></strong> 원
										</td>
									</tr>
								</tbody>
							</table>
	
							<div class="form-group">
								<button id="btnOrder" type="button" class="btn btn-primary btn-lg py-3 btn-block">Place Order</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<!-- </form> -->
	</div>
</div>


<%@ include file="../include/foot.jsp" %>