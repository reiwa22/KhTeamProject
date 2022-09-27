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
		$("#frmDeletePage  > input[name=p_main]").val(main);
		$("#frmDeletePage > input[name=p_serve]").val(serve);
		$("#frmDeletePage").submit();
	});
	
	//n줄씩 보기
	$("select[name=perPage]").change(function(){
		console.log($(this).val());
		$("#frmDeletePage > input[name=perPage]").val($(this).val());
		$("#frmDeletePage").submit();
	});
	//패이지 번호
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#frmDeletePage > input[name=page]").val(page);
		$("#frmDeletePage").submit();
	});
	//페이지 액티브
	$("a.page-link").each(function(){
		var page = $(this).attr("href");
		if (page == "${boardDto.page}" ){
			$(this).parent().addClass("active");
			return;
		}
	});
	//완전 삭제 버튼
	$("a[name=btnDelete]").click(function(){
		var that = $(this);
		
		var p_num = $(this).attr("data-p_num");
		console.log("p_num:"+p_num);
		var url = "/ajax/delete?p_num="+p_num;
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
	//복구 버튼
	$("a[name=btnRestoration]").click(function(){
		var that = $(this);
		
	var p_num = $(this).attr("data-p_num");
	console.log(p_num);
	var url = "/ajax/restoration?p_num="+p_num;
	$.ajax({
		"type" : "post",
		"url" : url,
		"dataType" : "text",
		"success" : function(rData) {
			console.log(rData);
			that.parent().parent().hide(1);
		}
	});
	});
});
</script>
<style>
#btnDelete {
	color : yellow;
}
</style>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">

		<div class="row">
			<div class="col-md-12">
				<div>
					<label>main : </label> <select name="p_main" id="mainOption">
						<option value="T">상의</option>
						<option value="P">하의</option>
						<option value="A">악세사리</option>
						<option value="S">신발</option>
					</select> <label>serve : </label> <select name="p_serve" id="serveOption">
						<option value="TH">반팔</option>
						<option value="TL">긴팔</option>
						<option value="TS">셔츠</option>
						<option value="TM">맨투맨</option>
						<option value="PJ">청바지</option>
						<option value="PM">면바지</option>
						<option value="PH">반바지</option>
						<option value="P7">7부바지</option>
						<option value="SD">구두</option>
						<option value="SU">운동화</option>
						<option value="SS">스릴퍼</option>
						<option value="SR">로퍼</option>
						<option value="AR">반지</option>
						<option value="AW">지갑</option>
						<option value="AC">모자</option>
						<option value="AB">가방</option>
					</select>
					<button type="button" id="btnSearch">검색</button>
					<!-- n줄 씩보기 -->
					<select name="perPage" class="form-inline">
						<c:forEach begin="5" end="50" step="5" var="i">
							<option value="${i}"
								<c:if test="${i == pagingDto.perPage}"> selected</c:if>>${i}줄씩
								보기</option>
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
					<c:forEach items="${list}" var="BoardVo">
						<tr>
							<td>${BoardVo.p_main}${BoardVo.p_serve}${BoardVo.p_num}</td>
							<td>${BoardVo.p_name}</td>
							<td>${BoardVo.p_price}</td>
							<td>
							<a type="button" class="btn btn-sm btn-success"
								id="btnDelete" name="btnRestoration" data-p_num="${BoardVo.p_num}">복구</a></td>
							<td><a type="button" class="btn btn-sm btn-danger"
								id="btnDelete" name="btnDelete" data-p_num="${BoardVo.p_num}">완전 삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="col-md-2"></div>
</div>
<!-- 패이징 -->
<div class="row">
	<div class="col-md-12">
		<div class="row justify-content-center">
			<nav class="pagination-sm">
				<ul class="pagination">
					<!-- 이전 -->
					<c:if test="${deleteListDto.startPage != 1}">
						<li class="page-item"><a class="page-link"
							href="${deleteListDto.startPage -1}">Previous</a></li>
					</c:if>
					
					<!-- 페이지 번호 -->
					<c:forEach begin="${deleteListDto.startPage}" end="${deleteListDto.endPage}"
						var="v">
						<li class="page-item"><a class="page-link" href="${v}">${v}</a>
						</li>
					</c:forEach>
					
					<!-- 다음 -->
					<c:if test="${deleteListDto.endPage < deleteListDto.totalPage}">
						<li class="page-item"><a class="page-link"
							href="${deleteListDto.endPage +1}">Next</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>





<%@ include file="../include/foot.jsp" %>