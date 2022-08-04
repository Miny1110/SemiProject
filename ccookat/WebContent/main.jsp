<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Ogani | Template</title>

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
                <li><a href="./contact.html" role="menuitem">Contact</a></li>
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
									<li><a href="./shoping-cart.html">Shopping Cart</a></li>
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
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
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
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
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
                    <div class="hero__item set-bg" data-setbg="/ccookat/Data/style/img/hero/banner.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/hero/banner.jpg&quot;);">
                        <div class="hero__text">
                            <span>FRUIT FRESH</span>
                            <h2>Vegetable <br>100% Organic</h2>
                            <p>Free Pickup and Delivery Available</p>
                            <a href="#" class="primary-btn">SHOP NOW</a>
                        </div>
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
                <div class="categories__slider owl-carousel owl-loaded owl-drag">
                    
                    
                    
                    
                    
                <div class="owl-stage-outer"><div class="owl-stage" style="transform: translate3d(-4095px, 0px, 0px); transition: all 1.2s ease 0s; width: 11408px;"><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-4.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-4.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-5.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-5.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-2.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-2.jpg&quot;);">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-4.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-4.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-5.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-5.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-1.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-1.jpg&quot;);">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item animated owl-animated-in fadeIn cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-2.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-2.jpg&quot;);">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div><div class="owl-item" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-1.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-1.jpg&quot;);">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item animated owl-animated-in fadeIn" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-2.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-2.jpg&quot;);">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div><div class="owl-item" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-4.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-4.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item active" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-5.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-5.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned active" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned active" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-4.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-4.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned active" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-5.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-5.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-1.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-1.jpg&quot;);">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-2.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-2.jpg&quot;);">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-4.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-4.jpg&quot;);">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-1.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-1.jpg&quot;);">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item animated owl-animated-in fadeIn cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-2.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-2.jpg&quot;);">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div></div><div class="owl-item cloned" style="width: 292.5px;"><div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="/ccookat/Data/style/img/categories/cat-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/categories/cat-3.jpg&quot;);">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div></div></div></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span class="fa fa-angle-left"><span></span></span></button><button type="button" role="presentation" class="owl-next"><span class="fa fa-angle-right"><span></span></span></button></div><div class="owl-dots disabled"></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span class="fa fa-angle-left"><span></span></span></button><button type="button" role="presentation" class="owl-next"><span class="fa fa-angle-right"><span></span></span></button></div><div class="owl-dots disabled"></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span class="fa fa-angle-left"><span></span></span></button><button type="button" role="presentation" class="owl-next"><span class="fa fa-angle-right"><span></span></span></button></div><div class="owl-dots disabled"></div></div>
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
                        <h2>Featured Product</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active mixitup-control-active" data-filter="*">All</li>
                            <li data-filter=".Vegetables & Fruit" class="">Vegetables & Fruit</li>
                            <li data-filter=".Rice & Noodle & Bread" class="">Rice & Noodle & Bread</li>
                            <li data-filter=".Fresh Meat & Egg" class="">Fresh Meat & Egg</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter" id="MixItUp8D53A2" style="">
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-1.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-1.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables fastfood" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-2.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-2.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables fresh-meat" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-3.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-3.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood oranges" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-4.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-4.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-5.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-5.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fastfood" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="<%=cp %>/Data/style/img/featured/feature-6.jpg" style="background-image: url(&quot;<%=cp %>/Data/style/img/featured/feature-6.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-7.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-7.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood vegetables" style="">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="/ccookat/Data/style/img/featured/feature-8.jpg" style="background-image: url(&quot;/ccookat/Data/style/img/featured/feature-8.jpg&quot;);">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
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
                        <img src="/ccookat/Data/style/img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="/ccookat/Data/style/img/banner/banner-2.jpg" alt="">
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
						<a href="index.jsp?folder=qna&amp;category=qna_list" class="tit">질문 답변</a>
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