<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<form role="form">
			
				<div class="form-group">
					<label for="c_info">
						글번호
					</label>
					<input type="text" class="form-control" id="c_info"  name="c_info" value="${jmContactVo.c_info}"  readonly/>
				</div>
				
				<div class="form-group">
					<label for="c_id">
						아이디
					</label>
					<input type="text" class="form-control" id="c_id" name="c_id" value="${jmContactVo.c_id}"  readonly/>
				</div>
				
				<div class="form-group">
					<label for="c_subject">
						제목
					</label>
					<input type="text" class="form-control" id="c_subject" name="c_subject" value="${jmContactVo.c_subject}"  readonly/>
				</div>
				
				<div class="form-group">	
						내용
				</div> 
				
				<div class="form-group">
					<label for="r_content">
						
					</label>
					
					<textarea rows="10" cols="50" id="c_contents" name="c_contents"   readonly>${jmContactVo.c_contents}</textarea>
				</div>
				
				
				
				
				<a href="/jm/jm_contact" class="btn btn-danger">목록으로 가기</a>
				
				<c:choose>
					<c:when test="${sessionScope.u_id == jmContactVo.c_id}">
						<a href="/jm/jm_updateContact/?c_info=${jmContactVo.c_info}" class="btn btn-info">수정하기</a>
						
					</c:when>
					<c:otherwise>
					</c:otherwise>
				
				
				</c:choose>
				
			</form>
						<div class="col-md-3">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




<%@ include file="../include/foot.jsp" %>