<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src ="/resources/js/jm_Script.js" ></script>

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
						
						
			<form   role="form" action="/jm/jm_insertContactRun" method="post">
				<div class="form-group">
					 
					<label for="c_id">
						
					</label>
					<input type="hidden" class="form-control" id="c_id" name="c_id" value="${sessionScope.u_id}" readonly />
				</div>
				
				<div class="form-group">
					 
					<label for="c_subject">
						제목 <span class="text-danger">*</span> 
					</label>
					<input type="text" class="form-control" id="c_subject" name="c_subject" required />
				</div>
					
				<div class="form-group">	
						내용 <span class="text-danger">*</span>
				</div> 
					
				<div class="form-group">
					
					<label for="c_contents">
						
					</label>
					<textarea rows="10" cols="50" id="c_contents" name="c_contents" required></textarea>
				</div>

				<button id="btnbtn" type="submit" class="btn btn-primary">
					작성 완료
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