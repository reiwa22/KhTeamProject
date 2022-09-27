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
 	$("#btnOk").click(function(e){
		console.log(e);    
		
		var u_id =$ ("#u_id").val();
		console.log(u_id);
		
		var url = "/jm/jm_userPwEmail";
		sendData = {"u_id" : u_id};
		
		$.get(url,sendData,function(rData){
			  console.log(rData); 
			  	  
			  var email =rData.u_email;
			  var pw =rData.u_pw;
			  
			   $("#to").val(email);
			  $("#contents").val("비밀번호는"+pw+"입니다"); 
		 });

	}); 
 	
 	$("#btnEmail").click(function(){
 		
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
			<form id="mailFrom"  role="form" action="/email/sendPwMail" method="post" >
			
			
				<div class="form-group">
					 
					<label for="u_id">
						아이디
					</label>
					<input type="text" class="form-control" id="u_id" name="u_id" placeholder="아이디를 입력하세요"/>
				</div>
				<button type="button" class="btn btn-warning" id="btnOk">
					확인
				</button>
	
				<div class="form-group">
					 
					<label for="to">
						이메일
					</label>
					<input type="email" class="form-control" id="to" name="to"    readonly/>
				</div>
				
				<div class="form-group"> 
					<label for="contents">	
					</label>
					
					<input type="hidden" class="form-control" id="contents" name="contents"  />
				</div>
				
				<div class="form-group"> 
					<label for="subject">	
					</label>
					
					<input type="hidden" class="form-control" id="subject" name="subject" value="비밀번호 확인 메일 입니다" />
				</div>
				
				
				<button type="submit" class="btn btn-info" id="btnEmail" name="btnEmail">
					전송하기
				</button>
			</form>
						<div class="col-md-3">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<%@ include file="../include/foot.jsp" %>