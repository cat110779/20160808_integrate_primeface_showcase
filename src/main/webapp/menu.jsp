<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>餓揪訂餐網站</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			start : function(slider) {
				$('body').removeClass('loading');
			}
		});
	});
</script>
<!-- //FlexSlider -->
</head>
<body>
	<%
		HttpSession se = request.getSession();
		if(se.getAttribute("account")==null){
			response.sendRedirect("Index.jsp");
		}
	
		String account =(String)se.getAttribute("account");
		OrderDAO oDao = new OrderDAO();
	
		List<Order> allOrder = new ArrayList<Order>();
		allOrder = oDao.getOnGoingOrder();
		
		long now = System.currentTimeMillis();
	%>
	<!-- banner -->
	<div class="banner1">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="logo">
						<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐 </b> <span>Healthy
								And Tasty Food</span></a>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="ServiceServelet">回首頁</a></li>
						<li class="active"><a href="menu.jsp">我要訂餐</a></li>
						<li><a href="order.jsp">發起訂餐</a></li>
						<li><a href="contact.jsp">聯絡我們</a></li>
						<li><a href="Index.jsp">登出</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse --> </nav>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- menu -->
	<div class="menu-page">
		<div class="container">
			<div class="services-grid">
				<div class="menu-title">
					<h3>我發起的訂餐</h3>
					<div class="line"></div>
				</div>
				<p class="proident">以下為你發起的訂單，選擇欲修改的訂單，進行修改。</p>
				<div class="menu-page-grids">

					<%
					for(Order o:allOrder){

						if(now-o.getEndTime().getTime()>0 || o.getMoney()>=o.getEndMoney()){	
							if(o.getMoney()>0)
								oDao.updateStatusByOrderId("已成立", o.getId());
							else
								oDao.updateStatusByOrderId("已截止", o.getId());								
						}else if(o.getMemberAccount().equals(account) && now-o.getEndTime().getTime()<0 ){
					%>
					
					<div class="col-md-4 menu-grids-info">
						<%if(o.getRtype().equals("便當")) {%>
							<img src="images/type/rice.jpg" alt="" title="" />
						<%}else if(o.getRtype().equals("速食")){ %>
							<img src="images/type/fast_food.jpg" alt="" title="" />
						<%}else if(o.getRtype().equals("日式")){ %>
							<img src="images/type/Japan.jpg" alt="" title="" />
						<%}else if(o.getRtype().equals("點心")){ %>
							<img src="images/type/snack.jpg" alt="" title="" />
						<%} %>
						<h4>
							<span>${account}發起</span>的 <span><%=o.getRestaurantName()%></span>
						</h4>
						<h4>
							<a href="Startservlet?order_id=<%=o.getId() %>&restaurantID=<%=o.getRestaurantId()%>">
							<span class="label label-danger">我要訂</span></a>
							<a href="order-meal.jsp?rId=<%=o.getRestaurantId()%>&oId=<%=o.getId()%>">
							<span class="label label-danger">我要修改</span></a>
						</h4>
						<div class="menu-rate">
							<h5>
								$<%=o.getMoney()%></h5>
						</div>
					</div>
					<%} 
				}%>
	
					<div class="clearfix"></div>
				</div>
				<!---728x90--->
				<div style="text-align: center;">
					<ins class="adsbygoogle"
						style="display: inline-block; width: 728px; height: 90px"
						data-ad-client="ca-pub-9153409599391170" data-ad-slot="6850850687"></ins>
					<script>
					<!--(adsbygoogle = window.adsbygoogle || []).push({});-->
						
					</script>
				</div>
			</div>
			<div class="menu-title">
				<h3>進行中的訂餐</h3>
				<div class="line"></div>
			</div>
			<div class="menu-page-grids">

				<%
					for(Order o:allOrder){
				      		if(!o.getMemberAccount().equals(account)  && now-o.getEndTime().getTime()<0 ){
				%>
				<div class="col-md-4 menu-grids-info">
					<%if(o.getRtype().equals("便當")) {%>
							<img src="images/type/rice.jpg" alt="" title="" />
						<%}else if(o.getRtype().equals("速食")){ %>
							<img src="images/type/fast_food.jpg" alt="" title="" />
						<%}else if(o.getRtype().equals("日式")){ %>
							<img src="images/type/Japan.jpg" alt="" title="" />
						<%}else if(o.getRtype().equals("點心")){ %>
							<img src="images/type/snack.jpg" alt="" title="" />
						<%} %>
						
					<h4>
						<span><%=o.getMemberAccount()%></span>發起的 <span><%=o.getRestaurantName()%></span>
					</h4>
					<h4>
						<a href="Startservlet?order_id=<%=o.getId() %>&restaurantID=<%=o.getRestaurantId()%>"><span class="label label-danger">我要訂</span></a>
					</h4>
					
					<div class="menu-rate">
						<h5>
							$<%=o.getMoney()%></h5>
					</div>
				</div>
				<%
						  }
				     }
				%>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //menu -->
	<!--footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>&copy; - Copyright 2016© All rights reserved.</p>
		</div>
	</div>
	<!--//footer-->
	<!-- for bootstrap working -->
	<script src="js/bootstrap.js">
		
	</script>
	<!-- //for bootstrap working -->
</body>
</html>