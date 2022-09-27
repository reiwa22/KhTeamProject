<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

 <style>
.form-inline { 
  
  padding: 20px; 
  width: 300px; 
  
  border-radius: 5px; 
  top: 25%; 
  left: 25%; 
  margin: 25
} 

h3{
	color :red;
	text-align :center;

}

.btn-group{
	padding: -23px; 
	width: 300px; 
  
	border-radius: 5px; 
	top: 25%; 
	left: 25%; 
	margin: -10
	

}

</style> 

<h3>관리자 유저정보 관리 페이지 입니다</h3>

 <%@ include file="../include/main_bar.jsp" %>
 
<script>
$(function(){
	
	//몇개씩 보기
	$("select[name=perPage]").change(function(){
		console.log($(this).val());
		$("#formPage > input[name=perPage]").val($(this).val());
		    $("#formPage").submit();   
	});
	
	
	//페이지 번호
	$("a.page-link").click(function(e){
		e.preventDefault();
		
		var page = $(this).attr("href").trim();
		
		$("#formPage >input[name=page]").val(page);
		$("#formPage").submit();	
	});
	
	//검색 버튼
	$("#btnSearch").click(function(){
		
		var searchType = $("select[name=searchType]").val();
		var keyword = $("#keyword").val();
		
		$("#formPage >input[name=searchType]").val(searchType);
		$("#formPage >input[name=keyword]").val(keyword);
		$("#formPage").submit();	
	});
	
	//현재 페이지 액티브
	$("a.page-link").each(function(){
		var page = $(this).attr("href");
		if(page =="${jmPagingDto.page}"){
			$(this).parent().addClass("active");
			return;
		}	
	});
});

</script>




 
 
 
 
 
 
 
 
 
 
 
 
 
 <!-- 페이지 링크 -->
 <form id="formPage" action="/jm/jm_userList" method="get">
 	<input type="hidden" name="u_info" value="${jmMemberVo.u_info}">
 	<input type="hidden" name="page" value="${jmPagingDto.page}">
 	<input type="hidden" name="perPage" value="${jmPagingDto.perPage}">
 	<input type="hidden" name="searchType" value="${jmPagingDto.searchType}">
 	<input type="hidden" name="keyword" value="${jmPagingDto.keyword}">
 
 
 
 </form>
 	
	<select name="perPage" class="form-inline">
		<c:forEach begin="5" end="30" step="5" var="i">
			<option value="${i}"
				<c:if test="${i==jmPagingDto.perPage}">selected</c:if>
			>${i}줄씩 보기</option>
		</c:forEach>
	</select> 
	
	
	<select name="searchType" class="form-inline">
		
		<option value="u_id" 
		<c:if test="${jmPagingDto.searchType =='u_id'}">selected</c:if>
		>아이디</option>
		
		<option value="u_grade"
		<c:if test="${jmPagingDto.searchType =='u_grade' }">selected</c:if>
		>등급</option>
	</select>
	
	<input type="text" id="keyword" name="keyword" class="form-inline"
		value="${jmPagingDto.keyword}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="btnSearch" class="btn btn-info">검색</button>
	
	



 <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							아이디
						</th>
						<th>
							이름
						</th>
						<th>
							이메일
						</th>
						<th>
							주소
						</th>
						<th>
							폰번호
						</th>
						<th>
							성별
						</th>
						<th>
							등급
						</th>
						<th>
							수정
						</th>
						<th>
							삭제
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="jmMemberVo">
					<tr>
						<td>
							${jmMemberVo.u_id}
						</td>
						<td>
							${jmMemberVo.u_name}
						</td>
						<td>
							${jmMemberVo.u_email}
						</td>
						<td>
							${jmMemberVo.u_address}
						</td>
						<td>
							${jmMemberVo.u_phone}
						</td>
						<td>
							${jmMemberVo.u_gender}
						</td>
						<td>
							${jmMemberVo.u_grade}
						</td>
						<td>
							<a type="button" class=" btn btn-sm  btn-warning" href="/jm/jm_userUpdate?u_id=${jmMemberVo.u_id}">유저 수정</a>
						</td>
						<td>
							<a type="button" class=" btn btn-sm  btn-danger"  href="/jm/jm_userDelete?u_id=${jmMemberVo.u_id}" >유저 삭제</a>
						</td>
					</tr>
					</c:forEach>
					
					
				</tbody>
			</table>
		</div>
	</div>
</div>
 
 
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
					<nav>
						<ul class="pagination">
						
						<c:if test="${jmPagingDto.startPage !=1 }">
							<li class="page-item">
								<a class="page-link" href="${jmPagingDto.startPage-1}">&laquo;</a>
							</li>
						</c:if>	
						<c:forEach begin="${jmPagingDto.startPage}" end="${jmPagingDto.endPage }" var="s">
							<li class="page-item">
								<a class="page-link" href="${s}">${s}</a>
							</li>
						</c:forEach>	
						<c:if test="${jmPagingDto.endPage <jmPagingDto.totalPage}">
							<li class="page-item">
								<a class="page-link" href="${jmPagingDto.endPage+1 }">&raquo;</a>
							</li>	
						</c:if>		
							
						</ul>
					</nav>
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
</div>




<%@ include file="../include/foot.jsp" %>