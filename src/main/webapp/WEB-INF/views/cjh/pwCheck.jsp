<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp" %>

<script>
$(document).ready(function() {
	var msg = "${msg}";
	if (msg == "fail") {
		alert("비밀번호를 다시 확인해 주세요");
	}
});
</script>

<div class="bg-light py-3">
	<div class="container">
		<div class="row">
			<div class="col-md-12 mb-0"><a href="/cjh/index">Home</a> <span class="mx-2 mb-0">/</span>
				<a href="/cjh/mypage">My Page</a>  <span class="mx-2 mb-0"></span>
			</div>
		</div>
	</div>
</div>

<div class="site-section">
	<div class="container">
    	<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-5"><h3 class="tit">비밀번호 확인</h3></div>
				<div class="col-lg-4"></div>
				<form id="modifyForm" role="form" action="/cjh/pwCheck" method="post">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<table class="table">
									<thead>
										<tr id="password-area" style="">
					                        <th scope="row">비밀번호</th>
					                        <td colspan="2">
					                        	<input type="hidden" name="u_id" value="${u_id}"/>
												<input type="password" class="form-control" id="u_pw" name="u_pw" required/>
											</td>
					                    </tr>
									</thead>
								</table>
							</div>
							<button id="btnPwCheck" type="submit" class="btn btn-default">비밀번호 확인</button>
						</div>
					</div>
				</form>
				
			</div>
    <!-- /.row -->
		</div>
	</div>
</div>


<%@ include file="../include/foot.jsp" %>