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
<!-- menu -->
	<div class="menu-page">
		<div class="container">
			<div class="menu-title">
				<h3>訂購 嘉瑋盒餐</h3>
                <div class="line">
				</div>
                <br>
                <div class="well">
					<p>甜度 : 正常(100%)/少糖(80%)/半糖(50%)/微糖(30%)/淺糖(10%)/無糖(0%)</p><p>冰塊 : 正常/半冰/微冰/去冰</p><p>熱飲:500ml 冷飲:660ml</p><p>+5（珍珠/椰果）<br/>+10（蜂蜜/仙草/紅豆）<br/>+20（布丁）</p>
				</div>
				
			</div>
            
            <div class="bs-docs-example">
				<table class="table table-hover">
					<thead>
						<tr>
						  <th>名稱</th>
						  <th>價錢</th>
						  <th>數量</th>
                          <th></th>
						  <th>說明</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						  <td>阿薩姆紅茶</td>
						  <td>30</td>
						  <td class="qtyColumn" ><input size="2" maxlength="2" name="chooseProduct:categories:1:productOrderRequests:0:product:qty" id="addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty" type="text" class="qty" value=""/></td>
                           <td class="plusMinusColumn"><input name="chooseProduct:categories:1:productOrderRequests:0:product:plus" type="button" value="+" class="plusMinus" onclick="plus('addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty')"/>
                            <input name="chooseProduct:categories:1:productOrderRequests:0:product:minus" type="button" value="-" class="plusMinus" onclick="minus('addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty')"/></td>
						  <td class="commentColumn"><input name="chooseProduct:categories:5:productOrderRequests:2:product:comment" size="18" type="text" maxlength="40" value=""/></td>
						</tr>
						<tr>
						   <td>阿薩姆紅茶</td>
						  <td>30</td>
						  <td class="qtyColumn" ><input size="2" maxlength="2" name="chooseProduct:categories:1:productOrderRequests:0:product:qty" id="addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty" type="text" class="qty" value=""/></td>
                           <td class="plusMinusColumn"><input name="chooseProduct:categories:1:productOrderRequests:0:product:plus" type="button" value="+" class="plusMinus" onclick="plus('addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty')"/>
                            <input name="chooseProduct:categories:1:productOrderRequests:0:product:minus" type="button" value="-" class="plusMinus" onclick="minus('addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty')"/></td>
						  <td class="commentColumn"><input name="chooseProduct:categories:5:productOrderRequests:2:product:comment" size="18" type="text" maxlength="40" value=""/></td>
						</tr>
						<tr>
						   <td>阿薩姆紅茶</td>
						  <td>30</td>
						  <td class="qtyColumn" ><input size="2" maxlength="2" name="chooseProduct:categories:1:productOrderRequests:0:product:qty" id="addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty" type="text" class="qty" value=""/></td>
                           <td class="plusMinusColumn"><input name="chooseProduct:categories:1:productOrderRequests:0:product:plus" type="button" value="+" class="plusMinus" onclick="plus('addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty')"/>
                            <input name="chooseProduct:categories:1:productOrderRequests:0:product:minus" type="button" value="-" class="plusMinus" onclick="minus('addOrderItemForm_chooseProduct_categories_1_productOrderRequests_0_product_qty')"/></td>
						  <td class="commentColumn"><input name="chooseProduct:categories:5:productOrderRequests:2:product:comment" size="18" type="text" maxlength="40" value=""/></td>
						</tr>
					</tbody>
				</table>
                
                <div class="search">
						<h4>訂購人</h4>
						<form>
							<input type="text" value="帳號" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '帳號';}" required="">
							<input type="submit" value="結帳">
						</form>
					</div>
			</div>
			
		</div>
	</div>
<!-- //menu -->
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