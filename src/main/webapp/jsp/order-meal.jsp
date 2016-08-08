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
  });
  
  function hide_tr()
{
alert("hide");
var result_style = document.getElementById('dyn_tr').style;
result_style.display = 'none';
}
//顯示TR
function show_tr()
{
alert("show");
var result_style = document.getElementById('dyn_tr').style;
result_style.display = 'table-row';
}
  
  
</script> 

<!-- banner -->
<div class="banner1">
                        <div class="container">
    <div class="header-nav">
                            <nav class="navbar navbar-default"> 
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                                <div class="logo"> <a class="navbar-brand" href="index.html">餓揪訂餐 <span>Healthy And Tasty Food</span></a> </div>
                              </div>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
            <li class="active"><a href="services.html">回首頁</a></li>
            <li><a href="menu.html">我要訂餐</a></li>
            <li><a href="order.html">發起訂餐</a></li>
            <li><a href="contact.html">聯絡我們</a></li>
            <li><a href="index.html">登出</a> </li>
          </ul>
                              </div>
        <!-- /.navbar-collapse --> 
      </nav>
                          </div>
  </div>
                      </div>
<!-- //banner --> 
<!-- services -->
<div class="services">
                        <div class="container">
                          <h3>發起訂餐                          </h3>
                          <div class="line"> </div>
    <a href="updatestores.html">改善店家內容...</a>
			<div class="bs-docs-example">
                <table class="table table-bordered01">
						<thead>
							<tr>
								<th></th>
								<th>店家資訊</th>
							</tr>
						</thead>
						<tbody>
							<tr>
						  <td>店名</td>
						  <td>麥當勞</td>
						</tr>
						<tr>
						  <td>電話</td>
						  <td>8888-8888</td>
						</tr>
                        <tr>
						  <td>地址</td>
						  <td>新北市新莊區中正路510號</td>
						</tr>
						<tr>
						  <td>店家服務類型</td>
						  <td>速食業</td>
						</tr>
                        <tr>
						  <td>備註</td>
						  <td>無</td>
						</tr>
						</tbody>
					</table> 
			</div>
    <div class="bs-docs-example">
     <table class="table table-bordered01">
						<thead>
							<tr>
								<th>產品清單</th>
								<th>細項價格</th>
							</tr>
						</thead>
						<tbody>
							<tr>
						  <td>一號餐</td>
						  <td>100</td>
						</tr>
						<tr>
						  <td>二號餐</td>
						  <td>100</td>
						</tr>
						<tr>
						  <td>三號餐</td>
						  <td>105</td>
						</tr>
						</tbody>
					</table> 
			</div>
             
    <div class="contact-center">
					<form>
						<input type="text" value="負責人" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '負責人';}" required="">
						<input type="text" value="截止時間" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '截止時間';}" required="">
						<input type="text" value="截止金額" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '截止金額';}" required="">
						<div class="clearfix"> </div>
						<textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '說明';}" required>說明</textarea>
						<input type="submit" value="送出">
					</form>
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