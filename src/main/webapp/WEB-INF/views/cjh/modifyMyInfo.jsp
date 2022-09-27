<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp" %>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("myAddress").value = extraAddr;
                
                } else {
                    document.getElementById("myAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("mainAddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>

<script>
$(document).ready(function() {
	var msg = "${msg}";
	if (msg == "fail") {
		alert("비밀번호가 올바르지 않습니다.");
	}
	$("#btnModify").click(function(e) {
		e.preventDefault();
		var u_pw = $("#u_pw").val();
		var u_pwCheck = $("#u_pwCheck").val();
		
		if (u_pw != u_pwCheck || u_pw == "" || u_pwCheck == "") {
			alert("비밀번호를 확인해주세요");
			$("#u_pw").css("background-color", "#f2f2f2");
			$("#u_pwCheck").css("background-color", "#f2f2f2");
			$("#u_pwCheck").focus();
			return;
		}
		
		var mainAddress = $("#mainAddress").val();
		var detailAddress = $("#detailAddress").val();
		var myAddress = mainAddress +" "+ detailAddress;
		$("#myAddress").val(myAddress);
// 		console.log("myAddress : " + myAddress);
		$("#modifyForm").submit();
	});
	
	$("#btnCancel").click(function() {
		location.href="/cjh/mypage";
	});
	
	$("#btnQuit").click(function() {
		var pw = $("#pw").val();
		var pwCheck = $("#pwCheck").val();
		if (pw == "") {
			$("#pw").css("background-color","f2f2f2");
			$("#pw").attr("placeholder", "비밀번호를 입력해주세요.");
			$("#pw").focus();
		} else if (pwCheck == "") {
			$("#pwCheck").css("background-color","f2f2f2");
			$("#pwCheck").attr("placeholder", "비밀번호를 입력해주세요.");
			$("#pwCheck").focus();
		} else if (pw != pwCheck) {
			$("#pwCheck").css("background-color","f2f2f2");
			$("#pwCheck").attr("placeholder", "비밀번호를 확인해주세요.");
			$("#pwCheck").focus();
		} else {
			location.href="/cjh/quitUser?u_pw="+pw;
		}
	});
	
	$('.modal').on('hidden.bs.modal', function (e) {
	    $("#pw").val("");
	    $("#pwCheck").val("");
	    $("#pw").removeAttr("style");
		$("#pw").removeAttr("placeholder");
	    $("#pwCheck").removeAttr("style");
		$("#pwCheck").removeAttr("placeholder");
	});
	 
});
</script>

<div class="modal fade" id="modal-container-572251" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="myModalLabel">
					비밀번호 확인
				</h5> 
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" id="pw1">비밀번호 <input type="password" class="form-control" id="pw"/></div>
			
			<div class="modal-body" id="pwCheck1">비밀번호 확인 <input type="password" class="form-control" id="pwCheck"/></div>
			
			<div> - 현재 페이지의 [회원탈퇴] 버튼을 누르시면 회원 탈퇴가 완료됩니다.</div>
			<div> - 비밀번호를 정확히 입력해주세요.</div>
			<div> - 회원탈퇴후 계정복구가 불가능합니다.</div>
			<div class="modal-footer">
				<button type="button" id="btnQuit" class="btn btn-danger">
					회원 탈퇴
				</button> 
			</div>
		</div>
	</div>
</div>


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
				<div class="col-lg-5"><h3 class="tit">회원 기본 정보</h3></div>
				<div class="col-lg-4"></div>
				<form id="modifyForm" role="form" action="/cjh/modifyMyInfo" method="post">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<table class="table">
									<thead>
										<tr>
					                        <th scope="row">아이디</th>
					                        <td colspan="2">
												<input type="text" class="form-control" id="u_id" name="u_id"
														value="${userVo.u_id}" readonly/>
											</td>
					                    </tr>
									</thead>
									<thead>
										<tr id="password-area" style="">
					                        <th scope="row">비밀번호</th>
					                        <td colspan="2">
												<input type="password" class="form-control" id="u_pw" name="u_pw"
														value="" required/>
											</td>
					                    </tr>
	
									</thead>
									<thead>
										<tr id="passwordCheck-area" style="">
					                        <th scope="row">비밀번호 확인</th>
					                        <td colspan="2">
												<input type="password" class="form-control" id="u_pwCheck" name="u_pwCheck"
														value="" required/>
											</td>
					                    </tr>
	
									</thead>
									
									<thead>
										<tr id="nickName-area" style="">
											<th scope="row">닉네임</th>
											<td colspan="2">
												<input type="text" class="form-control" id="u_name" name="u_name"
														value="${userVo.u_name}" required/>
											</td>
										</tr>
									</thead>
									
									<thead>
										
										<tr id="email-area">
											<th scope="row">이메일</th>
											<td colspan="2">
												<input type="email" class="form-control" id="u_email" name="u_email"
														value="${userVo.u_email}"/>
											</td>
										</tr>
									</thead>
									
									<thead>
										
										<tr id="phone-area">
											<th scope="row">전화번호</th>
											<td colspan="2">
												<input type="text" class="form-control" id="u_phone" name="u_phone"
														value="${userVo.u_phone}"/>
											</td>
										</tr>
									</thead>
									
									<thead>
										
										<tr id="email-area">
											<th scope="row">회원등급</th>
											<td colspan="2">
												<input type="text" class="form-control" id="u_grade" name="u_grade"
														value="${userVo.u_grade}" readonly/>
											</td>
										</tr>
									</thead>
									
									<thead>
										<tr id="address-area">
											<th scope="row">주소</th>
											<td colspan="2">
												<input type="text"  id="postcode" placeholder="우편번호">
												<input type="button"  onclick="sample6_execDaumPostcode()" value="내 주소 찾기"><br>
												<input type="text" class="form-control" id="mainAddress" placeholder="주소"><br>
												<input type="text" class="form-control" id="detailAddress" placeholder="상세주소">
												<input type="text" class="form-control" value="${userVo.u_address}" name="u_address" id="myAddress" placeholder="주소" readonly>
											</td>
										</tr>
									</thead>
								</table>
							</div>
							<button id="btnCancel" type="button" class="btn btn-basic">취소</button>
							<button id="btnModify" type="button" class="btn btn-success">정보 수정 완료</button>
							<a id="modal-572251" href="#modal-container-572251" role="button" class="btn btn-danger" data-toggle="modal">회원탈퇴</a>
							
							
						</div>
					</div>
				</form>
				
			</div>
    <!-- /.row -->
		</div>
	</div>
</div>


<%@ include file="../include/foot.jsp" %>