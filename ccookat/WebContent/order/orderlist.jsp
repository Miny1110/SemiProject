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
    <title>Order List</title>

	<link href="/ccookat/Data/style/img/ccookat/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&amp;display=swap" rel="stylesheet">

    <!-- Css Styles -->
  	<link rel="stylesheet" href="/ccookat/Data/style/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/login.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/ccookat/Data/style/css/signUp.css" type="text/css">
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
			<li><a href="<%=cp%>/main/notice/info.do">INFO</a></li>
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
									<a href="<%=cp %>/main/customer/login.do"><i
										class="fa fa-user"></i> Login</a>
								</div>
								<div class="header__top__right__auth">
									<a href="<%=cp %>/main/customer/created.do"><i
										class="fa fa-user"></i> Join</a>
								</div>
							</c:if>
							<c:if test="${!empty sessionScope.customerInfo.customerId}">
								<div class="header__top__right__auth">
									<a href="<%=cp %>/main/customer/customerPwdChk.do"><i
										class="fa fa-user"></i> Mypage</a>
								</div>
								<div class="header__top__right__auth">
									<a href="<%=cp %>/main/customer/logout.do"><i
										class="fa fa-user"></i> Logout</a>
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
						<a href="<%=cp %>/main"><img
							src="/ccookat/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="<%=cp%>/main">Home</a></li>
							<li><a href="<%=cp %>/main/item/list.do">Shop</a></li>
							<li><a href="<%=cp %>/main/notice/list.do">NOTICE</a></li>
							<li><a href="<%=cp%>/main/notice/info.do">INFO</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<c:if test="${empty sessionScope.customerInfo.customerId}">
							<ul>
								<li><a href="<%=cp%>/main/customer/login.do"><i
										class="fa fa-heart"></i></a></li>
								<li><a href="#"><i class="fa fa-shopping-bag"></i><span>${cartCount }</span></a></li>
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
							<li><a href="<%=cp %>/main/item/list.do?itemType=fruit">채소ㆍ과일</a></li>
							<li><a href="<%=cp %>/main/item/list.do?itemType=bread">밥ㆍ빵ㆍ면</a></li>
							<li><a href="<%=cp %>/main/item/list.do?itemType=meat">정육ㆍ계란</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
					<div class="hero__search">
					<div class="hero__search__form">
                            <form action="<%=cp%>/main/item/list.do">
                                <div class="hero__search__categories">
                                    제품명
                                    
                                </div>
                                <input type="text" placeholder="제품명 입력하세요" name="itemSearchValue">
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
    <section class="breadcrumb-section" data-setbg="/ccookat/Data/style/img/breadcrumb.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/breadcrumb.jpg&quot;);">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>ORDER</h2>
                        <div class="breadcrumb__option">
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
       <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>상품</th>
                                    <th>가격</th>
                                    <th>할인가</th>
                                    <th>수량</th>
                                    <th>총금액</th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
 							<c:choose>       
 							<c:when test="${empty lists }">
 							<tr><td colspan="6">${message }</td></tr>
 							</c:when>
 							<c:otherwise>                
                            <c:forEach var="ctdto" items="${lists }">
                            <c:set var="totalprice" value="${totalprice + ctdto.cartTotPrice}"/>
                            <c:set var="beforedc" value="${beforedc + ctdto.itemPrice*ctdto.cartItemCount}"/>
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img src="${itemImagePath }/${ctdto.itemImage1}" alt="" width="100px" height="100px">
                                        <h5>${ctdto.itemName}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                    <fmt:formatNumber value="${ctdto.itemPrice*ctdto.cartItemCount }" pattern="0"/>원                            
                                    </td>
                                        <td class="shoping__cart__price">
                                    ${(ctdto.itemPrice*ctdto.cartItemCount)-ctdto.cartTotPrice}                               
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                                <input type="text" value="${ctdto.cartItemCount}" readonly="readonly" style="text-align: center; border: 0;"/>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                            ${ctdto.cartTotPrice }
                                    </td>
                                </tr>
                                </c:forEach> 
                                </c:otherwise>   
                                </c:choose>                               
                            </tbody>                         
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="<%=cp %>/main/item/list.do" class="primary-btn cart-btn cart-btn-right">쇼핑 계속하기</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                    
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->
    <!-- Blog Section Begin -->
    <section class="checkout spad">
       <form action="<%=cp%>/main/order/order_ok.do">
        <div class="container">         
            <div class="checkout__form_order">
                <h3>주문하기</h3>           
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="checkout__input order_box_size">
                               <p>이름<span>*</span></p>
                            <input type="text" value="${sessionScope.customerInfo.customerName }" name="customerOrderName"/>
                            </div>
                            <div class="checkout__input order_box_size">
                                 <p>전화번호<span>*</span></p>
                                 <input type="text" value="${cdto.customerTel }" name="customerOrderTel"/>
                            </div>
                            <div class="checkout__input order_box_size">
                                <p> 우편번호<span>*</span></p>
                                <input type="text" value="${cdto.customerZipcode }" name="customerOrderZipCode"/>
                            </div>
                            <div class="checkout__input order_box_size">
                                <p>주소<span>*</span></p>
                                <input type="text" value="${cdto.customerAddr1}" name="customerOrderAddr1"/>
                            </div>
                            <div class="checkout__input order_box_size">
                                <p>상세주소<span>*</span></p>
                                <input type="text" value="${cdto.customerAddr2}" name="customerOrderAddr2">
                            </div>
                            <div class="checkout__input order_box_size">
                                <p>배송메모<span>*</span></p>
                                <input type="text" name="customerMemo">
                            </div>
                            <div class="checkout__input checkout__input">
                            	<p>결제방법<span>*</span></p>
                            </div>
                            <div class="checkout__input__checkbox">
                                <label for="acc" style="padding-right: 20px;">
                                    현금결제
                                    <input type="radio" id="acc" value="현금결제" name="customerOrderPay">
                                    <span class="checkmark"></span>
                                 </label>
                                 <label for="diff-acc">카드결제<input type="radio" id="diff-acc"  value="카드결제" name="customerOrderPay">
                                    <span class="checkmark"></span>
                                </label>
                            </div>                                                    
                            <div class="checkout__input order_box_size">                             
                                <input type="text" placeholder="카드번호를 입력해주세요">
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4>주문하기</h4>
                                <div class="checkout__order__total">총가격 <span> ${totalprice} </span></div>
                
                                <div class="checkout__input__checkbox">
                                    <label for="payment">
                                        Check Payment
                                        <input type="checkbox" id="payment">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                           		<input type="hidden" value="${totalprice}" name="customerOrderPrice"/>
                                <button type="submit" class="site-btn">주문하기</button>
                            </div>
                        </div>
                    </div>
          	  	</div>
        	</div>
         </form> 	
    </section> 
    <br><br><br><br><br>
    <!-- Blog Section End -->
    

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
						법인명 (상호) : 주식회사 ccookat <span class="bar">I</span> 사업자등록번호 :
						123-45-6789 <a class="link">사업자정보 확인</a> <br> 통신판매업 : 제
						2018-서울강남-01646 호 <span class="bar">I</span> 개인정보보호책임자:정민정 <br>
						주소 : 서울 강남구 영동대로112길 36 OTC빌딩 -1층, 3층 꾸캣 <span class="bar">I</span>정민정
						안시연 전은지 윤서혜 이은지<br> 마케팅제휴 : <a class="link">itwill@ccookatcorp.com</a><br>
						채용문의 : <a class="link">recruit@ccookatcorp.com</a> <br> 팩스:
						000 - 0000 - 0000 <span class="bar">I</span> 이메일 : <a class="link">help@ccookatcorp.com</a>
						<br> 대량주문 문의 : <a class="link">ccookatgift@ccookatcorp.com</a>
						<br>

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
    <script src="/ccookat/Data/style/js/jquery-3.3.1.min.js"></script>
    <script src="/ccookat/Data/style/js/bootstrap.min.js"></script>
    <script src="/ccookat/Data/style/js/jquery.nice-select.min.js"></script>
    <script src="/ccookat/Data/style/js/jquery-ui.min.js"></script>
    <script src="/ccookat/Data/style/js/jquery.slicknav.js"></script>
    <script src="/ccookat/Data/style/js/mixitup.min.js"></script>
    <script src="/ccookat/Data/style/js/owl.carousel.min.js"></script>
    <script src="/ccookat/Data/style/js/main.js"></script>





</body></html>