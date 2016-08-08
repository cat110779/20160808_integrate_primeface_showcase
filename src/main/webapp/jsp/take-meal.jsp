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
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js">
</script>
<!-- //js -->
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js">
</script>
<script defer src="js/color.js">
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
				<h3>確認取餐</h3>
                <div class="line">
				</div>
                <div class="well">
					訂單速覽 - 
					<form>
						<select name="訂單">
　							<option value="Taipei">方寺慈 - 心樂園Love land鮮果茶飲-南港店 (02-26516633   ) </option>
						</select>
					</form>
				</div>			
			</div>      
            <div class="bs-docs-example">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>產品</th>
							<th>數量</th>
							<th>單價</th>
							<th>訂購人</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>排骨便當</td>
							<td>一份</td>
							<td>60</td>
                            <td id='tbl1'>江明錡</td>
						</tr>
					</tbody>
				</table>
			</div>
                
          <div style="margin-top:1em;">
	<h4 >圖示說明：</h4>
	<table class="mergeView " style="color:#888;">
	  <tr><td class="cell done"><img src="images/k4.png" width="77" height="25" alt=""/></td>
	    <td> - 綠底的項目表示<b style="color:black;">已經取餐</b></td>
	    </tr>
	  </table>
      <br>
      <br>
      <h4>餐點已全部確認取餐，按確認取餐          <a href="#"><span class="label label-warning">確認成功</span></a></h4>
      
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
		<script src="js/bootstrap.js">
</script>
<!-- //for bootstrap working -->
</body>
</html>

