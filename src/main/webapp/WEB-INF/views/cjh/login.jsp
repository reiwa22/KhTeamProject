<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<script>
$(document).ready(function() {
	var msg = "${msg}";
	if (msg == "fail") {
		alert("로그인에 실패했습니다.\n아이디/비밀번호를 다시 확인해 주세요");
	}
});
</script>
<div class="bg-light py-3">
	<div class="container">
		<div class="row">
			<div class="col-md-12 mb-0"><a href="/cjh/index">Home</a> <span class="mx-2 mb-0">/</span>
				<a href="/cjh/login">login</a>
			</div>
		</div>
	</div>
</div>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
		 <h3 class="login">로그인</h3>
			<form role="form" action="/cjh/login" method="post">
				<div class="form-group">
					<label for="u_id">아이디</label>
					<input type="text" class="form-control" id="u_id" name="u_id" required/>
				</div>
				<div class="form-group">
					<label for="u_pw">비밀번호</label>
					<input type="password" class="form-control" id="u_pw" name="u_pw" required/>
				</div>
				<button type="submit" class="btn btn-primary">로그인</button>
				<button type="button" class="btn btn-success">회원가입</button>
				<button type="button" class="btn btn-warning">비밀번호 찾기</button>
			</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>

<%@ include file="../include/foot.jsp" %>