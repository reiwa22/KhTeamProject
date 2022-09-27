<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp" %>
<script type="text/javascript" >
$(function() {
	var options = $("#serveOption option");
	var m = $("#mainOption option:selected").val();
	if(m == "T") {   
		$("#serveOption option").remove();
		$("#serveOption").append(options[0]).append(options[1]).append(options[2]).append(options[3]);
		
	}
	$("#mainOption").change(function(){
		$("#serveOption option").remove();
		var main = $(this).val();
		var serve = $("#serveOption").val();
		if(main == "T")                                                  
			$("#serveOption").append(options[0]).append(options[1]).append(options[2]).append(options[3]); 
		if(main == "P")                                                     
			$("#serveOption").append(options[4]).append(options[5]).append(options[6]).append(options[7]); 
		if(main == "S")                                                       
			$("#serveOption").append(options[8]).append(options[9]).append(options[10]).append(options[11]);
		if(main == "A")                                        
			$("#serveOption").append(options[12]).append(options[13]).append(options[14]).append(options[15]); 
		
		var sendData = {"main_code" : main};
		var url = "/ajax/dress_size";
		$(".dress_size").children().remove();
		$.ajax({
			"type" : "post",
			"url" : url,
			"data" : sendData,
			"success" : function(rData){
				console.log(rData);
				$.each(rData, function() {
					var size = this.size_type;
					if(size != null || !size.equals("")){
						var html = "<div  style='float: left;'><label for='option-sm' class='d-flex mr-3 mb-3'>";
						html += "<span class='d-inline-block mr-2' style='top: -2px; position: relative;''> ";
						html += "<label  style='margin: 10px;'>"+size+"</label> ";
						html += "<input type='hidden' name='p_size' value='"+size+"'>";
						html +="<input type='text' id='p_count' name='p_count' value='0'></span></label></div>";
					$(".dress_size").append(html);
					};
				});
			}
		});
	});
	
		

	
	//이미지 파일 드롭
	//타이틀 이미지

	$("#titleImg").on("dragenter dragover", function(e){
		e.preventDefault();
	});
	
	$("#titleImg").on("drop",function(e){
		e.preventDefault();
		$("#titleImgFile").remove();
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
				console.log(rData)
				var slashIndex = rData.lastIndexOf("/");
				var front = rData.substring(0, slashIndex +1);
				var rear = rData.substring(slashIndex +1);
				var thumbnailName = front + rear;
				var originalFilename = rData.substring(rData.indexOf("_")+1);
				var html ="<div data-filename='"+rData+"' id='titleImgFile'>";
					html += "<img class='img-rounded' src='/upload/displayFile?fileName="+thumbnailName+"' /><br>";
					html += "<span>"+originalFilename+"</span>";
					html +="<a href='"+rData+"' class='attach-del'><span class='pull-rigth'>X</span></a>";
					html +="</div>";
					$("#titleImg").append(html);
			}
		});
	});
	$("#imgFileDrop").on("dragenter dragover", function(e){
		e.preventDefault();
	});
	// 광고 사진
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
				console.log(rData)
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
					$("#imgFileDrop").append(html);
			}
		});
	});
	
	//삭제 버튼
	$(".imgDrop").on("click",".attach-del", function(e){
		e.preventDefault();
		$(this).css("height", "200px");
		var that = $(this);
		
		var filename = $(this).attr("href");
		var url= "/upload/deleteFile";
		var sendData= {"filename" : filename};
		$.ajax({
			"type" : "GET",
			"url" : url,
			"data" : sendData,
			"success" : function(rData){
				that.parent().remove();
			}
		});
	});
	$("#formSubmit").submit(function(){
// 	$("#btnSubmit").cliclk(function(){
		var upDiv = $("#imgFileDrop > div");
		var titleDiv = $("#titleImg > div");
		console.log("upDiv :   :"+upDiv);
		console.log("titleDiv :   :"+titleDiv);
		
// 		if(upDiv ==null || upDiv.equals("")){
// 			alert("사진을 등록해주세요");
// 			return false;
// 		} 
// 		if(titleDiv ==null || titleDiv.equals("")){
// 			alert("메인 사진을 등록해주세요.");
// 			return false;
// 		}
		upDiv.each(function(index){
			var filename = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='p_files["+index+"]' value='"+filename+"'/>";
			$("#formSubmit").prepend(hiddenInput);
		});
		titleDiv.each(function(index){
			var filename = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='title_name' value='"+filename+"'/>";
			$("#formSubmit").prepend(hiddenInput);
		});
// 		var p_size = [];
// 		$("label[name=p_size]").each(function() {
// 			size = $(this).text();
// 			p_size.push(size);
// 		});
// 		console.log(p_size);
// 		var size = $("label[name=p_size]").val();
// 		console.log(size);
	
		
	});
});
</script>

<%@ include file="../include/main_style.jsp" %>
<%@ include file="../include/main_bar.jsp" %>


<div class="site-section">
	<div class="container">
		<!-- 시작 -->
		<form id="formSubmit" role="form" action="/manager/shop_single_input"	method="post">
			<div class="row">

				<div class="col-md-6">
					<div >
						<div id="titleImg" class="btn btn-primary imgDrop" style="margin-button: 10px;">
						
						</div>
					</div>
				
				</div>
				
					<div class="col-md-6">

					<!-- 상품 등록 상세 메뉴 -->
					<div>
					<!-- main title -->
						<label>main : </label> 
						<select name="p_main" id="mainOption">
							<c:forEach items="${mainList}" var="mainVo">
								<option value="${mainVo.main_code}">${mainVo.main_name}
							</c:forEach>
						</select>
					<!-- serve title -->
						<label>serve : </label> 
						<select name="p_serve" id="serveOption">
							<c:forEach items="${serveList}" var="serveVo">
								<option value="${serveVo.serve_code}" selected="selected">${serveVo.serve_name}
							</c:forEach>
						</select>
					</div>
	<c:if test="${p_deleted == 'd' }">
		<samp></samp>
	</c:if>
					<h2 class="text-black">
						상품이름<input type="text" id="p_name" name="p_name">
					</h2>
					<p>
						<label>상품 설명</label>
						<input type="text" id="p_content" name="p_content">
					</p>
					<p>
						<strong class="text-primary h4"> 가격
						<input type="text"	id="p_price" name="p_price">
						</strong>
					</p>
					<!-- 사이즈 -->
					<div class="mb-1 d-flex dress_size">
						<div style='float: left;'>
							<label for='option-sm' class='d-flex mr-3 mb-3'> <span
								class='d-inline-block mr-2'
								style='top: -2px; position: relative;''> 
								<label style='margin: 10px;'>S</label> <input type='hidden'
									name='p_size' value='S'> <input type='text'
									id='p_count' name='p_count' value='0'>
							</span>
							</label>
						</div>
						<div style='float: left;'>
							<label for='option-sm' class='d-flex mr-3 mb-3'> <span
								class='d-inline-block mr-2'
								style='top: -2px; position: relative;''> 
								<label style='margin: 10px;'>M</label> <input type='hidden'
									name='p_size' value='M'> <input type='text'
									id='p_count' name='p_count' value='0'>
							</span>
							</label>
						</div>
						<div style='float: left;'>
							<label for='option-sm' class='d-flex mr-3 mb-3'> <span
								class='d-inline-block mr-2'
								style='top: -2px; position: relative;''> 
								<label style='margin: 10px;'>L</label> <input type='hidden'
									name='p_size' value='L'> <input type='text'
									id='p_count' name='p_count' value='0'>
							</span>
							</label>
						</div>
						<div style='float: left;'>
							<label for='option-sm' class='d-flex mr-3 mb-3'> <span
								class='d-inline-block mr-2'
								style='top: -2px; position: relative;''> 
								<label style='margin: 10px;'>XL</label> 
								<input type='hidden' name='p_size' value='XL'> <input type='text'
									id='p_count' name='p_count' value='0'>
							</span>
							</label>
						</div>


					</div>
					<!-- 사이즈 끝 -->

					<button type="submit" id="btnSubmit" class="btn btn-sm btn-primary imgDrop">상품 등록하기</button>
				</div>

			</div>
			<div class="col-md-12">
				<label>상품 이미지</label>
				<div id="imgDiv">
					<div id="imgFileDrop" class="btn btn-primary imgDrop" style="margin-buttom: 10px;">
					</div>
				</div>
			</div>
		</form>
		<!-- 끝 -->
	</div>

</div>




<%@ include file="../include/foot.jsp" %>