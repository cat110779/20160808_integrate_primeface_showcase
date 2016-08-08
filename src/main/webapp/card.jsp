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
<script type="text/javascript">
	function ValidateNumber(e, pnumber)
	{
	    if (!/^\d{1,5}$/.test(pnumber))
	    {
	        e.value = /^\d{1,5}$/.exec(e.value);
	    }
	    return false;
	}
</script>

</head>
	
<body>
<%
	HttpSession se = request.getSession();
	if(se.getAttribute("account")==null){
		response.sendRedirect("Index.jsp");
	}else if(!((String)se.getAttribute("mtype")).equals("高級會員")){
		response.sendRedirect("ServiceServelet");
	}
%>
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
							<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐 </b><span>Healthy And Tasty Food</span></a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					  <ul class="nav navbar-nav">
						<li class="active"><a href="ServiceServelet">回首頁</a></li>
						<li><a href="menu.jsp">我要訂餐</a></li>
						<li><a href="order.jsp">發起訂餐</a></li>
						<li><a href="contact.jsp">聯絡我們</a></li>
                        <li><a href="Index.jsp">登出</a>  </li> 
					  </ul>
					</div><!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
	</div>
<!-- //banner -->
<!-- single -->
	<div class="single">
		<div class="container">
			<div class="services">
		<div class="container">
				<h3>管理員儲值系統</h3>
				<div class="line"></div> 
				</div>
				<div class="leave-a-comment">
				<form method="post" action="CardServlet">
                <fieldset style="text-align:center">
                <legend></legend>
					<input type="text" name="account" value="" style="color:#000" placeholder="會員帳號" required="">
					<br>
					<input type="text" name="cash" value="" style="color:#000" placeholder="金額" onkeyup="return ValidateNumber(this,value)" required="" >
					<!--<input type="text" value="管理者密碼" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '管理者密碼';}" required="">-->
                    <!-- <textarea type="text" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '備註';}" required>備註</textarea>-->
					<br>
					<input type="submit" value="儲值">
                    </fieldset>
				</form>
			</div>
		</div>
	</div>
<!-- //single -->
<!--footer-->
	<div class="footer-bottom">
		<div class="container">		
			<div class="container">		
			<p>&copy;  - Copyright 2016© All rights reserved.</p>					
		</div>					
		</div>
	</div>
<!--//footer-->	
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->
</body>
</html>