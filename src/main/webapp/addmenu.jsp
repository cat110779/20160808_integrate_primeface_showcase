<%@page import="java.util.List"%>
<%@page import="org.greenpeace.bean.Start"%>
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
<%
	HttpSession se = request.getSession();
	if(se.getAttribute("account")==null){
		response.sendRedirect("Index.jsp");
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
							<a class="navbar-brand" href="index.jsp"><b>餓揪訂餐 </b><span>Healthy And Tasty Food</span></a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					  <ul class="nav navbar-nav">
						<li><a href="ServiceServelet">回首頁</a></li>
						<li class="active"><a href="menu.jsp">我要訂餐</a></li>
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
<!-- menu -->
	<div class="menu-page">
		<div class="container">
			<div class="menu-title">
				<h3><%=request.getAttribute("restaurantName") %>  訂購 </h3>
                <div class="line">
				</div>
                <br>
               
				
			</div>
            
            <div class="bs-docs-example">
            
            <form action="CheckOutServlet" method="post">
                	
				<table class="table table-hover">
					<thead>
						<tr>
						  <th>名稱</th>
						  <th>價錢</th>
						  <th>數量</th>
                          <th></th>
						</tr>
					<tbody>
						
						<%
							List<Start> list = (List<Start>) request.getAttribute("startList");
							for(Start data : list) {
						%>
							<tr>
								<td>
									<%=data.getProduct_name() %>
									<input type="hidden" name="productName" value="<%=data.getProduct_name() %>" />
									<input type="hidden" name="item_id" value="<%=data.getItem_id() %>" />
									<input type="hidden" name="order_id" value="<%=data.getOrder_id() %>" />
								</td>
						  		<td>
						  			<%=data.getPrice() %>
						  			<input type="hidden" name="price" value="<%=data.getPrice() %>" />
						  		</td>
						  		<td class="qtyColumn" >
						  			<input type="number" value=0 min=0 max=99 name="counts" required="" />
						  			
						  		</td>
						  		<td>
						  		</td>
						  		
							</tr>
						<%
							}
						%>
						
					</tbody>
				</table>
                
                	<div class="search">
						<input type="submit" value="結帳">
					</div>
				</form>
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