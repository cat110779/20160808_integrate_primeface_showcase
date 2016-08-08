<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>餓揪訂餐網站</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
						$(window).load(function(){
						  $('.flexslider').flexslider({
							animation: "slide",
							start: function(slider){
							  $('body').removeClass('loading');
							}
						  });
						});
					  </script>
<!-- //FlexSlider -->
</head>
	
<body>
<!-- banner -->
	<div class="banner1">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
						<div class="logo">
							<a class="navbar-brand" href="index.html">餓揪訂餐 <span>Healthy And Tasty Food</span></a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					  <ul class="nav navbar-nav">
						<li class="active"><a href="services.html">回首頁</a></li>
						<li><a href="menu.html">我要訂餐</a></li>
						<li><a href="order.html">發起訂餐</a></li>
						<li><a href="contact.html">聯絡我們</a></li> 
                        <li><a href="index.html">登出</a>  </li> 
					  </ul>
					</div><!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
	</div>
<!-- //banner -->
<!-- contact -->
	<div class="contact">
		<div class="container">
			<h3>聯絡我們</h3>
			<div class="line">
			</div>
			<div class="contact-grid">
				<div class="contact-left">
					<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3056.9443837127305!2d-75.7983021!3d39.9873482!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0000000000000000%3A0x69c9c879a1263188!2sLutheran+Church+of+the+Good+Shepherd!5e0!3m2!1sen!2sin!4v1426659332982" frameborder="0" style="border:0"></iframe>
				</div>
				<div class="contact-right">
					<form>
						<input type="text" value="帳號" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '帳號';}" required="">
						<input type="email" value="信箱" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '信箱';}" required="">
						<input type="text" value="手機號碼" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '手機號碼';}" required="">
						<input type="text" value="主旨" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '主旨';}" required="">
						<div class="clearfix"> </div>
						<textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required>建議....</textarea>
						<input type="submit" value="送出">
					</form>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //contact -->
<!--footer-->
	<div class="footer-bottom">
		<div class="container">		
			<p>&copy;  - Copyright 2016© All rights reserved.</p>					
		</div>
	</div>
<!--//footer-->	
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->
</body>
</html>