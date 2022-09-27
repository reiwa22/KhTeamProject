<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  

<%@ include file="../include/head.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
$(function() {
	
	// 게시물 클릭
	$("a.title").click(function(e) {
		e.preventDefault();
		var p_num = $(this).attr("data-p_num");
		$("#singlePage > input[name=p_num]").val(p_num);
		$("#singlePage").attr("action", $(this).attr("href"));
		$("#singlePage").submit();
	});
	
	// 정렬 하기
	$("#type").change(function() {
		var type = $("select[name=type]").val();
		if ("${p_main}" != "") {
			$("#mainPage > input[name=type]").val(type);
			$("#mainPage").submit();
		} else if ("${p_serve}" != "") {
			$("#servePage > input[name=type]").val(type);
			$("#servePage").submit();
		} else { 
			$("#shop > input[name=type]").val(type);
			$("#shop").submit();
		}
	});
	
	// 메인 메뉴 클릭
	$(".main").click(function(e) {
		e.preventDefault();
		var length =$(this).attr("href").length;
		var p_main = $(this).attr("href").substring(length-1);
		$("#mainPage > input[name=p_main]").val(p_main);
		$("#mainPage > input[name=type]").val("PL");  
		$("#mainPage > input[name=page]").val("1");
		$("#mainPage").submit();
	});
	
	// 서브 메뉴 클릭
	$(".serve > li > a").click(function(e) {
		e.preventDefault();  
		var length = $(this).attr("href").length;
		var p_serve = $(this).attr("href").substring(length-2);
		$("#servePage > input[name=p_serve]").val(p_serve);
		$("#servePage > input[name=type]").val("PL");
		$("#servePage > input[name=page]").val("1");
		$("#servePage").submit();
	}); 
	
	// 현재 페이지 액티브
	$("a.page").each(function() {
		var page = $(this).attr("href");
		if (page == "${lshBoardDto.page}") {
			$(this).parent().addClass("active");
			return;
		}
	});
	
	// 쪽번호 클릭
	$("a.page").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href").trim();
		if ("${p_main}" != "") {
			$("#mainPage > input[name=page]").val(page);
			$("#mainPage").submit();
		} else if ("${p_serve}" != "") {
			$("#servePage > input[name=page]").val(page);
			$("#servePage").submit();
		} else { 
			$("#shop > input[name=page]").val(page);
			$("#shop").submit();
		}
	});
});
</script>
<%@ include file="frmPage.jsp" %>
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
          		<a href="/">Home</a> 
          		<span class="mx-2 mb-0">/</span> 
          		<strong class="text-black">Shop</strong>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-2">

            <div class="row">
              <div class="col-md-12 mb-5">
                <div class="float-md-left mb-4"><h2 class="text-black h5">Shop</h2></div>
                <div class="d-flex"> 
                  <div class="dropdown mr-1 ml-md-auto">
                    <select name="type" id="type">
                    	<option value="PL" 
                    		<c:if test="${lshBoardDto.type == 'PL'}">selected</c:if>
                    	>가격 낮은순</option>
                    	<option value="PH" 
                    	    <c:if test="${lshBoardDto.type == 'PH'}">selected</c:if>
                    	>가격 높은순</option>
                    	<option value="VH" 
                    	    <c:if test="${lshBoardDto.type == 'VH'}">selected</c:if>
                    	>조회 높은순</option>
                    	<option value="VL" 
                    	    <c:if test="${lshBoardDto.type == 'VL'}">selected</c:if>
                    	>조회 낮은순</option>
                    </select>
                    
                  </div>
                </div>
              </div>
            </div>
            
            <div class="row mb-5">
			  <c:forEach items="${list}" var="lshBoardVo">
			  
	              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
	                <div class="block-4 text-center border">
	                
	                <a class="block-4 title" href="shop_single" data-p_num="${lshBoardVo.p_num}">
					 	<img src="/upload/displayFile?fileName=${lshBoardVo.title_name}">
					</a>
					
	                  <div class="block-4-text p-4">
	                    <h3><a href="shop_single" class="title" data-p_num="${lshBoardVo.p_num}">${lshBoardVo.p_name}</a></h3>
	                    <p class="mb-0">${lshBoardVo.p_content}</p>
	                    <p class="text-primary font-weight-bold">
	                    <fmt:formatNumber value="${lshBoardVo.p_price}" pattern="#,###"/>원
	                    </p>
	                  </div>
	                  <div class="block-4-text right">
	                    <p>조회수 : ${lshBoardVo.p_viewCnt}</p>
	                  </div>
	                </div>
	              </div>
              </c:forEach>
            </div>
            
            
            
          </div>
          
          

          <div class="col-md-3 order-1 mb-5 mb-md-0">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
              <h2 class="mb-3 h6  text-black d-block"><a href="shop">전체 상품</a></h2>
              
           		<a href="shop?p_main=T" class="main">상의</a>
           		<ul class="dropdown serve"> 
	                <li><a href="shop?p_serve=TH">반팔</a></li>
	                <li><a href="shop?p_serve=TL">긴팔</a></li>
	                <li><a href="shop?p_serve=TS">셔츠</a></li>
	                <li><a href="shop?p_serve=TM">맨투맨</a></li>
              	</ul>
              	 
           		<a href="shop?p_main=P" class="main">하의</a>
           		<ul class="dropdown serve">
	                <li><a href="shop?p_serve=PJ">청바지</a></li>
	                <li><a href="shop?p_serve=PM">면바지</a></li>
	                <li><a href="shop?p_serve=PH">반바지</a></li>
	                <li><a href="shop?p_serve=P7">7부바지</a></li>
              	</ul>
              	
           		<a href="shop?p_main=S" class="main">신발</a>
           		<ul class="dropdown serve">
	                <li><a href="shop?p_serve=SD">구두</a></li>
	                <li><a href="shop?p_serve=SU">운동화</a></li>
	                <li><a href="shop?p_serve=SS">슬리퍼</a></li>
	                <li><a href="shop?p_serve=SR">로퍼</a></li>
              	</ul>
              	
           		<a href="shop?p_main=A" class="main">악세사리</a>
           		<ul class="dropdown serve">
	                <li><a href="shop?p_serve=AR">반지</a></li>
	                <li><a href="shop?p_serve=AW">지갑</a></li>
	                <li><a href="shop?p_serve=AC">모자</a></li>
	                <li><a href="shop?p_serve=AB">가방</a></li>
              	</ul>
              
            </div>

          </div>
        </div>

		<div class="row" data-aos="fade-up">
              <div class="col-md-12 text-md-center">
                <div class="site-block-27">
                  <ul>
                  	<c:if test="${lshBoardDto.startPage != 1}">
	                    <li>
	                    	<a class="page" href="${lshBoardDto.startPage - 1}">&lt;</a>
	                    </li>
                  	</c:if>
                  	
                  	<c:forEach begin="${lshBoardDto.startPage}" end="${lshBoardDto.endPage}" var="v">
                    	<li>
                    		<a class="page" href="${v}">${v}</a>
                    	</li>
                    </c:forEach>
                    
                    <c:if test="${lshBoardDto.endPage < lshBoardDto.totalPage}">
	                    <li>
	                    	<a class="page" href="${lshBoardDto.endPage + 1}">&gt;</a>
	                    </li>
                    </c:if>
                  </ul>
                </div>
              </div>
            </div>

        <div class="row">
          <div class="col-md-12">
            <div class="site-section site-blocks-2">
                <div class="row justify-content-center text-center mb-5">
                  <div class="col-md-7 site-section-heading pt-4">
                    <h2>Categories</h2>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="">
                    <a class="block-2-item" href="shop?p_main=T">
                      <figure class="image">
                        <img src="../../resources/images/Top.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Top</h3>
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                    <a class="block-2-item" href="shop?p_main=P">
                      <figure class="image">
                        <img src="../../resources/images/Pants.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Pants</h3>
                      </div>
                    </a>
                  </div>
                  <div class="col-sm-6 col-md-6 col-lg-3 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="200">
                    <a class="block-2-item" href="shop?p_main=S">
                      <figure class="image">
                        <img src="../../resources/images/Shoes.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Shoes</h3>
                      </div>
                    </a>
                  </div>
                  
                  <div class="col-sm-6 col-md-6 col-lg-3 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="200">
                    <a class="block-2-item" href="shop?p_main=A">
                      <figure class="image">
                        <img src="../../resources/images/Acc.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <span class="text-uppercase">Collections</span>
                        <h3>Acc</h3>
                      </div>
                    </a>
                  </div>
                  
                </div>
              
            </div>
          </div>
        </div>
        
      </div>
    </div>

<%@ include file="../include/foot.jsp" %>