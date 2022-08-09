<%@page import="java.util.Enumeration"%>
<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>review</title>
    
    <link href="/ccookat/Data/style/img/ccookat/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
 	<link rel="stylesheet" href="<%=cp %>/Data/style/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/login.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/signUp.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="<%=cp %>/Data/style/css/style.css" type="text/css">
    
    <script type="text/javascript" src="<%=cp%>/Data/style/js/item.js"></script>
    <script type="text/javascript">
    
    function cartin() {
    	
    	var f = document.myForm;
    	
    	f.action="<%=cp %>/main/cart/cartin.do";
    	f.submit();
	
	}
    
    </script>
    
</head>

<body>
   <!-- Page Preloder -->
    <div id="preloder" style="display: none;">
        <div class="loader" style="display: none;"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="/ccookat/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> </a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>${cartCount }</span></a></li>
            </ul>
            <div class="header__cart__price"></div>
        </div>
        <div class="humberger__menu__widget">
             <div class="header__top__right__language">
                <img class="korean" src="/ccookat/Data/style/img/ccookat/korean.jpg" alt="">
                <div>한국어</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">한국어</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </div>
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> Login</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
			<li><a href="<%=cp%>/main">Home</a></li>
			<li><a href="<%=cp %>/main/item/list.do">Shop</a></li>
		 	<li><a href="<%=cp %>/main/notice/list.do">NOTICE</a></li>
			<li><a href="<%=cp%>/contact.jsp">INFO</a></li>
			</ul>
        </nav>
        <div id="mobile-menu-wrap">
        <div class="slicknav_menu">
        <a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;">
        <span class="slicknav_menutxt">MENU</span>
        <span class="slicknav_icon"><span class="slicknav_icon-bar"></span></span>
        <span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></a>
        <nav class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
            <ul>
                <li><a href="./index.html" role="menuitem">Home</a></li>
                <li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
                <li class="slicknav_collapsed slicknav_parent"><a href="#" role="menuitem" aria-haspopup="true" tabindex="-1" class="slicknav_item slicknav_row" style="outline: none;"><a href="#">Pages</a>
                    <span class="slicknav_arrow">►</span></a><ul class="header__menu__dropdown slicknav_hidden" role="menu" aria-hidden="true" style="display: none;">
                        <li><a href="./shop-details.html" role="menuitem" tabindex="-1">Shop Details</a></li>
                        <li><a href="./shoping-cart.html" role="menuitem" tabindex="-1">Shopping Cart</a></li>
                        <li><a href="./checkout.html" role="menuitem" tabindex="-1">Check Out</a></li>
                    </ul>
                </li>
                <li><a href="./contact.html" role="menuitem">Contact</a></li>
            </ul>
        </nav></div></div>
        <div class="header__top__right__social">
            <a href="https://www.facebook.com" target="_blank"><i class="fa fa-facebook"></i></a>
			<a href="https://twitter.com" target="_blank"><i class="fa fa-twitter"></i></a> 
			<a href="https://www.instagram.com" target="_blank"><i class="fa fa-instagram"></i></a>
			<a href="https://www.pinterest.co.kr" target="_blank"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
			<a href="https://mail.google.com/mail" target="_blank">
			<li><i class="fa fa-envelope"></i> ccookat@gmail.com</li></a>
			</ul>
        </div>
    </div>
    <!-- Humberger End -->


  <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="header__top__left">
                           		<c:choose>
						<c:when test="${!empty sessionScope.customerInfo.customerName }">
							<ul>
								<li><i class="fa fa-user"></i>${sessionScope.customerInfo.customerName }님 맛있는 쇼핑 하세요.</li>
							</ul>
							</c:when>
							<c:otherwise>
							<ul>
								<li><i class="fa fa-user"></i>회원가입을 하시면 더 다양한 이용이 가능합니다.</li>
							</ul>
							</c:otherwise>
							</c:choose>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                              <a href="https://www.facebook.com" target="_blank"><i class="fa fa-facebook"></i></a>
							  <a href="https://twitter.com" target="_blank"><i class="fa fa-twitter"></i></a> 
							  <a href="https://www.instagram.com" target="_blank"><i class="fa fa-instagram"></i></a>
							  <a href="https://www.pinterest.co.kr" target="_blank"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="/ccookat/Data/style/img/ccookat/korean.jpg" alt="">
                                <div>한국어</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">한국어</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div>
                          <c:if test="${empty sessionScope.customerInfo.customerId}">
									<div class="header__top__right__auth">
									<a href="<%=cp %>/main/customer/login.do"><i class="fa fa-user"></i> Login</a>
									</div>
									<div class="header__top__right__auth">
									<a href="<%=cp %>/main/customer/created.do"><i class="fa fa-user"></i> Join</a>
									</div>
							</c:if>
							<c:if test="${!empty sessionScope.customerInfo.customerId}">
             						<div class="header__top__right__auth">
               						<a href="<%=cp %>/main/customer/customerPwdChk.do"><i class="fa fa-user"></i> Mypage</a>
           						 </div>
           						 <div class="header__top__right__auth">
           						 <a href="<%=cp %>/main/customer/logout.do"><i class="fa fa-user"></i> Logout</a>
           						 </div>
           					 </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      <div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="<%=cp %>/main"><img src="/ccookat/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="<%=cp%>/main">Home</a></li>
							<li><a href="<%=cp %>/main/item/list.do">Shop</a></li>
							<li><a href="<%=cp %>/main/notice/list.do">NOTICE</a></li>
							<li><a href="<%=cp%>/contact.jsp">INFO</a></li>
						</ul>						
					</nav>
				</div>
                <div class="col-lg-3">
                    <div class="header__cart">
						<c:if test="${empty sessionScope.customerInfo.customerId}">
							<ul>
								<li><a href="<%=cp%>/main/customer/login.do"><i
										class="fa fa-heart"></i></a></li>
								<li><a href="<%=cp%>/main/customer/login.do"><i
										class="fa fa-shopping-bag"></i></a></li>
							</ul>
						</c:if>
						<c:if test="${!empty sessionScope.customerInfo.customerId}">
							<ul>
								<li><a href="<%=cp%>/main/cart/list.do"><i
										class="fa fa-heart"></i></a></li>
								<li><a href="<%=cp%>/main/cart/list.do"><i
										class="fa fa-shopping-bag"></i> <span>${cartCount }</span></a></li>
							</ul>
						</c:if>
						<div class="header__cart__price"></div>
					</div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
							<i class="fa fa-bars"></i> 
							<span>카테고리</span>
						</div>
                        <ul>
                          <li><a href="<%=cp %>/main/item/list.do">전체상품</a></li>
						  <li><a href="<%=cp %>/main/item/list.do">채소ㆍ과일</a></li>
						  <li><a href="<%=cp %>/main/item/list.do">밥ㆍ빵ㆍ면</a></li>
						  <li><a href="<%=cp %>/main/item/list.do">정육ㆍ계란</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    제품명
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="제품명 입력하세요">
                                <button type="submit" class="site-btn">검색하기</button>
                            </form>
                        </div>
                       <div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-truck"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>ccookat delivery</h5>
								<span> 샛별ㆍ낮 배송</span>
							</div>
						</div>
                    
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="<%=cp %>/Data/style/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>${idto.itemType}</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

<!-- 상품대표사진, 밑에 뜨는 사진들, 제품명, 가격 등등 정보 시작 -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="${itemImagePath }/${idto.itemImage1}">
                        </div>
                        <div class="product__details__pic__slider owl-carousel">

                            <img src="${itemImagePath }/${idto.itemImage1}" style="height: 120px; width: 120px;">
                            <img src="${itemImagePath }/${idto.itemImage2}" style="height: 120px; width: 120px;">
                            <img src="${itemImagePath }/${idto.itemImage3}" style="height: 120px; width: 120px;">

                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${idto.itemName }</h3>
                  		  조회수:${idto.itemHitCount }
                  		   <c:if test="${ sessionScope.customerInfo.customerId=='admin'}">
                  		  <c:choose>
						<c:when test="${pageNum==null}">
                        <a href="${itemDeletePath }?itemNum=${idto.itemNum}">[삭제]</a>
                        </c:when>
                        <c:otherwise>
                        <a href="${itemDeletePath }?itemNum=${idto.itemNum}&pageNum=${currentPage}&itemType=${itemType}">[삭제]</a>
                        </c:otherwise>
                        </c:choose>
						</c:if>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <span>(${reviewtotalArticle } reviews)</span>
                        </div>
                        
                        <div class="product__details__price">
                        <span><fmt:formatNumber value="${idto.itemPrice * (1-0.01*idto.itemDiscount)}" pattern=""/>원</span>
                        <span style="font-size: 12pt; color: #707070; font-weight: lighter; text-decoration: line-through;"><fmt:formatNumber value="${idto.itemPrice }" pattern=""/>원</span>
                                            
                        </div>                        
                        
                        <p>${idto.itemContent }</p>
                        <form action="<%=cp %>/main/cart/cartin.do" name="myForm" method="post">
                        <div class="product__details__quantity">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <input type="text" value="1" name="cartItemCount">
                                </div>
                            </div>
                        </div>
                        <input type="hidden" value="${idto.itemPrice * (1-0.01*idto.itemDiscount)}" name="itemPrice">
                        <input type="hidden" name="itemNum" value="${idto.itemNum}">
                        <input type="hidden" name="itemType" value="${itemType}"/> 
                        <a class="primary-btn" onclick="cartin();" style="cursor: hand; color: white; ">장바구니 넣기</a>
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
						</form>
                        <ul>
                            <li><b>Availability</b> <span>${idto.itemStock }개</span></li>
                            <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li>
                            <li><b>Weight</b> <span>0.5 kg</span></li>
                            <li><b>Share on</b>
                                <div class="share">
                                  <a href="https://www.facebook.com" target="_blank"><i class="fa fa-facebook"></i></a>
							 	  <a href="https://twitter.com" target="_blank"><i class="fa fa-twitter"></i></a> 
							      <a href="https://www.instagram.com" target="_blank"><i class="fa fa-instagram"></i></a>
							      <a href="https://www.pinterest.co.kr" target="_blank"><i class="fa fa-pinterest-p"></i></a>
                         
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
<!-- 상품대표사진, 밑에 뜨는 사진들, 제품명, 가격 등등 정보 시작 -->
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">상품 설명</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">상품 리뷰</a>
                            </li>
                            <%-- <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"

                                    aria-selected="false">상품 리뷰<span>${reviewtotalArticle}</span></a>

                            </li> --%>
                        </ul>
                        <div class="tab-content">
<!-- 상품설명창 시작 -->                       
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>상품 설명</h6>
                                    <p>${idto.itemContent }</p>
                                    <p align="center"><img src="${itemImagePath }/${idto.itemImage4}" style="width: 600px;"></p>
                                </div>
                            </div>
<!-- 상품설명창 끝 -->                       
                            
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>상품 리뷰</h6>
                                    <p></p>


									<form action="" method="post">

										<c:if test="${!empty sessionScope.customerInfo.customerId}">
											<div>
												<input type="button" class="btn2" value=리뷰등록
													onclick="location='/ccookat/main/review/created.do?itemNum=${idto.itemNum}';">
											</div>
										</c:if>


										<c:forEach var="rdto" items="${reviewlists}">
												<div>
													<div style="border-bottom: 1px solid #d5d5d5;">
														<div class="product__details__tab__desc">
															<b>작성자 :&nbsp;</b>${rdto.customerId}
															<b>작성일 :&nbsp;</b>${rdto.reviewCreated}
														</div>
														<div align="right"></div>
														<div class="product__details__tab__desc">
															${rdto.reviewTitle}</div>
														<c:if test="${rdto.reviewImage!=null}">
															<div>
																<img src="${reviewImagePath }/${rdto.reviewImage }"
																	height="200" width="200" /> ${rdto.reviewContent}
															</div>
														</c:if>
														<c:if test="${rdto.reviewImage==null}">
															<div class="product__details__tab__desc">
																${rdto.reviewContent}</div>
														</c:if>
														<div style="text-align: right;">
															<input type="hidden" name="reviewNum"
																value="${rdto.reviewNum}" /> 
																<input type="hidden"name="pageNum" value="${pageNum}"/>
																<input type="hidden"name="itemNum" value="${itemNum}"/>
																   <input type="hidden" name="itemType" value="${itemType}"/> 
															<c:if
																test="${sessionScope.customerInfo.customerId==rdto.customerId}">
																<div class="blog__sidebar__item__tags">
																						<a
																		href="<%=cp %>/main/review/updated.do?reviewNum=${rdto.reviewNum}
																		&itemNum=${idto.itemNum}">
																		수정하기</a> <a
																		href="<%=cp %>/main/review/deleted.do?reviewNum=${rdto.reviewNum}
																		&itemNum=${idto.itemNum}">
																		삭제하기</a>
															</c:if>


															<c:if
																test="${sessionScope.customerInfo.customerId=='admin'}">
																<div class="blog__sidebar__item__tags">
																	<a
																		href="<%=cp %>/main/review/deleted.do?reviewNum=${rdto.reviewNum}
																		&itemNum=${idto.itemNum}">
																		삭제하기</a>
																		
																</div>
															</c:if>

														</div>
													</div>
												</div>

										</c:forEach>
									</form>

									<%-- <div class="product__pagination">${reviewPageIndexList} 
									<a href="#"><i class="fa fa-long-arrow-right"></i></a>
									</div> --%>
								</div>
							</div>

                             	
						</div> 
					</div>
				</div>
			</div>
		</div>
      
    </section>
    <!-- Product Details Section End -->

    <!-- Related Product Section Begin -->
    <section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>관련 상품</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            
            	<c:forEach var="idto" items="${itemHitCountList }" begin="0" end="3">
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${itemImagePath }/${idto.itemImage1}"
                        onclick="location.href='<%=cp %>/main/item/detail.do?itemType=${idto.itemType}&itemNum=${idto.itemNum}';">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">${idto.itemName }</a></h6>
                            <h5><fmt:formatNumber value="${idto.itemPrice * (1-0.01*idto.itemDiscount)}" pattern="0"/>원</h5>
                             <span style="font-size: small; color: #707070; text-decoration: line-through;">${idto.itemPrice }원</span>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <br><br><br><br>
    <!-- Related Product Section End -->

  <!-- Footer Section Begin -->
    <section class="contact spad footer-details">

		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_phone"></span>
						<h4>Call Center</h4>
						<p>+02-6204-9090</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_pin_alt"></span>
						<h4>Address</h4>
						<p>
							서울 강남구 영동대로112길 36<br> OTC빌딩 -1층, 3층 꾸캣
						</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_clock_alt"></span>
						<h4>Open time</h4>
						<p>매일 10:30 - 21:30</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_mail_alt"></span>
						<h4>Email</h4>
						<p>ccookat@gmail.com</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div id="footer">
		<div class="footer-top">
			<div class="inner_footer">
				<div class="footer_cc">
					<div>
						<h2 class="tit_cc">고객행복센터</h2>
						<div class="cc_view cc_call">
							<h3>
								<span class="tit">6204-9090</span>
							</h3>
							<dl class="list">
								<dt>고객센터</dt>
								<dd>AM 10:00 ~ PM 17:00</dd>
							</dl>
						</div>
						<div class="cc_view cc_qna">
							<h3>
								<c:if test="${empty sessionScope.customerInfo.customerId}">
									<a href="<%=cp %>/main/customer/login.do" class="tit">질문 답변</a>
								</c:if>
								<c:if test="${!empty sessionScope.customerInfo.customerId}">
									<a href="<%=cp %>/main/qna/list.do" class="tit">질문 답변</a>
								</c:if>
							</h3>
							<dl class="list">
								<dt>24시간 접수 가능</dt>
								<dd>고객센터 운영시간에 순차적으로 답변해드리겠습니다.</dd>
							</dl>
						</div>
					</div>
					<div class="company">
						법인명 (상호) : 주식회사 ccookat 
						<span class="bar">I</span> 
						사업자등록번호 : 123-45-6789 <a class="link">사업자정보 확인</a> <br> 
						통신판매업 : 제 2018-서울강남-01646 호 <span class="bar">I</span> 개인정보보호책임자:정민정 <br>
						주소 : 서울 강남구 영동대로112길 36 OTC빌딩 -1층, 3층 꾸캣 
						<span class="bar">I</span>정민정 안시연 전은지 윤서혜 이은지<br> 
						마케팅제휴 : <a class="link">itwill@ccookatcorp.com</a><br> 
						채용문의 : <a class="link">recruit@ccookatcorp.com</a> <br>
						팩스: 000 - 0000 - 0000 <span class="bar">I</span> 
						이메일 : <a class="link">help@ccookatcorp.com</a> <br> 
						대량주문 문의 : <a class="link">ccookatgift@ccookatcorp.com</a> <br>

					</div>
				</div>
			</div>
			<div class="footer_indemnification_clause">

				<em class="copy"><p>Copyright © itwill ccookat Corp. All
						rights reserved.</p></em>
			</div>
		</div>
	</div>
	<!-- Footer Section End -->


    <!-- Js Plugins -->
    <script src="<%=cp %>/Data/style/js/jquery-3.3.1.min.js"></script>
    <script src="<%=cp %>/Data/style/js/bootstrap.min.js"></script>
    <script src="<%=cp %>/Data/style/js/jquery.nice-select.min.js"></script>
    <script src="<%=cp %>/Data/style/js/jquery-ui.min.js"></script>
    <script src="<%=cp %>/Data/style/js/jquery.slicknav.js"></script>
    <script src="<%=cp %>/Data/style/js/mixitup.min.js"></script>
    <script src="<%=cp %>/Data/style/js/owl.carousel.min.js"></script>
    <script src="<%=cp %>/Data/style/js/main.js"></script>


</body>
</html>