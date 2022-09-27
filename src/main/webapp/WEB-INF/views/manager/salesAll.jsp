<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../include/head.jsp" %>
    <%@ include file="../include/main_bar.jsp" %>
    <script>
$(function(){
	$("#delivery").show();
	$("#selectBar").change(function(){
		var v = $(this).val();
		console.log(v);
		if(v== 1){
			$("#delDiv").show();
		} else {
			$("#delDiv").hide();
		} 
		if(v==2){
			$("#iteam").show();
		} else {
			$("#iteam").hide();
		}
			
		if(v==3){
			
		}
		
	});
	$("select[name=p_status]").change(function(){
		var p_status = $(this).val();
		var u_id = $(this).parent().children().eq(0).val();
		var p_num = $(this).parent().children().eq(1).val();
		$("input[name=p_num]").val();
	
		var sendData = {"p_status":p_status ,
						"u_id" : u_id,
						"p_num" : p_num};
		var url = "/ajax/updateStatus";
		$.ajax({
			"type" : "post",
			"data" : sendData,
			"url"  : url,
			"success" : function(rData){
// 				console.log(rData);
				alert("변경 되었습니다.");
			}
		});
	});
	$("select[name=perPage]").change(function(){
		console.log($(this).val());
		$("#salesAllPage > input[name=perPage]").val($(this).val());
		$("#salesAllPage").submit();
	});
	//패이지 번호
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#salesAllPage > input[name=page]").val(page);
		$("#salesAllPage").submit();
	});
	//페이지 액티브
	$("a.page-link").each(function(){
		var page = $(this).attr("href");
		if (page == "${boardDto.page}" ){
			$(this).parent().addClass("active");
			return;
		}
	});
	
});
</script>

<div class="col-md-12">
			
				
				
				
			</div>
    	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
				<div id="delDiv" >
<!-- 				<label>배송 조회:</label> -->
<!-- 					<select id="p_price" name="p_price"> -->
<!-- 						<option>주문 접수 -->
<!-- 						<option>출고 -->
<!-- 						<option>배송중 -->
<!-- 						<option>배송완료 -->
<!-- 					</select> -->
<!-- 					<button type="button" id="btnSearch">검색</button> -->
					<!-- n줄 씩보기 -->
					<select name="perPage" >
						<c:forEach begin="5" end="50" step="5" var="i">
						<option value="${i}" 
							<c:if test="${i == salesDto.perPage}"> selected</c:if>
							>${i}줄씩 보기</option>
						</c:forEach>
					</select> <input type="button" value="주문 목록 다운로드"
						onclick="javascript:ExcelDownload();" />
					<script type="text/javascript">
						function ExcelDownload() {
							console.log("클릭됨");
							location.href = "/upload/toExcel";
						}
					</script>
				</div>
					<table class="table">
						<thead>
							<tr>
								<th>주문 번호</th>
								<th>상품 코드</th>
								<th>주문 날자</th>
								<th>주문 금액</th>
								<th>주문 수량</th>
								<th>고객</th>
								
								<th>배송 현황</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="cartVo">
							<tr>
								<td>${cartVo.c_num}</td>
								<td>${cartVo.p_main}${cartVo.p_serve}${cartVo.p_num }<b>${cartVo.p_name}</b></td>
								<td>${cartVo.p_date}</td>
								<td>${cartVo.p_price }원</td>
								<td>size - ${cartVo.p_size} -  ${cartVo.p_count }개</td>
								<td>${cartVo.u_id }</td>
								
								<td>
									<input type="hidden" name="u_id" value="${cartVo.u_id}">
									<input type="hidden" name="p_num" value="${cartVo.p_num}">
								 <select id="p_status" name="p_status">
								 	<option value="1002" <c:if test="${cartVo.p_status ==1002}">selected</c:if>>배송 준비중
								 	<option value="1003" <c:if test="${cartVo.p_status ==1003}">selected</c:if>>출고
								 	<option value="1004" <c:if test="${cartVo.p_status ==1004}">selected</c:if>>배송중
								 	<option value="1005" <c:if test="${cartVo.p_status ==1005}">selected</c:if>>배송완료
								 
								 </select>
								</td>
							
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
	<!-- 패이징 -->
<div class="row justify-content-center">
	<div class="col-md-12 ">
		<div class="row justify-content-center">
			<nav class="pagination-sm">
				<ul class="pagination">
					<!-- 이전 -->
					<c:if test="${salesDto.startPage != 1}">
						<li class="page-item"><a class="page-link"
							href="${salesDto.startPage -1}">Previous</a></li>
					</c:if>
					<!-- 페이지 번호 -->
					<c:forEach begin="${salesDto.startPage}" end="${salesDto.endPage}"
						var="v">
						<li class="page-item"><a class="page-link" href="${v}">${v}</a>
						</li>
					</c:forEach>
					<!-- 다음 -->
					<c:if test="${salesDto.endPage < salesDto.totalPage}">
						<li class="page-item"><a class="page-link"
							href="${salesDto.endPage +1}">Next</a></li>
					</c:if>

				</ul>
			</nav>
		</div>
	</div>
</div>


<%@ include file="../include/foot.jsp" %>
