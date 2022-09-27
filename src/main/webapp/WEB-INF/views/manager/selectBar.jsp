<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-12">
				<div>
					<label>main : </label> 
					<select name="p_main" id="mainOption">
						<option value="T">상의</option>
						<option value="P">하의</option>
						<option value="A">악세사리</option>
						<option value="S">신발</option>
					</select> <label>serve : </label> 
					<select name="p_serve" id="serveOption">
						<option value="TH">반팔</option>
						<option value="TL">긴팔</option>
						<option value="TS">셔츠</option>
						<option value="TM">맨투맨</option>
						<option value="PJ">청바지</option>
						<option value="PM">면바지</option>
						<option value="PH">반바지</option>
						<option value="P7">7부바지</option>
						<option value="SD">구두</option>
						<option value="SU">운동화</option>
						<option value="SS">스릴퍼</option>
						<option value="SR">로퍼</option>
						<option value="AR">반지</option>
						<option value="AW">지갑</option>
						<option value="AC">모자</option>
						<option value="AB">가방</option>
					</select>
					<button type="button" id="btnSearch">검색</button>
					<!-- n줄 씩보기 -->
					<select name="perPage" class="form-inline">
						<c:forEach begin="5" end="50" step="5" var="i">
						<option value="${i}" 
							<c:if test="${i == pagingDto.perPage}"> selected</c:if>
							>${i}줄씩 보기</option>
						</c:forEach>
					</select>
				</div>
			</div>