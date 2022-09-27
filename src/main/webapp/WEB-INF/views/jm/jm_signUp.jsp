<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
 

 <style>
.form-control { 
  
 padding: 20px; 
  width: 300px; 
    
  border-radius: 5px; 
  top: 50%; 
  left: 50%; 
  
  
  
  
} 
</style> 

<script>
$(function(){
	$("#btnUp").click(function(){
		console.log();
		
		var u_email=$("#u_email").val();
		
		$("#to").val(u_email);
		
		alert("회원가입 처리중입니다");
		
	});
	
	$("#u_pwCheck").click(function(){
		console.log();
		var u_pw = $("#u_pw").val();
		var u_pwCheck = $("#u_pw2").val();
		
		if(u_pw != u_pwCheck){
			$("#CheckPwSpan").text("비밀번호가 일치하지 않습니다. 재확인 해 주세요.");
		}else{
			$("#CheckPwSpan").text("비밀번호가 일치합니다.");
		}	
	});
	
	$("#u_idCheck").click(function(e){
		console.log(e);
		var u_id = $("#u_id").val();
		  
		if(u_id ==""){
			$("#CheckidSpan").text("아이디를 입력하세요.");
			return;
		}
		
		
		
		var sendData = {"u_id" :u_id};
		var url="/jm/jm_selectIdCheck"
		console.log(sendData);
		console.log(JSON.stringify(sendData));
		
		
		$.ajax({
			"type":"get",
			"url":url,
			"dataType":"text",
			"data": sendData,	
		     "headers" :{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override":"get"
			},     

			"success" : function(rData){
				console.log(rData);
				
				
				
				
				if(rData =="success"){
					$("#CheckidSpan").text("중복된 아이디 입니다");
					$("#btnUp").hide();
				}else{
					$("#CheckidSpan").text("사용 가능한 아이디 입니다");
					$("#btnUp").show();
				}
				
			}		
		
		});
			
	});
	
	
	
	
	
	
	
});
</script>





<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
					</div>
						<div class="col-md-6">
		
		
			<form id="joinForm" role="form" action="/jm/jm_signUpRun" method="post">
				<div class="p-3 p-lg-5 border">
					<div class ="text-center">
						<h3>회원가입</h3>
					</div>
					
				<div class="form-group ">
					 
					<label for="u_id">
						아이디 <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_id" name="u_id" required />
				</div>
				
					<button type="button" class="btn btn-sm btn-info" id="u_idCheck">아이디 중복 체크</button>
					
					<span id="CheckidSpan">
					
					</span>
				
				
				
				<div class="form-group">
					 
					<label for="user_pw">
						비밀번호 <span class="text-danger">*</span>
					</label>
					<input type="password" class="form-control" id="u_pw" name="u_pw"  required/>
				</div>
				
				 <div class="form-group">
				<label for="u_pwCheck">
						비밀번호 재확인
					</label>
					<input type="password" class="form-control" id="u_pw2" name="u_pw2"  required/>
					
				</div> 
				
					<button type="button" class="btn btn-sm btn-warning" id="u_pwCheck">비밀번호 확인</button>
					
					<span id="CheckPwSpan">
					
					</span>
					
					
				
				
				
				<div class="form-group">
				<label for="u_name">
						이름 <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_name" name="u_name"  required/>
				</div>
				
				 <div class="form-group">
				<label for="user_gender">
						성별 
					</label>
					<select id="u_gender" name="u_gender">
						<option>m</option>
						<option selected>f</option>
					</select>
				</div> 

				<div class="form-group">
				<label for="u_email">
						메일주소 <span class="text-danger">*</span>
					</label>
					<input type="email" class="form-control" id="u_email" name="u_email"  required/>
				</div>
				
				
				<div class="form-group">
				<label for="u_address">
						주소 <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_address" name="u_address" required />
				</div>
				
				
				
				<div class="form-group">
				<label for="u_phone">
						핸드폰번호 <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_phone" name="u_phone" required />
				</div>
				
				<div class="form-group">
				<label for="to">
						<!-- 메일 주소 -->
					</label>
					<input type="hidden" class="form-control" id="to" name="to"  />
				</div>
				
				<div class="form-group">
				<label for="subject">
						<!-- 메일 제목 -->
					</label>
					<input type="hidden" class="form-control" id="subject" name="subject" value="회원가입을 축하 드립니다" />
				</div>
				
				<div class="form-group">
				<label for="contents">
						<!-- 메일 내용 -->
					</label>
					<input type="hidden" class="form-control" id="contents" name="contents"  value="회원 가입을 축하 드립니다 즐거운 이용이 되시길 바랍니다"/>
				</div>
				
				
				
					
					약관 확인 
				<select>
				<option >비동의</option>
				<option selected>동의</option>
				</select>
				
				<button type="button" class="btn btn-danger" id="btnOk" name="btnOk">
					약관 확인
				</button><br>
				
			
				<button type="submit" class="btn btn-primary" id="btnUp">
					가입하기
				</button>
				
				</div>
				
			</form>
			
			
			<div class="col-md-3">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




<%@ include file="../include/foot.jsp" %>