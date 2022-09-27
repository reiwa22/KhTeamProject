<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="../include/main_style.jsp" %>
<%@ include file="../include/head.jsp" %>
<script type="text/javascript" >
$(function() {
	
	$("#mainOption").val("${boardVo.p_main}").attr("selected","selected");
	$("#serveOption").val("${boardVo.p_serve}").attr("selected","selected");
	
	var options = $("#serveOption option");
	$("#mainOption").change(function(){
		$("#serveOption option").remove();
		var main = $(this).val();
		console.log("main : "+main);
		var serve = $("#serveOption").val();
		if(main == "T")      {                                               
			$("#serveOption").append(options[0]).append(options[1]).append(options[2]).append(options[3]);}
		if(main == "P")   {                                                    
			$("#serveOption").append(options[4]).append(options[5]).append(options[6]).append(options[7]); }
		if(main == "S")      {                                                 
			$("#serveOption").append(options[8]).append(options[9]).append(options[10]).append(options[11]); }
		if(main == "A")   {                                                    
			$("#serveOption").append(options[12]).append(options[13]).append(options[14]).append(options[15]); }
	});
	//이미지 삭제 버튼
	$(".imgDrop").on("click",".attach-del", function(e){
		e.preventDefault();
		var that = $(this);
		var filename = $(this).attr("href");
		var url = "/upload/updateDelete";
		var sendData = {"filename" : filename};
		$.ajax({
			"type" : "GET",
			"url" : url,
			"data" : sendData,
			"success" : function(rData){
				console.log(rData);
				that.parent().remove();
			}
		});
	});
	$("#titleImg").on("dragenter dragover", function(e){e.preventDefault(); });
	$("#titleImg").on("drop",function(e){
		e.preventDefault();
		$("#titleImgFile").remove();
		$(this).css("height", "auto");
		var file = e.originalEvent.dataTransfer.files[0];
		var formData = new FormData();
		formData.append("file",file);
		var url="/upload/imgFile";
		$.ajax({
			"processData" :false,
			"contentType" : false,
			"type" : "post",
			"url" : url,
			"data" : formData,
			"success" :function(rData) {
				
				var slashIndex = rData.lastIndexOf("/");
				var front =rData.substring(0, slashIndex +1);
				var rear = rData.substring(slashIndex +1);
				var thumbnailName = front + rear;
				var originalFilename = rData.substring(rData.indexOf("_")+1);
				var html ="<div data-filename='"+rData+"'>";
					html += "<img class='img-rounded' src='/upload/displayFile?fileName="+thumbnailName+"' /><br>";
					html += "<span>"+originalFilename+"</span>";
					html +="<a href='"+rData+"' class='attach-del'><span class='pull-rigth'>X</span></a>";
					html +="</div>";
					$("#titleImg").append(html);
			}
		});
	});
	// 광고 사진
	$("#imgFileDrop").on("dragenter dragover", function(e){e.preventDefault(); });
	$("#imgFileDrop").on("drop",function(e){
		e.preventDefault();
		$(this).css("height", "auto");
		var file = e.originalEvent.dataTransfer.files[0];
		var formData = new FormData();
		formData.append("file",file);
		var url= "/upload/imgFile";
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"type" : "post",
			"url" : url,
			"data" :formData,
			"success" : function(rData) {
			
				var slashIndex = rData.lastIndexOf("/");
				var front = rData.substring(0, slashIndex +1);
				var rear = rData.substring(slashIndex +1);
				var thumbnailName = front + rear;
				var originalFilename = rData.substring(rData.indexOf("_")+1);
				var html ="<div data-filename='"+rData+"'>";
					html += "<img class='img-rounded' src='/upload/displayFile?fileName="+thumbnailName+"' /><br>";
					html += "<span>"+originalFilename+"</span>";
					html +="<a href='"+rData+"' class='attach-del'><span class='pull-rigth'>X</span></a>";
					html +="</div>";
					$("#update").append(html);
			}
		});
	});
	$("#imgFileDrop").ready(function(e){
		$("#imgFileDrop").css("height", "auto");
	});
	$("#formSubmit").submit(function(){
		var upDiv = $("#update >div ");
		var titleDiv = $("#titleImg > div");
		upDiv.each(function(index){
			var filename = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='p_files["+index+"]' value='"+filename+"'/>";
			$("#formSubmit").prepend(hiddenInput);
		});
		titleDiv.each(function(index){
			var filename = $(this).attr("data-filename");
// 			CONSOLE.LOG("SUBMIT FILENAME:"+FILENAME);
// 			CONSOLE.LOG("FORMSUBMIT/FILENAME:"+FILENAME);
			var hiddenInput = "<input type='hidden' name='title_name' value='"+filename+"'/>";
			$("#formSubmit").prepend(hiddenInput);
		});
// 		return false;
	});


});
</script>
<%@ include file="../include/main_style.jsp" %>
<%@ include file="../include/main_bar.jsp" %>
<div class="site-section">

	<div class="container">
	<!-- title img -->
		<form id="formSubmit" role="form" action="/manager/productUpdate"	method="post">
			<input type="hidden" name="p_num" value="${boardVo.p_num}" />
			<div class="row">
				<div class="col-md-6">
					<div >
						<div id="titleImg" class="btn btn-primary imgDrop" style="margin-button: 10px;">
							<c:forEach items="${listImg}" begin="0" end="0" var="img">
							 <div data-filename="${img.title_name}" id="titleImgFile">
								 <img class='img-rounded' src="/upload/displayFile?fileName=${img.title_name}" > <br>
								 <a href="${imgVo.title_name}" class="attach-del" ><span class="attach-del">X</span></a>
							 </div>
						</c:forEach>
						</div>
					</div>
				
				</div>


				<div class="col-md-6">

					<!-- 상품 등록 상세 메뉴 select 바-->
					<div>
						<label>main : </label> 
						<select name="p_main" id="mainOption" disabled="disabled">
							<option value="T" selected="selected">상의
							<option value="P">하의
							<option value="A">악세사리
							<option value="S">신발
						</select>
					</div>
					<div>
						<label>serve : </label> 
						<select name="p_serve" id="serveOption">
							<c:if test="${boardVo.p_main == 'T' }">
								<option value="TH">반팔
								<option value="TL">긴팔
								<option value="TS">셔츠
								<option value="TM">맨투맨
							</c:if>
							<c:if test="${boardVo.p_main == 'P' }">
								<option value="PJ">청바지
								<option value="PM">면바지
								<option value="PH">반바지
								<option value="P7">7부바지
							</c:if>
							<c:if test="${boardVo.p_main == 'S' }">
								<option value="SD">구두
								<option value="SU">운동화
								<option value="SS">스릴퍼
								<option value="SR">로퍼
							</c:if>
							<c:if test="${boardVo.p_main == 'A' }">
								<option value="AR">반지
								<option value="AW">지갑
								<option value="AC">모자
								<option value="AB">가방
							</c:if>
						</select>

					</div>


					<h2 class="text-black">
						상품이름:<input type="text" id="p_name" name="p_name"
							value="${boardVo.p_name}">
					</h2>
					<p id="p_content" name="p_content">상품 설명</p>
					<textarea rows="" cols="" id="p_content" name="p_content">${boardVo.p_content}</textarea>
					<p class="mb-4">상품 설명2</p>
					<p>
						<strong class="text-primary h4"> 가격:<input type="text"
							id="p_price" name="p_price" value="${boardVo.p_price}">
						</strong>
					</p>
					<p>
						상품 코드 <input type="text"
							value="${boardVo.p_main}${boardVo.p_serve}${boardVo.p_num}"
							disabled="disabled" />
					</p>
					<!-- 사이즈 -->
					<div class="mb-1 d-flex sizeinsert">
					<c:forEach items="${prodcutCountList}" var="PC_vo">
					<label for="option-sm" class="d-flex mr-3 mb-3"> 
							<span class="d-inline-block mr-2" style="top: -2px; position: relative;"> 
								<input	type="text" id="p_size" name="p_size" value="${PC_vo.p_size}" 
								style="margin: 10px;" disabled="disabled"> 
								<input type="text" id="p_count" name="p_count" value="${PC_vo.p_count}">
							</span>
							<span class="d-inline-block text-black"></span>
						</label> 
					</c:forEach>
					
					</div>
					<!-- 사이즈 끝 -->
						<div>
							<!-- 상품 등록 버튼 -->
							<button type="submit" class="btn btn-sm btn-primary">상품수정하기</button>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<label>상품 이미지</label>
					<div id="imgDiv">
						<div id="imgFileDrop" class="btn btn-primary imgDrop" style="margin-buttom: 10px; height : auto;">
						 <c:forEach items="${listImg}" var="imgVo">
							 <div data-filename="${imgVo.file_name}">
								 <img class='img-rounded' src="/upload/displayFile?fileName=${imgVo.file_name}" > <br>
								 <a href="${imgVo.file_name}" class="attach-del" ><span class="attach-del">X</span></a>
							 </div>
						 </c:forEach>
						 <div id="update">
						 
						 </div>
						</div>
					</div>
				</div>
		</form>
	</div>
</div>



<%@ include file="../include/foot.jsp" %>