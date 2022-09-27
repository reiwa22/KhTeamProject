<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<%@ include file="../include/main_bar.jsp" %>

<script type="text/javascript">
$(function() {
	var options = $("#serveOption option");
	var m = $("#mainOption option:selected").val();
	if(m == "T") {   
		$("#serveOption option").remove();
		$("#serveOption").append(options[0]).append(options[1]).append(options[2]).append(options[3]);
	}
	$("#mainOption").change(function(){
		$("#serveOption option").remove();
		var main =  $(this).val();
		var serve = $("#serveOption").val();
		if(main == "T")                                                     
			$("#serveOption").append(options[0]).append(options[1]).append(options[2]).append(options[3]);
		if(main == "P")                                                       
			$("#serveOption").append(options[4]).append(options[5]).append(options[6]).append(options[7]);
		if(main == "S")                                                       
			$("#serveOption").append(options[8]).append(options[9]).append(options[10]).append(options[11]);
		if(main == "A")                                                       
			$("#serveOption").append(options[12]).append(options[13]).append(options[14]).append(options[15]);
	});
	//검색
	$("#btnSearch").click(function(){
		var main = $("select[name=p_main]").val();
		var serve = $("select[name=p_serve]").val();
		console.log("main:"+main);
		console.log("serve:"+serve);
		$("#frmPage  > input[name=p_main]").val(main);
		$("#frmPage > input[name=p_serve]").val(serve);
		$("#frmPage").submit();
	});
	
	//n줄씩 보기
	$("select[name=perPage]").change(function(){
		console.log($(this).val());
		$("#frmPage > input[name=perPage]").val($(this).val());
		$("#frmPage").submit();
	});
	//패이지 번호
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#frmPage > input[name=page]").val(page);
		$("#frmPage").submit();
	});
	//페이지 액티브
	$("a.page-link").each(function(){
		var page = $(this).attr("href");
		if (page == "${boardDto.page}" ){
			$(this).parent().addClass("active");
			return;
		}
	});
	//삭제 버튼
	$("a[name=btnDelete]").click(function(){
		var that = $(this);
		
		var p_num = $(this).attr("data-p_num");
		console.log("p_num:"+p_num);
		var url = "/ajax/productDelete?p_num="+p_num;
		$.ajax({
			"type" : "POST",
			"url" : url,
			"dataType" : "text",
			"success" : function(rData){
				console.log(rData);
				that.parent().parent().hide(1);
			}
		});
	});
});
</script>
<style>
#btnDelete{
	color : yellow;
}
</style>
${boardDto}
<div id="div"></div>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">

		<div class="row">
			<div class="col-md-12">
				<div>
					<label>main : </label> 
					<select name="p_main" id="orderData">
						<option>주문접수</option>
						<option>출고중</option>
						
					
						
					</select>
					<button type="button" id="btnSearch">검색</button>
					<!-- n줄 씩보기 -->
					<select name="perPage" class="form-inline">
						<c:forEach begin="5" end="50" step="5" var="i">
						<option value="${i}" 
							<c:if test="${i == pagingDto.perPage}"> selected</c:if>
							>${i}줄씩 보기</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<!-- 테이블 -->
			<table class="table">
				<thead>
					<tr>
						<th>상품 코드</th>
						<th>상품 이름</th>
						<th>가격</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageList}" var="BoardVo">
						
						<tr>
							<td>${BoardVo.p_main}${BoardVo.p_serve}${BoardVo.p_num}</td>
							<td>${BoardVo.p_name}</td>
							<td>${BoardVo.p_price}</td>
							<td><a type="button" class="btn btn-sm btn-warning"
								href="/manager/oenSelect?p_num=${BoardVo.p_num}">수정</a></td>
							<td><a type="button" class="btn btn-sm btn-danger"
								 id="btnDelete" name="btnDelete" data-p_num="${BoardVo.p_num}">삭제</a></td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="col-md-2"></div>
</div>
<!-- 패이징 -->
<div class="row justify-content-center">
		<div class="col-md-12 ">
		<div class="row justify-content-center">
		<nav class="pagination-sm">
			<ul class="pagination">
				<!-- 이전 -->
				<c:if test="${boardDto.startPage != 1}">
					<li class="page-item">
					<a class="page-link" href="${boardDto.startPage -1}">Previous</a>
					</li>
				</c:if>
				<!-- 페이지 번호 -->
				<c:forEach begin="${boardDto.startPage}" end="${boardDto.endPage}" var="v">
					<li class="page-item">
					<a class="page-link" href="${v}">${v}</a>
					</li>
				</c:forEach>
				<!-- 다음 -->
				<c:if test="${boardDto.endPage < boardDto.totalPage}">
					<li class="page-item">
						<a class="page-link" href="${boardDto.endPage +1}">Next</a>
					</li>
				</c:if>
				
			</ul>
		</nav>
		</div>
		</div>
	</div>





<%@ include file="../include/foot.jsp" %>