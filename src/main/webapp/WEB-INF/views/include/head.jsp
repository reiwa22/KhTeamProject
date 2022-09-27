<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

 <% //제이쿼리 
 request.setCharacterEncoding("utf-8");
 String cp = request.getContextPath();
 %>
<style>
.ScrollButton {
  position: fixed;   /* 버튼의 위치 고정 */
  right: 10px;       /* x 위치 입력 */
  cursor: pointer;   /* 호버링 했을 때 커서 모양 변경 */
  z-index: 10;       /* 다른 태그에 가려지지 않게 우선순위 변경 */
}
/* 두 태그에 각각 y 위치 입력 */
#TopButton {
  bottom: 108px;        
}
#BottomButton {
  bottom: 75px;
}
</style>
<script src="<%=cp %>/resources/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#TopButton").click(function() {
	    $('html, body').animate({scrollTop : 0}, 400);
	    return false;
	});
	
	$("#BottomButton").click(function() {
	    $('html, body').animate({scrollTop : $(document).height()  }, 400);
	    return false;
	});
});

</script>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>LIMO MOE &mdash; 최고의 상품</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../resources/css/jquery-ui.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="../../resources/fonts/icomoon/style.css">

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/magnific-popup.css">
    <link rel="stylesheet" href="../../resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../../resources/css/owl.theme.default.min.css">


    <link rel="stylesheet" href="../../resources/css/aos.css">

    <link rel="stylesheet" href="../../resources/css/style.css">
    
  </head>
  <body>
  
  <div class="site-wrap">
    <header class="site-navbar" role="banner">
      <div class="site-navbar-top">
      <div class="" style="float:left;">
    		<a>총 방문객 : <%= session.getAttribute("visitAll") %></a><br>
   			<a>오늘 방문객 : <%= session.getAttribute("visitNow") %></a>
   	  </div>
        <div class="container">
          <div class="row align-items-center">

            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
              <form action="" class="site-block-top-search">
                <span class="icon icon-search2"></span>
                <input type="text" class="form-control border-0" placeholder="Search">
              </form>
            </div>

            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
              <div class="site-logo">
                <a href="/cjh/index" class="js-logo-clone">Limo Moe</a>
              </div>
            </div>

            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
              <div class="site-top-icons">
              
<%--               <c:choose> --%>
<%-- 			<c:when test="${not empty sessionScope.u_id }"> --%>
<%-- 				<p>${sessionScope.u_id}님 로그인중</p> --%>
<!-- 				<a href="/jm/logout" class="btn btn-basic btn-flat">logout</a> -->
<%-- 			</c:when> --%>
<%-- 			<c:otherwise> --%>
<!-- 				<a class="btn btn-default btn-sm" href="/jm/jm_signUp">signUp</a> -->
<!-- 				<a class="btn btn-default btn-sm" href="/jm/jm_login">Login</a> -->
<%-- 			</c:otherwise>		 --%>
<%-- 		</c:choose> --%>
              
                <ul>
                  <c:choose>
		             <c:when test="${not empty sessionScope.u_id}">
		             	<a>${sessionScope.u_id}님 로그인중</a>
		              	<a href="/jm/logout" class="btn btn-basic btn-flat">logout</a>
		             </c:when>
					<c:otherwise>
						<a class="btn btn-default btn-sm" href="/jm/jm_signUp">signUp</a>
		              	<a href="/jm/jm_login" class="btn btn-basic btn-flat">login</a>
		            </c:otherwise>
		          </c:choose>
                  <li><a href="/cjh/mypage"><span class="icon icon-person"></span></a></li>
                  <li><a href="#"><span class="icon icon-heart-o"></span></a></li>
                  <li>
                    <a href="/cjh/cart" class="site-cart">
                      <span class="icon icon-shopping_cart"></span>
                      <c:if test="${not empty sessionScope.u_id}">
                      	<span class="count">${count}</span>
                      </c:if>
                    </a>
                  </li> 
                  <li class="d-inline-block d-md-none ml-md-0"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                </ul>
              </div> 
            </div>

          </div>
        </div>
      </div> 
      
      
      
      
      
      <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
          <ul class="site-menu js-clone-nav d-none d-md-block">
            <li class="has">
              <a href="/cjh/index">Home</a>
              <!-- <ul class="dropdown">
                <li><a href="#">Menu One</a></li>
                <li><a href="#">Menu Two</a></li>
                <li><a href="#">Menu Three</a></li>
                <li class="has-children">
                  <a href="#">Sub Menu</a>
                  <ul class="dropdown">
                    <li><a href="#">Menu One</a></li>
                    <li><a href="#">Menu Two</a></li>
                    <li><a href="#">Menu Three</a></li>
                  </ul>
                </li>
              </ul> -->
            </li>
            <li>
              <a href="/jm/jm_about">About</a>
              <!-- <ul class="dropdown">
                <li><a href="#">Menu One</a></li>
                <li><a href="#">Menu Two</a></li>
                <li><a href="#">Menu Three</a></li>
              </ul> -->
            </li>
            
            <li class="has-children">
           		<a href="/lsh/shop">Shop</a>
           		<ul class="dropdown">
					<li class="has-children">
	                  <a href="/lsh/shop?p_main=T&type=PL&page=1">상의</a>
	                  <ul class="dropdown">
	                    <li><a href="/lsh/shop?p_serve=TH&type=PL&page=1">반팔</a></li>
	                    <li><a href="/lsh/shop?p_serve=TL&type=PL&page=1">긴팔</a></li>
	                    <li><a href="/lsh/shop?p_serve=TS&type=PL&page=1">셔츠</a></li>
	                    <li><a href="/lsh/shop?p_serve=TM&type=PL&page=1">맨투맨</a></li>
	                  </ul>
	                </li>
	                 
	                <li class="has-children">
	                  <a href="/lsh/shop?p_main=P&type=PL&page=1">하의</a>
	                  <ul class="dropdown">
	                    <li><a href="/lsh/shop?p_serve=PJ&type=PL&page=1">청바지</a></li>
	                    <li><a href="/lsh/shop?p_serve=PM&type=PL&page=1">면바지</a></li>
	                    <li><a href="/lsh/shop?p_serve=PH&type=PL&page=1">반바지</a></li>
	                    <li><a href="/lsh/shop?p_serve=P7&type=PL&page=1">7부바지</a></li>
	                  </ul>
	                </li>
	                  
	                <li class="has-children">
					  <a href="/lsh/shop?p_main=S&type=PL&page=1">신발</a>
	                  <ul class="dropdown">
	                    <li><a href="/lsh/shop?p_serve=SD&type=PL&page=1">구두</a></li>
	                    <li><a href="/lsh/shop?p_serve=SU&type=PL&page=1">운동화</a></li>
	                    <li><a href="/lsh/shop?p_serve=SS&type=PL&page=1">슬리퍼</a></li>
	                    <li><a href="/lsh/shop?p_serve=SR&type=PL&page=1">로퍼</a></li>
	                  </ul>
	                </li>
	                  
					<li class="has-children">	                  
	                  <a href="/lsh/shop?p_main=A&type=PL&page=1">악세사리</a>
	                  <ul class="dropdown">
	                    <li><a href="/lsh/shop?p_serve=AR&type=PL&page=1">반지</a></li>
	                    <li><a href="/lsh/shop?p_serve=AW&type=PL&page=1">지갑</a></li>
	                    <li><a href="/lsh/shop?p_serve=AC&type=PL&page=1">모자</a></li>
	                    <li><a href="/lsh/shop?p_serve=AB&type=PL&page=1">가방</a></li>
	                  </ul>
	                </li>
	                
             	</ul>  
            </li>
            
            
            
            
            
            <!-- <li><a href="#">Catalogue</a></li>
            <li><a href="#">New Arrivals</a></li> -->
            <li><a href="/jm/jm_contact">Q&A</a></li>
            <li><a href="/jm/jm_reviewForm">review</a></li>
          </ul>
          
          <div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-7">
		</div>
		<div class="col-md-3">
		
			
		</div>
	</div>
</div>
          
          
          
        </div>
      </nav>
    </header>