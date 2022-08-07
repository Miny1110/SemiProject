<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<html lang="zxx"><head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ccookat</title>
    
    <link href="/ccookat/Data/style/img/ccookat/favicon.ico"
	rel="shortcut icon" type="image/x-icon">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&amp;display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/ccookat/Data/style/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/style.css" type="text/css">
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
            <a href="#"><img src="/ccookat/Data/style/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="/ccookat/Data/style/img/language.png" alt="">
                <div>English</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </div>
        
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> Login</a>
                <a href="#"><i class="fa fa-user"></i> Join</a>
            </div>
           

        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./shop-grid.html">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./shop-details.html">Shop Details</a></li>
                        <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                        <li><a href="./checkout.html">Check Out</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"><div class="slicknav_menu"><a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;"><span class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></a><nav class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
            <ul>
                <li class="active"><a href="./index.html" role="menuitem">Home</a></li>
                <li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
                <li class="slicknav_collapsed slicknav_parent"><a href="#" role="menuitem" aria-haspopup="true" tabindex="-1" class="slicknav_item slicknav_row" style="outline: none;"><a href="#">Pages</a>
                    <span class="slicknav_arrow">►</span></a><ul class="header__menu__dropdown slicknav_hidden" role="menu" aria-hidden="true" style="display: none;">
                        <li><a href="./shop-details.html" role="menuitem" tabindex="-1">Shop Details</a></li>
                        <li><a href="./shoping-cart.html" role="menuitem" tabindex="-1">Shoping Cart</a></li>
                        <li><a href="./checkout.html" role="menuitem" tabindex="-1">Check Out</a></li>
                        <li><a href="./blog-details.html" role="menuitem" tabindex="-1">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html" role="menuitem">Blog</a></li>
                <li><a href="./contact.html" role="menuitem">Contact</a></li>
            </ul>
        </nav></div><div class="slicknav_menu"><a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;"><span class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></a><nav class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
            <ul>
                <li class="active"><a href="./index.html" role="menuitem">Home</a></li>
                <li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
                <li class="slicknav_collapsed slicknav_parent"><a href="#" role="menuitem" aria-haspopup="true" tabindex="-1" class="slicknav_item slicknav_row" style="outline: none;"></a><a href="#">Pages</a>
                    <span class="slicknav_arrow">►</span><ul class="header__menu__dropdown slicknav_hidden" role="menu" aria-hidden="true" style="display: none;">
                        <li><a href="./shop-details.html" role="menuitem" tabindex="-1">Shop Details</a></li>
                        <li><a href="./shoping-cart.html" role="menuitem" tabindex="-1">Shoping Cart</a></li>
                        <li><a href="./checkout.html" role="menuitem" tabindex="-1">Check Out</a></li>
                        <li><a href="./blog-details.html" role="menuitem" tabindex="-1">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html" role="menuitem">Blog</a></li>
                <li><a href="./contact.html" role="menuitem">Contact</a></li>
            </ul>
        </nav></div><div class="slicknav_menu"><a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;"><span class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></a><nav class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
            <ul>
                <li class="active"><a href="./index.html" role="menuitem">Home</a></li>
                <li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
                <li class="slicknav_collapsed slicknav_parent"><a href="#" role="menuitem" aria-haspopup="true" tabindex="-1" class="slicknav_item slicknav_row" style="outline: none;"></a><a href="#">Pages</a>
                    <span class="slicknav_arrow">►</span><ul class="header__menu__dropdown slicknav_hidden" role="menu" aria-hidden="true" style="display: none;">
                        <li><a href="./shop-details.html" role="menuitem" tabindex="-1">Shop Details</a></li>
                        <li><a href="./shoping-cart.html" role="menuitem" tabindex="-1">Shoping Cart</a></li>
                        <li><a href="./checkout.html" role="menuitem" tabindex="-1">Check Out</a></li>
                        <li><a href="./blog-details.html" role="menuitem" tabindex="-1">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html" role="menuitem">Blog</a></li>
                <li><a href="/contact.html" role="menuitem">Contact</a></li>
            </ul>
        </nav></div></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li>
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
							<ul>
								<li><i class="fa fa-envelope"></i> ccookat@gmail.com</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-instagram"></i></a> <a href="#"><i class="fa fa-pinterest-p"></i></a>
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
							<li><a href="<%=cp %>/main/item/list.do?itemType=fruit">Shop</a></li>
							<li><a href="#">Pages</a>
								<ul class="header__menu__dropdown">
									<li><a href="./shop-details.html">Shop Details</a></li>
									<li><a href="./shoping-cart.html">Shopping Cart</a></li>
									<li><a href="./checkout.html">Check Out</a></li>
								</ul></li>
							<li><a href="<%=cp %>/main/notice/list.do?noticeSearchKey=gongji">Contact</a></li>
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
									<li><a href="<%=cp%>/main/cart/list.do"><i class="fa fa-heart"></i> <span>55</span></a></li>
									<li><a href="<%=cp%>/main/cart/list.do"><i class="fa fa-shopping-bag"></i> <span>장바구니수량</span></a></li>
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
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>카테고리</span>
                        </div>
                       
                              <ul>
                             <li><a href="<%=cp %>/main/item/list.do?itemType=fruit">채소ㆍ과일</a></li>
                            <li><a href="<%=cp %>/main/item/list.do?itemType=bread">밥ㆍ빵ㆍ면</a></li>
                            <li><a href="<%=cp %>/main/item/list.do?itemType=meat">정육ㆍ계란</a></li>
                             <c:if test="${ sessionScope.customerInfo.customerId=='admin'}"	>	
                            <li><a href="<%=cp%>/main/item/created.do"> [상품등록]</a></li>
                            </c:if>
                        </ul>
                       
                    </div>
                </div>
                
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form " >
                            <form action="">
                                <div class="hero__search__categories">
                               항목선택
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <ul>
                             
                            
                        </ul>
                            
                                <input type="text" placeholder="검색어를 입력하세요">
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
                    <div class="hero__item set-bg" style="padding-left: 0">
                    <img src="/ccookat/Data/style/img/banner/event_main.jpg" alt="" align="middle">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
   <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/event_1.jpg">
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/event_2.jpg">
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/event_3.jpg">
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/event_4.jpg">
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/event_5.jpg">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->


    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>인기상품</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">전체상품</li>
                            <li>&nbsp; |</li>
                            <li data-filter=".fruit">채소ㆍ과일</li>
                            <li>&nbsp; |</li>
                            <li data-filter=".bread">밥ㆍ빵ㆍ면</li>
                            <li>&nbsp; |</li>
                            <li data-filter=".meat">정육ㆍ계란</li>
                        </ul>
                    </div>
                </div>
            </div>  
            <div class="row featured__filter">   
            <c:forEach var="idto" items="${mainList }">          
                <div class="col-lg-3 col-md-4 col-sm-6 mix ${idto.itemType }">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="${itemImagePath }/${idto.itemImage1}"
                        style="background-image: url(&quot;${itemImagePath }/${idto.itemImage1}&quot;);"
                        onclick="location.href='${itemDetailUrl }${idto.itemType }&itemNum=${idto.itemNum }';">
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
   
    
    <!-- Featured Section End -->

    <!-- Banner Begin -->
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="/ccookat/Data/style/img/banner/event_banner_1.jpg" alt="" >
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="/ccookat/Data/style/img/banner/event_banner_2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner End -->

    <!-- Latest Product Section Begin -->
    
    <!-- Latest Product Section End -->

    <!-- Blog Section Begin -->
    
    <!-- Blog Section End -->

    <!-- Footer Section Begin -->
    <section class="contact spad footer-details">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_phone"></span>
						<h4>Call Center</h4>
						<p>+02-1234-6868</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_pin_alt"></span>
						<h4>Address</h4>
						<p>
							서울시 강남구 테헤란로 <br>124 삼원타워 4층 아이티윌
						</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_clock_alt"></span>
						<h4>Open time</h4>
						<p>24 hour Open Service</p>
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
						<span class="tit">1234-5678</span>
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
					법인명 (상호) : 주식회사 ccookat <span class="bar">I</span> 사업자등록번호 : 123-45-6789 
					<a class="link">사업자정보 확인</a> 
					<br> 통신판매업 : 제 2018-서울강남-01646 호 
						<span class="bar">I</span>
						개인정보보호책임자:정민정
					<br>
						주소 : 서울시 강남구 테헤란로 124 삼원타워 4층 아이티윌 
						<span class="bar">I</span>정민정 안시연 이은지 전은지 윤서혜
					<br> 마케팅제휴 : <a class="link">itwill@ccookatcorp.com</a>
					<br> 채용문의 : <a class="link">recruit@ccookatcorp.com</a>
					<br> 팩스: 000 - 0000 - 0000 
						<span class="bar">I</span> 
						이메일 : <a class="link">help@ccookatcorp.com</a>
					<br> 대량주문 문의 : <a class="link">ccookatgift@ccookatcorp.com</a> 
					<br>
						
				</div>
			</div>
		</div>
		<div class="footer_indemnification_clause">
		
			<em class="copy"><p>Copyright © itwill ccookat Corp. All rights reserved.</p></em>
		</div>
	</div>
</div>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="/ccookat/Data/style/js/jquery-3.3.1.min.js"></script>
    <script src="/ccookat/Data/style/js/bootstrap.min.js"></script>
    <script src="/ccookat/Data/style/js/jquery.nice-select.min.js"></script>
    <script src="/ccookat/Data/style/js/jquery-ui.min.js"></script>
    <script src="/ccookat/Data/style/js/jquery.slicknav.js"></script>
    <script src="/ccookat/Data/style/js/mixitup.min.js"></script>
    <script src="/ccookat/Data/style/js/owl.carousel.min.js"></script>
    <script src="/ccookat/Data/style/js/main.js"></script>


</body></html>