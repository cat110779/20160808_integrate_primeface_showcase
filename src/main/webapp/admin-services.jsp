<%@page import="org.greenpeace.bean.OrderSuper"%>
<%@page import="org.greenpeace.bean.Order"%>
<%@page import="org.greenpeace.bean.CustomerSuper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.greenpeace.bean.Deposit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		}else if(!((String)se.getAttribute("mtype")).equals("高級會員")){
			response.sendRedirect("ServiceServelet");
		}
	%>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})
	</script>

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
						<a class="navbar-brand" href="Index.jsp"><b>餓揪訂餐 </b><span>Healthy
								And Tasty Food</span></a>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="ServiceServelet">回首頁</a></li>
						<li><a href="menu.jsp">我要訂餐</a></li>
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
	<!-- services -->
	<div class="services">
		<div class="container">
			<h3>${account}的個人紀錄   (餘額 : <%=session.getAttribute("cash") %>)</h3>
			<div class="line"></div>
			<div class="grid_3 grid_5">
				<div class="bs-example bs-example-tabs" role="tabpanel"
					data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#home"
							id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
							aria-expanded="true">查詢儲值記錄</a></li>
						<li role="presentation"><a href="#profile" role="tab"
							id="profile-tab" data-toggle="tab" aria-controls="profile">查詢消費紀錄</a></li>
						<li role="presentation"><a href="#dropdown1" role="tab"
							id="dropdown1-tab" data-toggle="tab" aria-controls="profile">查詢訂單狀態</a></li>
						<li role="presentation"><a href="#dropdown2" role="tab"
							id="dropdown2-tab" data-toggle="tab" aria-controls="profile">查詢發起狀態</a></li>
						<li role="presentation" class="dropdown"><a href="#"
							id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"
							aria-controls="myTabDrop1-contents">管理者權限 <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu"
								aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
								<li><a href="card.jsp">儲值</a></li>
								<li><a href="take-meal.jsp">確認取餐</a></li>
							</ul>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="home"
							aria-labelledby="home-tab">
							<div class="bs-docs-example">
								<br>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>序號</th>
											<th>儲值金額</th>
											<th>儲值日期</th>
										</tr>
									</thead>
									<tbody>
										<!-- for迴圈跑Deposit資料 -->
										<%
											ArrayList<Deposit> list = null;
															if(request.getAttribute("depositlist") != null){
																list = (ArrayList<Deposit>)request.getAttribute("depositlist");
															} else {
																list = new ArrayList<Deposit>();
															}
														
															int index = 1;
															for(Deposit data : list){
										%>
										<tr>
											<td><%=index%></td>
											<td><%=data.getDepositCash()%></td>
											<td><%=data.getTime()%></td>
										</tr>
										<%
											index++;
															}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="profile"
							aria-labelledby="profile-tab">
							<div class="bs-docs-example">
								<br>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>編號</th>
											<th>品項</th>
											<th>數量</th>
											<th>消費金額</th>
											<!--                             <th>餘額</th> -->
											<th>消費日期</th>
										</tr>
									</thead>
									<tbody>
										<!-- for迴圈跑消費紀錄資料 -->
										<%
											ArrayList<CustomerSuper> customerList = null;
															if(request.getAttribute("customerList") != null){
																customerList = (ArrayList<CustomerSuper>)request.getAttribute("customerList");
															} else {
																customerList = new ArrayList<CustomerSuper>();
															}
														
															index = 1;
															for(CustomerSuper data : customerList){
										%>
										<tr>
											<td><%=index%></td>
											<td><%=data.getProduct_name()%></td>
											<td><%=data.getCounts()%></td>
											<td><%=data.getMoney()%></td>
											<%-- 							  <td><%=data.getL_money() %></td> --%>
											<td><%=data.getConsume_date()%></td>
										</tr>
										<%
											index++;
															}
										%>
									</tbody>
								</table>
							</div>

						</div>
						<div role="tabpanel" class="tab-pane fade" id="dropdown1"
							aria-labelledby="dropdown1-tab">
							<div class="bs-docs-example">
								<table class="table">
									<thead>
										<tr>
											<th>訂單編號</th>
											<th>發起人</th>
											<th>下定日期</th>
											<th>下定店家</th>
											<th>訂單狀態</th>
										</tr>
									</thead>
									<tbody>
										<!-- for迴圈跑訂單狀態資料 -->
										<%
											ArrayList<OrderSuper> orderList = null;
															if(request.getAttribute("orderList") != null){
																orderList = (ArrayList<OrderSuper>)request.getAttribute("orderList");
															} else {
																orderList = new ArrayList<OrderSuper>();
															}
														
															for(OrderSuper data : orderList){
										%>
										<tr>
											<td><%=data.getId()%></td>
											<td><%=data.getOrder_member()%></td>
											<td><%=data.getOrder_date()%></td>
											<td><%=data.getRestaurant_name()%></td>
											<td><%=data.getStatus()%></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
						
						<div role="tabpanel" class="tab-pane fade" id="dropdown2"
							aria-labelledby="dropdown2-tab">
							<div class="bs-docs-example">
								<table class="table">
									<thead>
										<tr>
											<th>訂單編號</th>
											<th>發起日期</th>
											<th>發起店家</th>
											<th>訂單狀態</th>
										</tr>
									</thead>
									<tbody>
										<%
										int count = 1;
										List<Order> myOrderList = null;
										if(request.getAttribute("myOrderList")!=null){
											myOrderList = (ArrayList<Order>)request.getAttribute("myOrderList");
										}else{
											myOrderList = new ArrayList<Order>();
										}
										for(Order o:myOrderList){
										%>
										<tr>
											<td><%=o.getId()%></td>
											<td><%=o.getBeginTimeStr()%></td>
											<td><%=o.getRestaurantName()%></td>
											<td><%=o.getStatus()%></td>
										</tr>
										<%
											count++;}
										%>
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