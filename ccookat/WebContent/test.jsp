<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<html lang="zxx">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>login</title>

<script type="text/javascript" src="/ccookat/Data/style/js/customer.js"></script>

<link href="/ccookat/Data/style/img/ccookat/favicon.ico"
	rel="shortcut icon" type="image/x-icon">
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&amp;display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="/ccookat/Data/style/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/elegant-icons.css"	type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/jquery-ui.min.css"	type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/login.css"	type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/style.css"	type="text/css">
<link rel="stylesheet" href="/ccookat/Data/style/css/qna.css"	type="text/css">

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
			<a href="#"><img
				src="/ccookat/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i><span>${cartCount }</span></a></li>
			</ul>
			<div class="header__cart__price"></div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img class="korean" src="/ccookat/Data/style/img/ccookat/korean.jpg"
					alt="">
				<div>?????????</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">?????????</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<div class="header__top__right__auth">
				<a href="#"><i class="fa fa-user"></i>Login</a>
			</div>
		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li><a href="<%=cp%>/main">Home</a></li>
				<li><a href="<%=cp%>/main/item/list.do">Shop</a></li>
				<li><a href="<%=cp%>/main/notice/list.do">NOTICE</a></li>
				<li><a href="<%=cp%>/main/notice/info.do">INFO</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap">
			<div class="slicknav_menu">
				<a href="#" aria-haspopup="true" role="button" tabindex="0"
					class="slicknav_btn slicknav_collapsed" style="outline: none;">
					<span class="slicknav_menutxt">MENU</span> 
					<span class="slicknav_icon"><span class="slicknav_icon-bar"></span></span>
					<span class="slicknav_icon-bar"></span> 
					<span class="slicknav_icon-bar"></span>
				</a>
				<nav class="slicknav_nav slicknav_hidden" aria-hidden="true"
					role="menu" style="display: none;">
					<ul>
						<li><a href="./index.html" role="menuitem">Home</a></li>
						<li><a href="./shop-grid.html" role="menuitem">Shop</a></li>

						<li class="slicknav_collapsed slicknav_parent">
							<a href="#" role="menuitem" aria-haspopup="true" tabindex="-1"
							class="slicknav_item slicknav_row" style="outline: none;">
								<a href="#">Pages</a> 
								<span class="slicknav_arrow">???</span>
							</a>
							<ul class="header__menu__dropdown slicknav_hidden" role="menu"
								aria-hidden="true" style="display: none;">
								<li>
	 								<a href="./shop-details.html" role="menuitem"
									tabindex="-1">Shop Details</a>
								</li>
								<li>
									<a href="./shoping-cart.html" role="menuitem"
									tabindex="-1">Shopping Cart</a>
								</li>
								<li>
									<a href="./checkout.html" role="menuitem" tabindex="-1">
									Check Out</a>
								</li>
							</ul>
						</li>
						
						<li><a href="./contact.html" role="menuitem">Contact</a></li>
					</ul>
				</nav>
			</div>
		</div>
		
		<div class="header__top__right__social">
			<a href="https://www.facebook.com" target="_blank">
				<i class="fa fa-facebook"></i></a> 
			<a href="https://twitter.com" target="_blank">
				<i class="fa fa-twitter"></i></a> 
			<a href="https://www.instagram.com" target="_blank">
				<i class="fa fa-instagram"></i></a> 
			<a href="https://www.pinterest.co.kr" target="_blank">
				<i class="fa fa-pinterest-p"></i></a>
		</div>
		
		<div class="humberger__menu__contact">
			<ul>
				<a href="https://mail.google.com/mail" target="_blank">
					<li><i class="fa fa-envelope"></i> ccookat@gmail.com</li>
				</a>
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
								<a href="https://mail.google.com/mail" target="_blank">
									<li><i class="fa fa-envelope"></i> ccookat@gmail.com</li>
								</a>
							</ul>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="https://www.facebook.com" target="_blank">
									<i class="fa fa-facebook"></i></a> 
								<a href="https://twitter.com" target="_blank">
									<i class="fa fa-twitter"></i></a> 
								<a href="https://www.instagram.com" target="_blank">
									<i class="fa fa-instagram"></i></a> 
								<a href="https://www.pinterest.co.kr" target="_blank">
									<i class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="/ccookat/Data/style/img/ccookat/korean.jpg" alt="">
								<div>?????????</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">?????????</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
							<c:if test="${empty sessionScope.customerInfo.customerId}">
								<div class="header__top__right__auth">
									<a href="<%=cp%>/main/customer/login.do">
										<i class="fa fa-user"></i> Login
									</a>
								</div>
								<div class="header__top__right__auth">
									<a href="<%=cp%>/main/customer/created.do">
									<i class="fa fa-user"></i> Join
									</a>
								</div>
							</c:if>
							<c:if test="${!empty sessionScope.customerInfo.customerId}">
								<div class="header__top__right__auth">
									<a href="<%=cp%>/main/customer/customerPwdChk.do">
									<i class="fa fa-user"></i> Mypage
									</a>
								</div>
								<div class="header__top__right__auth">
									<a href="<%=cp%>/main/customer/logout.do">
									<i class="fa fa-user"></i> Logout
									</a>
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
						<a href="<%=cp%>/main">
						<img src="/ccookat/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="<%=cp%>/main">Home</a></li>
							<li><a href="<%=cp%>/main/item/list.do">Shop</a></li>
							<li><a href="<%=cp%>/main/notice/list.do">NOTICE</a></li>
							<li><a href="<%=cp%>/main/notice/info.do">INFO</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li>
								<a href="#"><i class="fa fa-heart"></i> </a>
							</li>
							<li>
								<a href="#"><i class="fa fa-shopping-bag"></i> <span>${itemCount }</span></a>
							</li>
						</ul>
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
							<i class="fa fa-bars"></i> <span>????????????</span>
						</div>
						<ul>
							<li><a href="<%=cp%>/main/item/list.do">????????????</a></li>
							<li><a href="<%=cp%>/main/item/list.do">???????????????</a></li>
							<li><a href="<%=cp%>/main/item/list.do">???????????????</a></li>
							<li><a href="<%=cp%>/main/item/list.do">???????????????</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									????????? <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="????????? ???????????????">
								<button type="submit" class="site-btn">????????????</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-truck"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>ccookat delivery</h5>
								<span> ???????????? ??????</span>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->


	<!-- Checkout Section Begin -->
	<div class="col-lg-12">
		<div class="product__details__tab">
			<ul class="nav nav-tabs" role="tablist">
				<li class="nav-item">
					<a class="nav-link" data-toggle="tab" style="margin-left: 10px;"
					href="#tabs-1" role="tab" aria-selected="false">???????????? ??????</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" style="margin-right: 10px;"
					data-toggle="tab" href="#tabs-2" role="tab" aria-selected="true">????????????</a>
				</li>
			</ul>
			<div class="tab-content">
				<!-- ?????????????????? -->
				<div class="tab-pane" id="tabs-1" role="tabpanel" align="center">
					<div class="product__details__tab__desc">
						<form action="" method="post" name="myForm">
							<div id="login-name">??????????????????</div>
							<input type="password" name="customerPwd" class="text-field"
								placeholder="??????????????? ??????????????????">
							<div style="margin-bottom: 15; margin-top: 15;">
								<font style="font-weight: normal; color: #FF5833"> </font>
							</div>
							<div>
								<input type="button" value=" ?????? " class="btn1" onclick="customerPwdChk();">
							</div>
						</form>
					</div>
				</div>
				<!-- ??????????????? ??? -->

				<!-- ??????????????? ?????? -->
				<div class="tab-pane active" id="tabs-2" role="tabpanel" align="center">
					<div class="product__details__tab__desc">
						<div id="login-name">????????????</div>
						<table class="qna_table">
							<tbody>
								<tr height="60px">
									<th class="qna_tr_test" width="150">????????????</th>
									<th class="qna_tr_test_center" width="380">????????????</th>
									<th class="qna_tr_test" width="150">????????????</th>
									<th class="qna_tr_test" width="200">????????????</th>
									<th class="qna_tr_test" width="120">????????????</th>
								</tr>
								<tr height="60px">
									<td class="qna_tr_test">1</td>
									<td class="qna_tr_test_center">????????????</td>
									<td class="qna_tr_test">240,000</td>
									<td class="qna_tr_test">2022.08.07</td>
									<td class="qna_tr_test">?????????</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- ??????????????? ??? -->

			</div>
		</div>
	</div>

	<br><br><br><br><br><br>

	<!-- Checkout Section End -->



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
							?????? ????????? ????????????112??? 36<br> OTC?????? -1???, 3??? ??????
						</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_clock_alt"></span>
						<h4>Open time</h4>
						<p>?????? 10:30 - 21:30</p>
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
						<h2 class="tit_cc">??????????????????</h2>
						<div class="cc_view cc_call">
							<h3>
								<span class="tit">6204-9090</span>
							</h3>
							<dl class="list">
								<dt>????????????</dt>
								<dd>AM 10:00 ~ PM 17:00</dd>
							</dl>
						</div>
						<div class="cc_view cc_qna">
							<h3>
								<c:if test="${empty sessionScope.customerInfo.customerId}">
									<a href="<%=cp%>/main/customer/login.do" class="tit">?????? ??????</a>
								</c:if>
								<c:if test="${!empty sessionScope.customerInfo.customerId}">
									<a href="<%=cp%>/main/qna/list.do" class="tit">?????? ??????</a>
								</c:if>
							</h3>
							<dl class="list">
								<dt>24?????? ?????? ??????</dt>
								<dd>???????????? ??????????????? ??????????????? ???????????????????????????.</dd>
							</dl>
						</div>
					</div>
					<div class="company">
						????????? (??????) : ???????????? ccookat <span class="bar">I</span> ????????????????????? :
						123-45-6789 <a class="link">??????????????? ??????</a> <br> ??????????????? : ???
						2018-????????????-01646 ??? <span class="bar">I</span> ???????????????????????????:????????? <br>
						?????? : ?????? ????????? ????????????112??? 36 OTC?????? -1???, 3??? ?????? <span class="bar">I</span>?????????
						????????? ????????? ????????? ?????????<br> ??????????????? : <a class="link">itwill@ccookatcorp.com</a><br>
						???????????? : <a class="link">recruit@ccookatcorp.com</a> <br> ??????:
						000 - 0000 - 0000 <span class="bar">I</span> ????????? : <a class="link">help@ccookatcorp.com</a>
						<br> ???????????? ?????? : <a class="link">ccookatgift@ccookatcorp.com</a>
						<br>

					</div>
				</div>
			</div>
			<div class="footer_indemnification_clause">

				<em class="copy"><p>Copyright ?? itwill ccookat Corp. All
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



</body>
</html>