<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<a id="TopButton" class="ScrollButton"><img src="../../resources/images/scroll_up.png" alt="스크롤-업!"></a>
<a id="BottomButton" class="ScrollButton"><img src="../../resources/images/scroll_down.png" alt="스크롤-다운!"></a>

    <footer class="site-footer border-top">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 mb-5 mb-lg-0">
            <div class="row">
              <div class="col-md-12">
                <h3 class="footer-heading mb-4">LIMO MOE</h3>
              </div>
              <div class="col-md-6 col-lg-4">
                <ul class="list-unstyled">
                 <!--  <li><a href="#">Sell online</a></li>
                  <li><a href="#">Features</a></li> -->
                  <!-- <li><a href="#">Shopping cart</a></li> -->
                 <!--  <li><a href="#">Store builder</a></li> -->
                </ul>
              </div>
              <div class="col-md-6 col-lg-4">
                <ul class="list-unstyled">
                 <!--  <li><a href="#">Mobile commerce</a></li>
                  <li><a href="#">Dropshipping</a></li>
                  <li><a href="#">Website development</a></li> -->
                </ul>
              </div>
              <div class="col-md-6 col-lg-4">
                <ul class="list-unstyled">
                  <!-- <li><a href="#">Point of sale</a></li>
                  <li><a href="#">Hardware</a></li>
                  <li><a href="#">Software</a></li> -->
                 
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
            <h3 class="footer-heading mb-4">모든 상품은 직수입 정품입니다</h3>
            <a href="#" class="block-6">
              <img src="../../resources/images/footBmp.jpg" alt="Image placeholder" class="img-fluid rounded mb-4">
              <h3 class="font-weight-light  mb-0">통관의 관세는 물건 가격에 포함이 되어 있습니다</h3>
              <p>배송비 무료 & 추가비용은 없습니다</p>
            </a>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="block-5 mb-5">
              <h3 class="footer-heading mb-4">company</h3>
              <ul class="list-unstyled">
                <li class="address">19-3 Banpo-dong, Seocho-gu, Seoul</li>
                <li class="phone"><a href="tel://02-1234-1234">02-1234-1234</a></li>
                <li class="email">aoyamamin@gmail.com</li>
              </ul>
            </div>

            <div class="block-7">
              <form action="#" method="post">
                <label for="email_subscribe" class="footer-heading">Q&A</label>
                <div class="form-group">
                 <p>문의 하기</p>
                  <a href="/jm/jm_contact" class="btn btn-sm btn-primary" >이동</a>
                </div>
                 <c:choose>
                  	<c:when test="${sessionScope.u_grade =='gold'}">
                  		<li><a href="/manager/manager_main">Manager page</a></li>
                  	</c:when>
                  </c:choose>
              </form>
            </div>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
<!--             Copyright &copy;<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a> -->
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
          
        </div>
      </div>
    </footer>
  </div>

  <script src="../../resources/js/jquery-3.3.1.min.js"></script>
  <script src="../../resources/js/jquery-ui.js"></script>
  <script src="../../resources/js/popper.min.js"></script>
  <script src="../../resources/js/bootstrap.min.js"></script>
  <script src="../../resources/js/owl.carousel.min.js"></script>
  <script src="../../resources/js/jquery.magnific-popup.min.js"></script>
  <script src="../../resources/js/aos.js"></script>

  <script src="../../resources/js/main.js"></script>
    
  </body>
</html>