<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Q&A Upload</title>
<link href="<%=cp %>/Data/style/img/ccookat/favicon.ico"
	rel="shortcut icon" type="image/x-icon">
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&amp;display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="<%=cp %>/Data/style/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=cp %>/Data/style/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/login.css"
	type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=cp %>/Data/style/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/signUp.css"
	type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=cp %>/Data/style/css/style.css"
	type="text/css">

<script type="text/javascript">

	function sendIt() {
		
		var f = document.myForm;
		
		str = f.reply.value;
		str = str.trim();
		
		
		if(!str) {
			alert("\n내용을 입력하세요.");
			f.replyContent.focus();
			return;
			
		}
		f.replyContent.value = str;
		
		f.action = "<%=cp%>/main/qna/reply_ok.do";
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
			<a href="#"><img
				src="<%=cp %>/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i></a></li>
			</ul>
			<div class="header__cart__price"></div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img class="korean" src="<%=cp %>/Data/style/img/ccookat/korean.jpg"
					alt="">
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
				<li><a href="./index.html">Home</a></li>
				<li><a href="./shop-grid.html">Shop</a></li>
				<li><a href="#">Pages</a>
					<ul class="header__menu__dropdown">
						<li><a href="./shop-details.html">Shop Details</a></li>
						<li><a href="./shoping-cart.html">Shopping Cart</a></li>
						<li><a href="./checkout.html">Check Out</a></li>
					</ul></li>
				<li><a href="./contact.html">Contact</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap">
			<div class="slicknav_menu">
				<a href="#" aria-haspopup="true" role="button" tabindex="0"
					class="slicknav_btn slicknav_collapsed" style="outline: none;"><span
					class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span
						class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span
						class="slicknav_icon-bar"></span></span></a>
				<nav class="slicknav_nav slicknav_hidden" aria-hidden="true"
					role="menu" style="display: none;">
					<ul>
						<li><a href="./index.html" role="menuitem">Home</a></li>
						<li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
						<li class="slicknav_collapsed slicknav_parent"><a href="#"
							role="menuitem" aria-haspopup="true" tabindex="-1"
							class="slicknav_item slicknav_row" style="outline: none;">
							<a href="#">Pages</a> <span class="slicknav_arrow">►</span></a>
						<ul class="header__menu__dropdown slicknav_hidden" role="menu"
								aria-hidden="true" style="display: none;">
								<li><a href="./shop-details.html" role="menuitem"
									tabindex="-1">Shop Details</a></li>
								<li><a href="./shoping-cart.html" role="menuitem"
									tabindex="-1">Shoping Cart</a></li>
								<li><a href="./checkout.html" role="menuitem" tabindex="-1">Check
										Out</a></li>
							</ul></li>
						<li><a href="./contact.html" role="menuitem">Contact</a></li>
					</ul>
				</nav>
			</div>
		</div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i
				class="fa fa-instagram"></i></a> <a href="#"><i
				class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<li><i class="fa fa-envelope"></i> ccokat@gmail.com</li>
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
								<li><i class="fa fa-envelope"></i> ccokat@gmail.com</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a> <a href="#"><i
									class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="<%=cp %>/Data/style/img/ccookat/korean.jpg" alt="">
								<div>한국어</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">한국어</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
						
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
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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
							<i class="fa fa-bars"></i> <span>Cateories</span>
						</div>
						<ul>
							<li><a href="#">Vegetables & Fruit</a></li>
							<li><a href="#">Rice & Noodle & Bread</a></li>
							<li><a href="#">Fresh Meat & Egg</a></li>

						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									All Categories <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="검색어를 입력해주세요">
								<button type="submit" class="site-btn">SEARCH</button>
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
	<section class="breadcrumb-section"
		data-setbg="<%=cp %>/Data/style/img/breadcrumb.jpg"
		style="background-image: url(&quot;<%=cp %>/Data/style/img/breadcrumb.jpg&quot;);">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Q&A </h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">
			<div class="checkout__form">
				<h3>1:1 문의 답변하기</h3>
				<br>
				<form action="/ccookat/main/qna/reply_ok.do" method="post" name="myForm">
					<div>
						<div>
						
						<!-- 	<div class="checkout__input">
								<p>
									Title<span>*</span>
								</p>
								<input type="text" name="qnaTitle">
							</div> -->
							
							<div class="checkout__input">
								<p>
									Text<span>*</span>
								</p>
								
								<textarea rows="15" cols="20" name="replyContent"></textarea>
							</div>

							<div class="blog__sidebar__item__tags">
								<input type="hidden" name="qnaNum" value="${qnaNum}">
								<input type="hidden" name="pageNum" value="${pageNum}">
								<input type="hidden" name="customerId" value="${sessionScope.customerInfo.customerId}">
								<input type="submit" value=" 등록하기"> 
								<input type="reset"
									value="다시입력" onclick="document.myForm.subject.focus();" />
								<input type="button" value="작성취소"
									onclick="location='<%=cp%>/main/qna/list.do';" />

							</div>
							
						</div>
							
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- Checkout Section End -->

	<!-- Footer Section Begin1 -->
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
	<!-- Footer Section End1 -->

	<!-- Footer Section Begin2 -->
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
								<a href="index.jsp?folder=qna&category=qna_list" class="tit">질문
									답변</a>
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
						주소 : 서울시 강남구 테헤란로 124 삼원타워 4층 아이티윌 <span class="bar">I</span>정민정
						안시연 이은지 전은지 윤서혜 <br> 마케팅제휴 : <a class="link">itwill@ccookatcorp.com</a>
						<br> 채용문의 : <a class="link">recruit@ccookatcorp.com</a> <br>
						팩스: 000 - 0000 - 0000 <span class="bar">I</span> 이메일 : <a
							class="link">help@ccookatcorp.com</a> <br> 대량주문 문의 : <a
							class="link">ccookatgift@ccookatcorp.com</a> <br>

					</div>
				</div>
			</div>
			<div class="footer_indemnification_clause">
				<em class="copy">
					<p>Copyright © itwill ccookat Corp. All rights reserved.</p>
				</em>
			</div>
		</div>
	</div>
	<!-- Footer Section End2 -->
	
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


