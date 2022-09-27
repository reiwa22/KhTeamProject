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
					<label for="r_info">
						글번호
					</label>
					<input type="text" class="form-control" id="r_info"  name="r_info" value="${jmReviewVo.r_info}"  readonly/>
				</div>
				
				<div class="form-group">
					<label for="r_id">
						아이디
					</label>
					<input type="text" class="form-control" id="r_id" name="r_id" value="${jmReviewVo.r_id}"  readonly/>
				</div>
				
				<div class="form-group">
					<label for="r_subject">
						제목
					</label>
					<input type="text" class="form-control" id="r_subject" name="r_subject" value="${jmReviewVo.r_subject}"  readonly/>
				</div>
				
				<div class="form-group">	
						내용
				</div> 
				
				<div class="form-group">
					<label for="r_content">
						
					</label>
					
					<textarea rows="10" cols="50" id="r_contents" name="r_contents"   readonly>${jmReviewVo.r_contents}</textarea>
				</div>
				
				<div class="form-group">
					<label for="r_files">
						후기 사진
					</label><br>
					
					<%--  <img src="/upload/displayFile?fileName=${jmReviewVo.r_file}"/>  --%>
					  <c:forEach items="${images}" var="fileName">
						<img src="/upload/displayFile?fileName=${fileName}"/>
					
					</c:forEach>  
				</div>
				
				
				
				<div class="form-group">
					<label for="r_subject">
						평점
					</label>
					<input type="text" class="form-control" id="r_star" name="r_star" value="${jmReviewVo.r_star}"  readonly/>
				</div>
				
				
				
				<a href="/jm/jm_reviewForm" class="btn btn-danger">목록으로 가기</a>
				
				<c:choose>
					<c:when test="${sessionScope.u_id == jmReviewVo.r_id}">
						<a href="/jm/jm_updateReview/?r_info=${jmReviewVo.r_info}" class="btn btn-info">수정하기</a>
						<a href="/jm/jm_deleteReview/${jmReviewVo.r_info}" class="btn btn-warning">삭제하기</a>
					</c:when>
					<c:otherwise>
						<a href="/jm//jm_login" class="btn btn-info">댓글 수정과 삭제는 로그인시 가능</a>
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