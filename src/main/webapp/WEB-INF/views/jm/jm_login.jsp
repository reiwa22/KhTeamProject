<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../include/head.jsp" %> 



<!--  <style>
.form-control { 
  
 padding: 20px; 
  width: 300px; 
  
  border-radius: 5px; 
  top: 50%; 
  left: 50%; 
  
  
  
  
} 
</style>  -->

<script>
$(document).ready(function() {
	var msg = "${msg}";
	if (msg == "success") {
		alert("회원탈퇴가 완료되었습니다.");
	}
});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
					</div>
						<div class="col-md-6">
						
			<form id="formIdPw"  role="form" action="/jm/jm_login" method="post">
			
				<div class="p-3 p-lg-5 border">
					<div class ="text-center">
						<h3>로그인</h3>
					</div>
		
				<div class="form-group " >
					 
					<label for="user_id">
						아이디 <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="user_id"  name="u_id" required />
				</div>
				<div class="form-group">
					 
					<label for="user_pw">
						비밀번호 <span class="text-danger">*</span>
					</label>
					<input type="password" class="form-control" id="user_pw" name="u_pw" required  />
				</div>
				
					 
					
				<button type="submit" class="btn btn-danger">
					로그인
				</button>
				<a type="button" class=" btn btn-sm  btn-warning"  href="/jm/jm_signUp" >회원가입</a>
				<a type="button" class=" btn btn-sm  btn-info"  href="/jm/jm_userPw" >비밀번호 찾기</a>		
				
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