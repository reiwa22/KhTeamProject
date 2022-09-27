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






<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
					</div>
						<div class="col-md-6">
			<form id="jm_userUpdate" role="form" action="/jm/jm_userUpdate" method="post">
				<div class="form-group">
					 
					<label for="u_id">
						유저 아이디
					</label>
					<input type="text" class="form-control" id="u_id"  name="u_id" value="${jmMemberVo.u_id}" readonly/>
				</div>
				<div class="form-group">
					 
					<label for="u_name">
						유저 이름
					</label>
					<input type="text" class="form-control" id="u_name" name="u_name" value="${jmMemberVo.u_name}" />
				</div>
				
				<div class="form-group">
					 
					<label for="u_email">
						유저 이메일
					</label>
					<input type="text" class="form-control" id="u_email" name="u_email" value="${jmMemberVo.u_email}"/>
				</div>
				
				<div class="form-group">
					 
					<label for="u_address">
						유저 주소
					</label>
					<input type="text" class="form-control" id="u_address" name="u_address" value="${jmMemberVo.u_address}"/>
				</div>
				
				<div class="form-group">
					 
					<label for="u_phone">
						유저 폰 번호
					</label>
					<input type="text" class="form-control" id="u_phone" name="u_phone" value="${jmMemberVo.u_phone}"/>
				</div>
				
				<div class="form-group">
					 
					<label for="u_grade">
						유저 등급
					</label>
					<input type="text" class="form-control" id="u_grade" name="u_grade" value="${jmMemberVo.u_grade}"/>
				</div>
				
				<button type="submit" class="btn btn-danger">
					수정완료
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