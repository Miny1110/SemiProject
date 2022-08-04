<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>qnaMain</title>

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
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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
				<li><a href="./index.html">Home</a></li>
				<li><a href="./shop-grid.html">Shop</a></li>
				<li><a href="#">Pages</a>
					<ul class="header__menu__dropdown">
						<li><a href="./shop-details.html">Shop Details</a></li>
						<li><a href="./shoping-cart.html">Shoping Cart</a></li>
						<li><a href="./checkout.html">Check Out</a></li>
					</ul></li>
				<li><a href="./contact.html">Contact</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"><div class="slicknav_menu"><a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;"><span class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></a><nav class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
			<ul>
				<li><a href="./index.html" role="menuitem">Home</a></li>
				<li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
				<li class="slicknav_collapsed slicknav_parent"><a href="#" role="menuitem" aria-haspopup="true" tabindex="-1" class="slicknav_item slicknav_row" style="outline: none;"><a href="#">Pages</a>
					<span class="slicknav_arrow">►</span></a><ul class="header__menu__dropdown slicknav_hidden" role="menu" aria-hidden="true" style="display: none;">
						<li><a href="./shop-details.html" role="menuitem" tabindex="-1">Shop Details</a></li>
						<li><a href="./shoping-cart.html" role="menuitem" tabindex="-1">Shoping Cart</a></li>
						<li><a href="./checkout.html" role="menuitem" tabindex="-1">Check Out</a></li>
					</ul></li>
				<li><a href="./contact.html" role="menuitem">Contact</a></li>
			</ul>
		</nav></div>
			<div class="slicknav_menu">
				<a href="#" aria-haspopup="true" role="button" tabindex="0" class="slicknav_btn slicknav_collapsed" style="outline: none;"><span class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span><span class="slicknav_icon-bar"></span></span></a>
				<nav class="slicknav_nav slicknav_hidden" aria-hidden="true" role="menu" style="display: none;">
					<ul>
						<li><a href="./index.html" role="menuitem">Home</a></li>
						<li><a href="./shop-grid.html" role="menuitem">Shop</a></li>
						<li class="slicknav_collapsed slicknav_parent"><a href="#" role="menuitem" aria-haspopup="true" tabindex="-1" class="slicknav_item slicknav_row" style="outline: none;"></a><a href="#">Pages</a>
								<span class="slicknav_arrow">►</span>
						<ul class="header__menu__dropdown slicknav_hidden" role="menu" aria-hidden="true" style="display: none;">
								<li><a href="./shop-details.html" role="menuitem" tabindex="-1">Shop Details</a></li>
								<li><a href="./shoping-cart.html" role="menuitem" tabindex="-1">Shoping Cart</a></li>
								<li><a href="./checkout.html" role="menuitem" tabindex="-1">Check
										Out</a></li>
							</ul></li>
						<li><a href="./contact.html" role="menuitem">Contact</a></li>
					</ul>
				</nav>
			</div>
		</div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-instagram"></i></a> <a href="#"><i class="fa fa-pinterest-p"></i></a>
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
								<li><i class="fa fa-envelope"></i> ccookg@gmail.com</li>
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
							<div class="header__top__right__auth">
								<a href="#"><i class="fa fa-user"></i> Login</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./index.html"><img src="/ccookat/Data/style/img/ccookat/ccookat_logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="./index.html">Home</a></li>
							<li><a href="./shop-grid.html">Shop</a></li>
							<li><a href="#">Pages</a>
								<ul class="header__menu__dropdown">
									<li><a href="./shop-details.html">Shop Details</a></li>
									<li><a href="./shoping-cart.html">Shoping Cart</a></li>
									<li><a href="./checkout.html">Check Out</a></li>
								</ul></li>
							<li><a href="./contact.html">Contact</a></li>
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
							<li><a href="#">Vegetables &amp; Fruit</a></li>
							<li><a href="#">Rice &amp; Noodle &amp; Bread</a></li>
							<li><a href="#">Fresh Meat &amp; Egg</a></li>
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
								<i class="fa fa-phone"></i>
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
						<h2>NOTICE</h2>
						<div class="breadcrumb__option"></div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Blog Section Begin -->
	<section class="blog spad">
		<div class="container">
			<div class="row">
				
				<div id="qna_list">
	<br><br><br>
	<div id="qna_title">질문과 답변<span class="sub">컬리에게 질문해 주시면 최대한 빠르게 답변해 드립니다.</span></div>
	
	<table>
		<tbody><tr>
			<th width="100">번호</th>
			<th width="500">제목</th>
			<th width="100">작성자</th>
			<th width="200">작성일</th>
		</tr>

		
			
			
			<tr>
				
				<td>16</td>
				

				
				<td class="subject">
										
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=75&amp;pageNum=1&amp;search=&amp;keyword=">
							배송 언제 오나요??
						</a>
					
				</td>
					
					<td style="color: black">
					
						monkey1004
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>15</td>
				

				
				<td class="subject">
										
					
						
						<span style="margin-left: 20px;">└[답변]</span>
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=76&amp;pageNum=1&amp;search=&amp;keyword=">
							배송준비중 입니다
						</a>
					
				</td>
					
					<td style="color: black">
					
					KurlyKurly
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>14</td>
				

				
				<td class="subject">
										
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=74&amp;pageNum=1&amp;search=&amp;keyword=">
							샤인머스캣 입고해 주세요!!
						</a>
					
				</td>
					
					<td style="color: black">
					
						monkey1004
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>13</td>
				

				
				<td class="subject">
										
					
						
						<span style="margin-left: 20px;">└[답변]</span>
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=77&amp;pageNum=1&amp;search=&amp;keyword=">
							본 상품은 입고 예정이 없습니다
						</a>
					
				</td>
					
					<td style="color: black">
					
					KurlyKurly
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>12</td>
				

				
				<td class="subject">
										
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=73&amp;pageNum=1&amp;search=&amp;keyword=">
							만두전골 없나요?
						</a>
					
				</td>
					
					<td style="color: black">
					
						abc123
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>11</td>
				

				
				<td class="subject">
										
					
						
						<span style="margin-left: 20px;">└[답변]</span>
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=78&amp;pageNum=1&amp;search=&amp;keyword=">
							해당 상품은 품절되었습니다
						</a>
					
				</td>
					
					<td style="color: black">
					
					KurlyKurly
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>10</td>
				

				
				<td class="subject">
										
					
					
					
					
						<span class="secret">🔒</span>
						
						
							작성자 또는 관리자만 확인 가능합니다.
							
					
				</td>
					
					<td style="color: black">
					
						abc123
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>9</td>
				

				
				<td class="subject">
										
					
						
						<span style="margin-left: 20px;">└[답변]</span>
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=79&amp;pageNum=1&amp;search=&amp;keyword=">
							배송지 변경 처리되었습니다
						</a>
					
				</td>
					
					<td style="color: black">
					
					KurlyKurly
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>8</td>
				

				
				<td class="subject">
										
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=71&amp;pageNum=1&amp;search=&amp;keyword=">
							아 갈비탕 맛없어요 ㅡㅡ 환불해주세요 
						</a>
					
				</td>
					
					<td style="color: black">
					
						abc123
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
			<tr>
				
				<td>7</td>
				

				
				<td class="subject">
										
					
						
						<span style="margin-left: 20px;">└[답변]</span>
					
					
					
					
						<a href="index.jsp?folder=qna&amp;category=qna_detail&amp;num=80&amp;pageNum=1&amp;search=&amp;keyword=">
							고객센터에 전화문의 부탁드립니다
						</a>
					
				</td>
					
					<td style="color: black">
					
					KurlyKurly
					
					</td>
		
					
					<td>
						
							2022-07-05
						
					</td>
			</tr>
			
		
	</tbody></table>
	
	
	
		
	<div id="num">
	
		[처음][이전]
	
	
	
		
			[1]
		
	
		
			<a href="index.jsp?folder=qna&amp;category=qna_list&amp;pageNum=2&amp;search=&amp;keyword=">[2]</a>
		
	
	
	
		[다음][마지막]
	
	</div>
	<br>
	
	<form action="index.jsp?folder=qna&amp;category=qna_list" method="post">
		
		<select name="search">
			<option value="q_name" selected="selected">&nbsp;작성자&nbsp;</option>
			<option value="q_title">&nbsp;제목&nbsp;</option>
			<option value="q_content">&nbsp;내용&nbsp;</option>
		</select>
		<input type="text" name="keyword">
		<button type="submit">검색</button>
	</form>
</div>
			</div>
		</div>
	</section>
	<!-- Blog Section End -->

	<!-- Related Blog Section Begin -->
	<section class="contact spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_phone"></span>
						<h4>Phone</h4>
						<p>+01-3-8888-6868</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_pin_alt"></span>
						<h4>Address</h4>
						<p>60-49 Road 11378 New York</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_clock_alt"></span>
						<h4>Open time</h4>
						<p>10:00 am to 23:00 pm</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 text-center">
					<div class="contact__widget">
						<span class="icon_mail_alt"></span>
						<h4>Email</h4>
						<p>hello@colorlib.com</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Related Blog Section End -->

	<!-- Footer Section Begin -->
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
								<a href="index.jsp?folder=qna&amp;category=qna_list" class="tit">질문
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
						팩스: 000 - 0000 - 0000 <span class="bar">I</span> 이메일 : <a class="link">help@ccookatcorp.com</a> <br> 대량주문 문의 : <a class="link">ccookatgift@ccookatcorp.com</a> <br>

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