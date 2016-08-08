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
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })<!--(window,document,'script','//www.google-analytics.com/analytics.js','ga');-->
ga('create', 'UA-30027142-1', 'w3layouts.com');
  ga('send', 'pageview');
</script>
<!--
<script async type='text/javascript' src='//cdn.fancybar.net/ac/fancybar.js?zoneid=1502&serve=C6ADVKE&placement=w3layouts' id='_fancybar_js'></script>
-->

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
<!-- services -->
	<div class="services">
		<div class="container">
			
				<h3>${account}的個人紀錄</h3>
				<div class="line">
				</div>
				<div class="grid_3 grid_5">
				<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">查詢儲值記錄</a></li>
						<li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile">查詢消費紀錄</a></li>
						<li role="presentation"><a href="#dropdown1" role="tab" id="dropdown1-tab" data-toggle="tab" aria-controls="profile">查詢訂單狀態</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
			<div class="bs-docs-example">
            <br>
				<table class="table table-hover">
					<thead>
						<tr>
						  <th>序號</th>
						  <th>儲值金額</th>
						  <th>累積金額</th>
						  <th>儲值日期</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						  <td>1</td>
						  <td>1000</td>
						  <td>1000</td>
						  <td>2016/05/07</td>
						</tr>
						<tr>
						  <td>2</td>
						  <td>1000</td>
						  <td>2000</td>
						  <td>2016/05/07</td>
						</tr>
						<tr>
						  <td>3</td>
						  <td >500</td>
                          <td >2500</td>
						  <td>2016/05/07</td>
						</tr>
					</tbody>
				</table>
			</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
							<div class="bs-docs-example">
                            <br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>編號</th>
							<th>品項</th>
							<th>消費金額</th>
                            <th>餘額</th>
                            <th>消費日期</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="2">1</td>
							<td>漢堡</td>
                            <td>80</td>
                            <td>1000</td>
                            <td>2016/05/07</td>
						</tr>
						<tr>
							<td>可樂</td>
							<td>40</td>
                            <td>1000</td>
                            <td>2016/05/07</td>
						</tr>
						<tr>
							<td>2</td>
							<td>排骨便當</td>
							<td>80</td>
                            <td>1000</td>
                            <td>2016/05/07</td>
						</tr>
						<tr>
							<td>3</td>
							<td>排骨便當</td>
							<td>80</td>
                            <td>1000</td>
                            <td>2016/05/07</td>
						</tr>
					</tbody>
				</table>
			</div>

						</div>
						<div role="tabpanel" class="tab-pane fade" id="dropdown1" aria-labelledby="dropdown1-tab">
							<div class="bs-docs-example">
				<table class="table">
					<thead>
						<tr>
							<th>編號</th>
							<th>品項</th>
                            <th>消費日期</th>
                            <th>訂單狀態</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>漢堡</td>
                            <td>2016/05/07</td>
                            <td>已取餐</td>
						</tr>
						<tr>
							<td>2</td>
							<td>可樂</td>
                            <td>2016/05/07</td>
                            <td>已取餐</td>
						</tr>
						<tr>
							<td>3</td>
							<td>排骨便當</td>
                            <td>2016/05/07</td>
                            <td>已取餐</td>
						</tr>
                        <tr>
							<td>4</td>
							<td>排骨便當</td>
                            <td>2016/05/08</td>
                            <td>未取餐</td>
						</tr>
					</tbody>
				</table>
			</div>
						</div>
					</div>
				</div>
			</div>			
	</div>
    </div>
<!-- //services -->

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